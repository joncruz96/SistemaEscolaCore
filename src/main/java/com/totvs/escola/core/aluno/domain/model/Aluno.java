package com.totvs.escola.core.aluno.domain.model;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.totvs.escola.core.aluno.domain.enums.FormaIngresso;
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
public class Aluno extends Pessoa {

	@AggregateIdentifier
	private AlunoId alunoId;

	private String matricula;

	@Enumerated(EnumType.STRING)
	private FormaIngresso formaIngresso;

	@Builder
	public Aluno(@NonNull String nome, @NonNull String email, @NonNull CPF cpf, @NonNull AlunoId alunoId,
			@NonNull FormaIngresso formaIngresso) {
		super(nome, email, cpf);
		this.alunoId = alunoId;
		this.formaIngresso = formaIngresso;
		this.matricula = gerarMatricula();
	}

	public String gerarMatricula() {
		return this.getCpf().toString();
	}

}
