package com.totvs.escola.core.aluno.repository;

import javax.persistence.EntityManager;

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

}

//@Repository
//public class AlunoRepository extends CrudAggregateRepository<Aluno, String> {
//
//	public AlunoRepository(EntityManager em, ObjectMapper mapper) {
//		super(em, mapper.copy());
//	}
//
//}
