package com.serviceRest.job;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDateTime;

import com.serviceRest.consultas.notaFicaleletronica.ConsultaNotaFicaleletronicaService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class JobDownloadStatusNotaFicalEstados {

    private static final Logger log = LoggerFactory.getLogger(JobDownloadStatusNotaFicalEstados.class);
    private static final int CINCO_MINUTOS = 300000;

    @Autowired
    private ConsultaNotaFicaleletronicaService consultaNotaFicaleletronicaService;

    @Scheduled(fixedRate = CINCO_MINUTOS, initialDelay = CINCO_MINUTOS)
    public void reportCurrentTime()
            throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException {
        log.info("Iniciando Job de download da pagina HTML para extrair o status de nota fiscal eletronica dos estados ", LocalDateTime.now());
        consultaNotaFicaleletronicaService.downloadHtmlStatusNotaFiscal();
        log.info("finalizando Job ", LocalDateTime.now());
    }
}