package com.totvs.escola.core.disciplina.domain.model;

import java.util.UUID;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@EqualsAndHashCode
@Getter
@NoArgsConstructor
public class DisciplinaId {

	private UUID id;

	private DisciplinaId(UUID id) {
		this.id = id;
	}

	public static DisciplinaId generate() {
		return new DisciplinaId(UUID.randomUUID());
	}

	public static DisciplinaId fromString(String value) {
		return new DisciplinaId(UUID.fromString(value));
	}

	@Override
	public String toString() {
		return id.toString();
	}

}
