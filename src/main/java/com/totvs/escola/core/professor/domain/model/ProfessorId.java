package com.totvs.escola.core.professor.domain.model;

import java.util.UUID;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@EqualsAndHashCode
@Getter
@NoArgsConstructor
public class ProfessorId {

	private UUID id;

	private ProfessorId(UUID id) {
		this.id = id;
	}

	public static ProfessorId generate() {
		return new ProfessorId(UUID.randomUUID());
	}

	public static ProfessorId fromString(String value) {
		return new ProfessorId(UUID.fromString(value));
	}

	@Override
	public String toString() {
		return id.toString();
	}

}
