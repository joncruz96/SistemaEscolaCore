package com.totvs.escola.core.turma.repository;

import java.sql.Types;

import javax.persistence.EntityManager;

import org.springframework.jdbc.core.SqlParameterValue;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.totvs.escola.core.turma.domain.model.Turma;
import com.totvs.escola.core.turma.domain.model.TurmaDomainRepository;
import com.totvs.tjf.repository.aggregate.CrudAggregateRepository;

@Repository
public class TurmaRepository extends CrudAggregateRepository<Turma, String> implements TurmaDomainRepository {

	public TurmaRepository(EntityManager em, ObjectMapper mapper) {
		super(em, mapper.copy());
	}

	@Override
	protected String getTableName() {
		return "turma";
	}

	@Override
	public boolean checkIfExistsByCodigo(String codigo) {
		return this.exists("data->>'codigo' = ?", new SqlParameterValue(Types.VARCHAR, codigo));
	}

	/*
	 * Verificar esta validacao é um array no banco de dados para validar os alunos
	 * da turma que esta sendo criada
	 */
	@Override
	public boolean checkIfExistsByAlunos(String aluno) {
		return this.exists("data->>'alunos' = ?", new SqlParameterValue(Types.VARCHAR, aluno));
	}

}