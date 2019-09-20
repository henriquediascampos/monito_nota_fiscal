package com.serviceRest.consultas.notaFicaleletronica;

import java.util.Objects;

/**
 * EStatus
 */
public enum EStatus {
    VERDE,
    AMARELO,
    VERMELHO;

	public static EStatus getLikeStatus(String argument) {
        for (EStatus status : EStatus.values()) {
            if (Objects.nonNull(argument)
                && argument.toUpperCase().contains(status.name()))
                return status;
        }
        return null;
	}

}