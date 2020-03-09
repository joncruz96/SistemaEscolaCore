package com.totvs.escola.core.disciplina.application;

import com.totvs.escola.core.professor.domain.model.ProfessorId;

import lombok.Data;
import lombok.Getter;

@Getter
@Data(staticConstructor = "of")
public class CriarDisciplinaCommand {

	private final String descricao;

	private final String sigla;

	private final int cargaHoraria;

	private final ProfessorId professorId;

}
