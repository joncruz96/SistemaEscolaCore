package com.totvs.escola.core.professor.repository;

import java.sql.Types;

import javax.persistence.EntityManager;

import org.springframework.jdbc.core.SqlParameterValue;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.totvs.escola.core.professor.domain.model.Professor;
import com.totvs.escola.core.professor.domain.model.ProfessorDomainRepository;
import com.totvs.tjf.repository.aggregate.CrudAggregateRepository;

@Repository
public class ProfessorRepository extends CrudAggregateRepository<Professor, String>
		implements ProfessorDomainRepository {

	public ProfessorRepository(EntityManager em, ObjectMapper mapper) {
		super(em, mapper);
	}

	@Override
	protected String getTableName() {
		return "professor";
	}

	@Override
	public boolean checkIfExistsByCpf(String cpf) {
		return this.exists("data->'cpf'->>'numero' = ?", new SqlParameterValue(Types.VARCHAR, cpf));
	}

}
