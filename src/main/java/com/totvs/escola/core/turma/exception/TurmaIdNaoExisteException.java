package com.totvs.escola.core.turma.exception;

import com.totvs.tjf.api.context.stereotype.ApiErrorParameter;

public class TurmaIdNaoExisteException extends RuntimeException {

	private static final long serialVersionUID = 2100396918453973429L;

	@ApiErrorParameter
	private final String codigo;

	public TurmaIdNaoExisteException(String codigo) {
		this.codigo = codigo;
	}

}
