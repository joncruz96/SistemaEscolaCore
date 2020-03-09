package com.totvs.escola.core.aluno.repository;

import java.sql.Types;

import javax.persistence.EntityManager;

import org.springframework.jdbc.core.SqlParameterValue;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.totvs.escola.core.aluno.domain.model.Aluno;
import com.totvs.escola.core.aluno.domain.model.AlunoDomainRepository;
import com.totvs.tjf.repository.aggregate.CrudAggregateRepository;

@Repository
public class AlunoRepository extends CrudAggregateRepository<Aluno, String> implements AlunoDomainRepository {

	public AlunoRepository(EntityManager em, ObjectMapper mapper) {
		super(em, mapper.copy());
	}

	@Override
	protected String getTableName() {
		return "aluno";
	}

	@Override
	public boolean checkIfExistsByCpf(String cpf) {
		return this.exists("data->'cpf'->>'valor' = ?", new SqlParameterValue(Types.VARCHAR, cpf));
	}

}