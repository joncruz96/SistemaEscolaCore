package com.totvs.escola.core.turma.exception;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import com.totvs.tjf.api.context.stereotype.error.ApiBadRequest;

@ApiBadRequest("TurmaNotFoundException")
public class TurmaNotFoundException extends ConstraintViolationException {

	private static final long serialVersionUID = 2100396918453973429L;

	public TurmaNotFoundException(Set<? extends ConstraintViolation<?>> constraintViolations) {
		super(constraintViolations);
	}

}
