package com.totvs.escola.core.turma.exception;

import com.totvs.tjf.api.context.stereotype.ApiErrorParameter;
import com.totvs.tjf.api.context.stereotype.error.ApiBadRequest;

@ApiBadRequest("CodigoTurmaJaExistenteException")
public class CodigoTurmaJaExistenteException extends RuntimeException {

	private static final long serialVersionUID = 2100396918453973429L;

	@ApiErrorParameter
	private final String codigo;

	public CodigoTurmaJaExistenteException(String codigo) {
		this.codigo = codigo;
	}

}
