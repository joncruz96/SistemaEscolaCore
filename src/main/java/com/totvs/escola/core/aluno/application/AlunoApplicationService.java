package com.totvs.escola.core.aluno.application;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.totvs.escola.core.aluno.amqp.events.AlunoCriadoEvent;
import com.totvs.escola.core.aluno.domain.model.Aluno;
import com.totvs.escola.core.aluno.domain.model.AlunoId;
import com.totvs.escola.core.aluno.repository.AlunoRepository;
import com.totvs.escola.core.amqp.EscolaPublisher;
import com.totvs.escola.core.pessoa.exception.CpfJaExistenteException;

@Service
@Transactional
public class AlunoApplicationService {

	@Autowired
	private AlunoRepository repository;

	private EscolaPublisher sistemaEscolaCorePublisher;

	public AlunoApplicationService(AlunoRepository repository, EscolaPublisher sistemaEscolaCorePublisher) {
		this.repository = repository;
		this.sistemaEscolaCorePublisher = sistemaEscolaCorePublisher;
	}

	public AlunoId handle(CriarAlunoCommand cmd) {
		Aluno aluno = Aluno.builder().alunoId(AlunoId.generate()).cpf(cmd.getCpf()).email(cmd.getEmail())
				.nome(cmd.getNome()).formaIngresso(cmd.getFormaIngresso()).build();

		if (this.repository.checkIfExistsByCpf(cmd.getCpf().toString()))
			throw new CpfJaExistenteException(cmd.getCpf().toString());

		repository.insert(aluno);

		AlunoCriadoEvent event = AlunoCriadoEvent.builder().id(aluno.getAlunoId().toString())
				.formaIngresso(aluno.getFormaIngresso().toString()).cpf(aluno.getCpf().toString())
				.email(aluno.getEmail()).matricula(aluno.getMatricula()).nome(aluno.getNome()).build();

		sistemaEscolaCorePublisher.publish(event, AlunoCriadoEvent.NAME);

		return aluno.getAlunoId();
	}

}
