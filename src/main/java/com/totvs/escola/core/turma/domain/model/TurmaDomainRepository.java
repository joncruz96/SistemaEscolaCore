package com.totvs.escola.core.turma.domain.model;

import com.totvs.tjf.repository.aggregate.AggregateRepository;

public interface TurmaDomainRepository extends AggregateRepository<Turma, String> {

	/* Verificar se já existe o código de identificação da turma */
	boolean checkIfExistsByCodigo(String codigo);

	boolean checkIfExistsByAlunos(String aluno);

}
