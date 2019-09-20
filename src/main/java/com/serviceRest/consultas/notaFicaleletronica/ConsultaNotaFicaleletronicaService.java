package com.serviceRest.consultas.notaFicaleletronica;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.springframework.stereotype.Service;

@Service
public interface ConsultaNotaFicaleletronicaService {
	void downloadHtmlStatusNotaFiscal()  throws IOException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
}