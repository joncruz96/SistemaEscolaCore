package com.totvs.escola.core.aluno.domain.model;

import java.util.UUID;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@EqualsAndHashCode
@Getter
@NoArgsConstructor
public class AlunoId {

	private UUID id;

	private AlunoId(UUID id) {
		this.id = id;
	}

	public static AlunoId generate() {
		return new AlunoId(UUID.randomUUID());
	}

	public static AlunoId fromString(String value) {
		return new AlunoId(UUID.fromString(value));
	}

	@Override
	public String toString() {
		return id.toString();
	}
}
