package com.totvs.escola.core.turma.application;

import java.util.List;

import com.totvs.escola.core.aluno.domain.model.AlunoId;
import com.totvs.escola.core.disciplina.domain.model.DisciplinaId;
import com.totvs.escola.core.turma.domain.enums.Semestre;

import lombok.Data;
import lombok.Getter;

@Getter
@Data(staticConstructor = "of")
public class CriarTurmaCommand {

	private final String descricao;

	private final Semestre semestre;

	private final int numeroVagas;

	private final int anoLetivo;

	private final List<AlunoId> alunos;

	private final List<DisciplinaId> disciplinas;

}
