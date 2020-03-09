package com.totvs.escola.core.professor.exception;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import com.totvs.tjf.api.context.stereotype.error.ApiBadRequest;

@ApiBadRequest("ProfessorNotFoundException")
public class ProfessorNotFoundException extends ConstraintViolationException {

	private static final long serialVersionUID = 2100396918453973429L;

	public ProfessorNotFoundException(Set<? extends ConstraintViolation<?>> constraintViolations) {
		super(constraintViolations);
	}

}
