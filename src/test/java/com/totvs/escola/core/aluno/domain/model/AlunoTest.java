package com.totvs.escola.core.aluno.domain.model;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.totvs.escola.core.aluno.domain.enums.FormaIngresso;
import com.totvs.escola.core.pessoa.domain.model.CPF;
import com.totvs.escola.core.turma.domain.enums.Semestre;
import com.totvs.escola.core.turma.domain.model.Turma;
import com.totvs.escola.core.turma.domain.model.TurmaId;

public class AlunoTest {

	Turma turma01 = Turma.builder().turmaId(TurmaId.generate()).descricao("Computacao2020/01").numeroVagas(20)
			.semestre(Semestre.PRIMEIRO).build();

	Turma turma02 = Turma.builder().turmaId(TurmaId.generate()).descricao("Computacao2020/02").numeroVagas(15)
			.semestre(Semestre.SEGUNDO).build();

	private Aluno newAluno() {
		return Aluno.builder().cpf(CPF.from("131.401.956-21")).email("jonathan.luan@hotmail.com").nome("Jon")
				.alunoId(AlunoId.generate()).formaIngresso(FormaIngresso.ENADE).build();
	}

	private List<TurmaId> criaTurma() {
		List<TurmaId> listaTurmas = new ArrayList<>();

		listaTurmas.add(turma01.getTurmaId());
		listaTurmas.add(turma02.getTurmaId());

		return listaTurmas;
	}

	private String gerarMatricula() {
		return new String();
	}

	@Test
	public void alunoDeveCriar() {
		var aluno = this.newAluno();
		assertNotNull(aluno);
	}

}
