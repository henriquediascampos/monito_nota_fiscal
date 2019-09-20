package com.serviceRest.consultas.notaFicaleletronica;

import static java.util.Objects.nonNull;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.serviceRest.util.LabelIdentification;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsultaNotaFicaleletronicaServiceImpl implements ConsultaNotaFicaleletronicaService {

	private StatusNotaFiscalEstadosRepositoryService statusNotaFiscalEstadosRepository;

	@Autowired
	ConsultaNotaFicaleletronicaServiceImpl(StatusNotaFiscalEstadosRepositoryService statusNotaFiscalEstadosRepository) {
		this.statusNotaFiscalEstadosRepository = statusNotaFiscalEstadosRepository;
	}

	@Override
	public void downloadHtmlStatusNotaFiscal() throws IOException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Document doc = Jsoup.connect("http://www.nfe.fazenda.gov.br/portal/disponibilidade.aspx").get();
		Elements newsHeadlines = doc.select("#conteudoDinamico>div>table.tabelaListagemDados");

		LocalDateTime dataUltimaAtualizacao = null;
		List<StatusNotaFiscalEstados> listTables = new ArrayList<>();
		for (Element table : newsHeadlines) {
			List<String> campos = mappedColumTable(table.getElementsByTag("tr").get(0));
			Element caption = getCaptionVersion(table);
			if (!nonNull(dataUltimaAtualizacao))
				dataUltimaAtualizacao = getdataUltimaAtualizacao(caption);
			for (Element tr : table.getElementsByTag("tr")) {
				listTables.add(montaentidade(tr, campos, caption, dataUltimaAtualizacao));
			}
		}

		statusNotaFiscalEstadosRepository.saveAll(listTables);
	}

	private Element getCaptionVersion(Element table) {
		Elements caption = table.getElementsByTag("caption");
		return caption.stream()
			.filter(tag -> tag.getElementsByTag("span").size() > 0)
			.map(tag -> tag.getElementsByTag("span").get(0)).findFirst().get();
	}

	private LocalDateTime getdataUltimaAtualizacao(Element caption) {
		String value = caption.text();

		if (nonNull(value) && !value.isEmpty()) {
			String[] values = value.split("-");
			String stringData = Arrays.asList(values).stream()
				.filter(text -> text.contains("Última Verificação"))
				.findFirst()
				.map(text -> {
					String formatado = text
						.replaceAll("Última Verificação: ", "");
					return formatado.trim();
				}).get();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
				return LocalDateTime.parse(stringData, formatter);
		}
		return null;
	}
	private StatusNotaFiscalEstados montaentidade(Element tr, List<String> campos, Element caption, LocalDateTime dataUltimaAtualizacao)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		StatusNotaFiscalEstados statusNotaFiscalEstados = geneteNew(caption, dataUltimaAtualizacao);

		List<String>  cloned = new ArrayList<String>(campos);
		for (Element td : tr.getElementsByTag("td")) {
			Method method = getMethodSet(statusNotaFiscalEstados, cloned.get(0));
			if(!td.text().isEmpty()) {
				method.invoke(statusNotaFiscalEstados, td.text());
			} else if (!td.getElementsByTag("img").isEmpty()) {
				String argument = td.getElementsByTag("img").get(0).attr("src");
				EStatus status = EStatus.getLikeStatus(argument);
				method.invoke(statusNotaFiscalEstados, status);
			}
			cloned.remove(0);
		}

		return statusNotaFiscalEstados;
	}

	private StatusNotaFiscalEstados geneteNew(Element caption, LocalDateTime dataUltimaAtualizacao) {
		StatusNotaFiscalEstados statusNotaFiscalEstados = new StatusNotaFiscalEstados();
		String value = caption.text();

		if (nonNull(value) && !value.isEmpty()) {
			String[] values = value.split("-");
			String versao = Arrays.asList(values).stream()
				.filter(text -> {
					return text.contains("WebServices Vers");
				})
				.map(text -> {
					String pattern = "[^0-9+.]";
					return text.replaceAll(pattern, "");
				}).findFirst().orElse(null);
			statusNotaFiscalEstados.setVersao(versao);
			statusNotaFiscalEstados.setDataUltimaAtualizacao(dataUltimaAtualizacao);
		}
		return statusNotaFiscalEstados;
	}

	private Method getMethodSet(Object entity, String label) {
		Field[] fields = entity.getClass().getDeclaredFields();
		for (Field field : fields) {
			String labelName = getLabelName(field);
			if (labelName.equalsIgnoreCase(label)) {
				return getMethod(field, entity.getClass());
			}
		}

		return null;
	}

	private String getLabelName(Field field) {
		return nonNull( field.getAnnotation(LabelIdentification.class) )
			? field.getAnnotation(LabelIdentification.class).labelName() : field.getName();
	}

	private Method getMethod(Field field, Class<? extends Object> clazz) {
		return Arrays.asList(clazz.getDeclaredMethods())
			.stream()
			.filter(method ->
				Arrays.asList(method.getParameters()).stream()
					.filter(p -> p.getName().equalsIgnoreCase(field.getName()))
					.count() > 0 )
			.findAny().get();
	}

	private List<String> mappedColumTable(Element tr) {
		List<String> campos = new ArrayList<>();
		for (Element th : tr.getElementsByTag("th")) {
			campos.add(th.text());
		}
		return campos;
	}

}