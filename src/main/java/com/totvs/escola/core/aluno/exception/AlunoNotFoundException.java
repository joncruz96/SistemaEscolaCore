package com.totvs.escola.core.aluno.exception;

import com.totvs.tjf.api.context.stereotype.ApiErrorParameter;
import com.totvs.tjf.api.context.stereotype.error.ApiNotFound;

import lombok.Getter;

@ApiNotFound("AlunoNotFoundException")
@Getter
public class AlunoNotFoundException {

	private static final long serialVersionUID = 2100396918453973429L;

	@ApiErrorParameter
	private final String aluno;

	public AlunoNotFoundException(String aluno) {
		this.aluno = aluno;
	}

}
