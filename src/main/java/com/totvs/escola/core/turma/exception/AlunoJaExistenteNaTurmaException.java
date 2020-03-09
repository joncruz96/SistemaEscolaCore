package com.totvs.escola.core.turma.exception;

import com.totvs.tjf.api.context.stereotype.ApiErrorParameter;
import com.totvs.tjf.api.context.stereotype.error.ApiBadRequest;

@ApiBadRequest("AlunoJaExistenteNaTurmaException")
public class AlunoJaExistenteNaTurmaException extends RuntimeException {

	private static final long serialVersionUID = 2100396918453973429L;

	@ApiErrorParameter
	private final String aluno;

	public AlunoJaExistenteNaTurmaException(String aluno) {
		this.aluno = aluno;
	}

}
