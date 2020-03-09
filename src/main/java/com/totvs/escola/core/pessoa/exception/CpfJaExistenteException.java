package com.totvs.escola.core.pessoa.exception;

import com.totvs.tjf.api.context.stereotype.ApiErrorParameter;
import com.totvs.tjf.api.context.stereotype.error.ApiBadRequest;

@ApiBadRequest("CpfJaExistenteException")
public class CpfJaExistenteException extends RuntimeException {

	private static final long serialVersionUID = 2100396918453973429L;

	@ApiErrorParameter
	private final String cpf;

	public CpfJaExistenteException(String cpf) {
		this.cpf = cpf;
	}

}
