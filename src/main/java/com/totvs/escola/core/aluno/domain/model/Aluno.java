package com.totvs.escola.core.aluno.domain.model;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.totvs.escola.core.aluno.domain.enums.FormaIngresso;
import com.totvs.tjf.core.stereotype.Aggregate;
import com.totvs.tjf.core.stereotype.AggregateIdentifier;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Aggregate
@Setter
@Getter
public class Aluno extends Pessoa {

	@AggregateIdentifier
	private AlunoId alunoId;

	@Enumerated(EnumType.STRING)
	private FormaIngresso formaIngresso;

	@Builder
	public Aluno(@NonNull String nome, @NonNull String email, @NonNull CPF cpf, AlunoId alunoId,
			FormaIngresso formaIngresso) {
		super(nome, email, cpf);
		this.alunoId = alunoId;
		this.formaIngresso = formaIngresso;
	}

	@Override
	public String toString() {
		return "Aluno [ " + super.toString() + ", matricula=" + this.getAlunoId() + ", formaIngresso="
				+ this.getFormaIngresso() + " ]";
	}

}
