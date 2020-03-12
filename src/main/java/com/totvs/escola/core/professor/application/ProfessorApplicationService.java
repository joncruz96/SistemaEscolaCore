package com.totvs.escola.core.professor.application;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.totvs.escola.core.amqp.EscolaPublisher;
import com.totvs.escola.core.pessoa.exception.CpfJaExistenteException;
import com.totvs.escola.core.professor.amqp.events.ProfessorCriadoEvent;
import com.totvs.escola.core.professor.domain.model.Professor;
import com.totvs.escola.core.professor.domain.model.ProfessorId;
import com.totvs.escola.core.professor.repository.ProfessorRepository;

@Service
@Transactional
public class ProfessorApplicationService {

	@Autowired
	private ProfessorRepository repository;

	private EscolaPublisher sistemaEscolaCorePublisher;

	public ProfessorApplicationService(ProfessorRepository repository,
			EscolaPublisher sistemaEscolaCorePublisher) {
		this.repository = repository;
		this.sistemaEscolaCorePublisher = sistemaEscolaCorePublisher;
	}

	public ProfessorId handle(CriarProfessorCommand cmd) {

		Professor professor = Professor.builder().professorId(ProfessorId.generate()).titulacao(cmd.getTitulacao())
				.nome(cmd.getNome()).cpf(cmd.getCpf()).email(cmd.getEmail()).build();

		if (this.repository.checkIfExistsByCpf(cmd.getCpf().toString()))
			throw new CpfJaExistenteException(cmd.getCpf().toString());

		repository.insert(professor);

		ProfessorCriadoEvent event = ProfessorCriadoEvent.builder().professorId(professor.getProfessorId().toString())
				.cpf(professor.getCpf().toString()).email(professor.getEmail()).nome(professor.getNome())
				.titulacao(professor.getTitulacao()).build();

		sistemaEscolaCorePublisher.publish(event, ProfessorCriadoEvent.NAME);

		return professor.getProfessorId();
	}

}
