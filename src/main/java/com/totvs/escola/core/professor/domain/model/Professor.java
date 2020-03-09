package com.totvs.escola.core.professor.domain.model;

import com.totvs.escola.core.pessoa.domain.model.CPF;
import com.totvs.escola.core.pessoa.domain.model.Pessoa;
import com.totvs.tjf.core.stereotype.Aggregate;
import com.totvs.tjf.core.stereotype.AggregateIdentifier;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Aggregate
@Getter
@ToString
public class Professor extends Pessoa {

	@AggregateIdentifier
	private ProfessorId professorId;

	private String titulacao;

	@Builder
	public Professor(@NonNull String nome, @NonNull String email, @NonNull CPF cpf, @NonNull ProfessorId professorId,
			@NonNull String titulacao) {
		super(nome, email, cpf);
		this.professorId = professorId;
		this.titulacao = titulacao;
	}

}
