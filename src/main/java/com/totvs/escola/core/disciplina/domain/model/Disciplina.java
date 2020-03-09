package com.totvs.escola.core.disciplina.domain.model;

import com.totvs.escola.core.professor.domain.model.ProfessorId;
import com.totvs.tjf.core.stereotype.Aggregate;
import com.totvs.tjf.core.stereotype.AggregateIdentifier;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

@Aggregate
@Getter
public class Disciplina {

	@AggregateIdentifier
	private DisciplinaId disciplinaId;

	private String descricao;

	private String sigla;

	private int cargaHoraria;

	private ProfessorId professorId;

	@Builder
	public Disciplina(@NonNull DisciplinaId disciplinaId, @NonNull String descricao, @NonNull String sigla,
			int cargaHoraria, @NonNull ProfessorId professorId) {
		this.disciplinaId = disciplinaId;
		this.descricao = descricao;
		this.sigla = sigla;
		this.cargaHoraria = cargaHoraria;
		this.professorId = professorId;
	}

}
