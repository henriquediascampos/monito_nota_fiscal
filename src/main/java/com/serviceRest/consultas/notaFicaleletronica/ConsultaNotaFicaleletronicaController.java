package com.serviceRest.consultas.notaFicaleletronica;

import com.google.gson.Gson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/consulta")
public class ConsultaNotaFicaleletronicaController {

	private StatusNotaFiscalEstadosRepositoryService statusNotaFiscalEstadosRepository;

	@Autowired
	ConsultaNotaFicaleletronicaController(StatusNotaFiscalEstadosRepositoryService statusNotaFiscalEstadosRepository) {
		this.statusNotaFiscalEstadosRepository = statusNotaFiscalEstadosRepository;
	}

	@GetMapping(path = "/all")
	public @ResponseBody Iterable<StatusNotaFiscalEstados> getAllUsers() {
		// This returns a JSON or XML with the users
		Iterable<StatusNotaFiscalEstados> list = statusNotaFiscalEstadosRepository.findAll();
		System.out.println(list);
		return list;
	}

	@GetMapping(path = "/")
	public @ResponseBody String teste() {
		return "Serviço Online";
	}

	@GetMapping(path = "/findAll")
	public @ResponseBody String findAll() {
		Iterable<StatusNotaFiscalEstados> list = statusNotaFiscalEstadosRepository.findAll();
		Gson json = new Gson();
		return json.toJson(list);
	}

}