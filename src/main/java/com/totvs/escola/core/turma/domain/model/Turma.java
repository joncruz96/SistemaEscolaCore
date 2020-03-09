package com.totvs.escola.core.turma.domain.model;

import java.util.List;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;

import com.totvs.escola.core.aluno.domain.model.AlunoId;
import com.totvs.escola.core.disciplina.domain.model.DisciplinaId;
import com.totvs.escola.core.turma.domain.enums.Semestre;
import com.totvs.tjf.core.stereotype.Aggregate;
import com.totvs.tjf.core.stereotype.AggregateIdentifier;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

@Aggregate
@Getter
public class Turma {

	@AggregateIdentifier
	private TurmaId turmaId;

	private String descricao;

	private String codigo;

	private int anoLetivo;

	@Enumerated(EnumType.STRING)
	private Semestre semestre;

	private int numeroVagas;

	private List<AlunoId> alunos;

	private List<DisciplinaId> disciplinas;

	@Builder
	public Turma(@NonNull TurmaId turmaId, @NonNull String descricao, @NotEmpty int anoLetivo,
			@NonNull Semestre semestre, @NotEmpty int numeroVagas, List<AlunoId> alunos,
			List<DisciplinaId> disciplinas) {

		this.turmaId = turmaId;
		this.descricao = descricao;
		this.codigo = gerarCodigo(anoLetivo, semestre);
		this.semestre = semestre;
		this.numeroVagas = numeroVagas;
		this.anoLetivo = anoLetivo;
		this.alunos = alunos;
		this.disciplinas = disciplinas;
	}

	public String gerarCodigo(int anoLetivo, Semestre semestre) {
		return semestre.name() == "PRIMEIRO" ? new String("Turma" + "01" + anoLetivo)
				: new String("Turma" + "02" + anoLetivo);
	}

}
