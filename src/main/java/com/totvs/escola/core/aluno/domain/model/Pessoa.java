package com.totvs.escola.core.aluno.domain.model;

import com.totvs.tjf.core.stereotype.Aggregate;
import com.totvs.tjf.core.stereotype.AggregateIdentifier;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

@ToString
@Aggregate
@Getter
@NoArgsConstructor
@AllArgsConstructor
public abstract class Pessoa {

	@AggregateIdentifier
	private CPF cpf;
	private String nome;
	private String email;

	public Pessoa(@NonNull String nome, @NonNull String email, @NonNull CPF cpf) {
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
	}

}
