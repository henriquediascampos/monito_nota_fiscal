package com.serviceRest.consultas.notaFicaleletronica;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.serviceRest.util.LabelIdentification;

@Entity

public class StatusNotaFiscalEstados {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @LabelIdentification(labelName = "versao")
    private String versao;

    @LabelIdentification(labelName = "dataUltimaAtualizacao")
    private LocalDateTime dataUltimaAtualizacao;

    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime at_create;

    private LocalDateTime at_update;

    @Column(columnDefinition = "boolean default false")
    private Boolean excluido;

    @LabelIdentification(labelName = "Autorizador")
    private String Autorizador;

    @LabelIdentification(labelName = "Autorização")
    private EStatus Autorizacao;

    @LabelIdentification(labelName = "Retorno Autorização")
    private EStatus RetornoAutorizacao;

    @LabelIdentification(labelName = "Inutilização")
    private EStatus Inutilizacao;

    @LabelIdentification(labelName = "Consulta Protocolo")
    private EStatus ConsultaProtocolo;

    @LabelIdentification(labelName = "Status Serviço")
    private EStatus StatusServico;

    @LabelIdentification(labelName = "Consulta Cadastro")
    private EStatus ConsultaCadastro;

    @LabelIdentification(labelName = "Recepção Evento")
    private EStatus RecepcaoEvento;

    @LabelIdentification(labelName = "Autorização4")
    private EStatus Autorizacao4;

    @LabelIdentification(labelName = "Retorno Autorização4")
    private EStatus RetornoAutorizacao4;

    @LabelIdentification(labelName = "Inutilização4")
    private EStatus Inutilizacao4;

    @LabelIdentification(labelName = "Consulta Protocolo4")
    private EStatus ConsultaProtocolo4;

    @LabelIdentification(labelName = "Status Serviço4")
    private EStatus StatusServico4;

    @LabelIdentification(labelName = "Tempo Médio")
    private String TempoMedio;

    @LabelIdentification(labelName = "Consulta Cadastro4")
    private EStatus ConsultaCadastro4;

    @LabelIdentification(labelName = "Recepção Evento4")
    private EStatus RecepcaoEvento4;

    public Long getId() {
        return id;
    }

    public Boolean getExcluido() {
        return excluido;
    }

    public void setExcluido(Boolean excluido) {
        this.excluido = excluido;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVersao() {
        return versao;
    }

    public void setVersao(String versao) {
        this.versao = versao;
    }

    public LocalDateTime getAt_create() {
        return at_create;
    }

    public void setAt_create(LocalDateTime at_create) {
        this.at_create = at_create;
    }

    public LocalDateTime getAt_update() {
        return at_update;
    }

    public void setAt_update(LocalDateTime at_update) {
        this.at_update = at_update;
    }

    public String getAutorizador() {
        return Autorizador;
    }

    public void setAutorizador(String autorizador) {
        Autorizador = autorizador;
    }

    public EStatus getAutorizacao() {
        return Autorizacao;
    }

    public void setAutorizacao(EStatus autorizacao) {
        Autorizacao = autorizacao;
    }

    public EStatus getRetornoAutorizacao() {
        return RetornoAutorizacao;
    }

    public void setRetornoAutorizacao(EStatus retornoAutorizacao) {
        RetornoAutorizacao = retornoAutorizacao;
    }

    public EStatus getInutilizacao() {
        return Inutilizacao;
    }

    public void setInutilizacao(EStatus inutilizacao) {
        Inutilizacao = inutilizacao;
    }

    public EStatus getConsultaProtocolo() {
        return ConsultaProtocolo;
    }

    public void setConsultaProtocolo(EStatus consultaProtocolo) {
        ConsultaProtocolo = consultaProtocolo;
    }

    public EStatus getStatusServico() {
        return StatusServico;
    }

    public void setStatusServico(EStatus statusServico) {
        StatusServico = statusServico;
    }

    public EStatus getConsultaCadastro() {
        return ConsultaCadastro;
    }

    public void setConsultaCadastro(EStatus consultaCadastro) {
        ConsultaCadastro = consultaCadastro;
    }

    public EStatus getRecepcaoEvento() {
        return RecepcaoEvento;
    }

    public void setRecepcaoEvento(EStatus recepcaoEvento) {
        RecepcaoEvento = recepcaoEvento;
    }

    public EStatus getAutorizacao4() {
        return Autorizacao4;
    }

    public void setAutorizacao4(EStatus autorizacao4) {
        Autorizacao4 = autorizacao4;
    }

    public EStatus getRetornoAutorizacao4() {
        return RetornoAutorizacao4;
    }

    public void setRetornoAutorizacao4(EStatus retornoAutorizacao4) {
        RetornoAutorizacao4 = retornoAutorizacao4;
    }

    public EStatus getInutilizacao4() {
        return Inutilizacao4;
    }

    public void setInutilizacao4(EStatus inutilizacao4) {
        Inutilizacao4 = inutilizacao4;
    }

    public EStatus getConsultaProtocolo4() {
        return ConsultaProtocolo4;
    }

    public void setConsultaProtocolo4(EStatus consultaProtocolo4) {
        ConsultaProtocolo4 = consultaProtocolo4;
    }

    public EStatus getStatusServico4() {
        return StatusServico4;
    }

    public void setStatusServico4(EStatus statusServico4) {
        StatusServico4 = statusServico4;
    }

    public String getTempoMedio() {
        return TempoMedio;
    }

    public void setTempoMedio(String tempoMedio) {
        TempoMedio = tempoMedio;
    }

    public EStatus getConsultaCadastro4() {
        return ConsultaCadastro4;
    }

    public void setConsultaCadastro4(EStatus consultaCadastro4) {
        ConsultaCadastro4 = consultaCadastro4;
    }

    public EStatus getRecepcaoEvento4() {
        return RecepcaoEvento4;
    }

    public void setRecepcaoEvento4(EStatus recepcaoEvento4) {
        RecepcaoEvento4 = recepcaoEvento4;
    }

	public void setDataUltimaAtualizacao(String dataUltimaAtualizacao) {
	}

    public LocalDateTime getDataUltimaAtualizacao() {
        return dataUltimaAtualizacao;
    }

    public void setDataUltimaAtualizacao(LocalDateTime dataUltimaAtualizacao) {
        this.dataUltimaAtualizacao = dataUltimaAtualizacao;
    }

}
