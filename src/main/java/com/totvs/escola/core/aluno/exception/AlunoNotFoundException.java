package com.totvs.escola.core.aluno.exception;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import com.totvs.tjf.api.context.stereotype.error.ApiBadRequest;

@ApiBadRequest("AlunoNotFoundException")
public class AlunoNotFoundException extends ConstraintViolationException {

	private static final long serialVersionUID = 2100396918453973429L;

	public AlunoNotFoundException(Set<? extends ConstraintViolation<?>> constraintViolations) {
		super(constraintViolations);
	}

}
