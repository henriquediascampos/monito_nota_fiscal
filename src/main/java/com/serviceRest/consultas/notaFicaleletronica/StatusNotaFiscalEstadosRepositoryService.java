package com.serviceRest.consultas.notaFicaleletronica;


import org.springframework.data.repository.CrudRepository;

public interface StatusNotaFiscalEstadosRepositoryService extends CrudRepository<StatusNotaFiscalEstados, Long> {

    StatusNotaFiscalEstados findById(long id);

}