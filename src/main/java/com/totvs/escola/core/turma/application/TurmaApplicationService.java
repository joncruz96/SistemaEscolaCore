package com.totvs.escola.core.turma.application;

import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.totvs.escola.core.aluno.repository.AlunoRepository;
import com.totvs.escola.core.amqp.EscolaPublisher;
import com.totvs.escola.core.turma.amqp.events.TurmaCriadaEvent;
import com.totvs.escola.core.turma.domain.model.Turma;
import com.totvs.escola.core.turma.domain.model.TurmaId;
import com.totvs.escola.core.turma.exception.AlunosTurmaNotFoundException;
import com.totvs.escola.core.turma.exception.CodigoTurmaJaExistenteException;
import com.totvs.escola.core.turma.repository.TurmaRepository;

@Service
@Transactional
public class TurmaApplicationService {

	@Autowired
	private TurmaRepository turmaRepository;

	private AlunoRepository alunoRepository;

	private EscolaPublisher sistemaEscolaCorePublisher;

	public TurmaApplicationService(TurmaRepository turmaRepository, AlunoRepository alunoRepository,
			EscolaPublisher sistemaEscolaCorePublisher) {
		this.turmaRepository = turmaRepository;
		this.alunoRepository = alunoRepository;
		this.sistemaEscolaCorePublisher = sistemaEscolaCorePublisher;
	}

	public TurmaId handle(CriarTurmaCommand cmd) {
		Turma turma = Turma.builder().turmaId(TurmaId.generate()).descricao(cmd.getDescricao())
				.anoLetivo(cmd.getAnoLetivo()).semestre(cmd.getSemestre()).numeroVagas(cmd.getNumeroVagas())
				.alunos(cmd.getAlunos().stream().distinct().collect(Collectors.toList()))
				.disciplinas(cmd.getDisciplinas().stream().distinct().collect(Collectors.toList())).build();

		if (this.turmaRepository.checkIfExistsByCodigo((turma.getCodigo())))
			throw new CodigoTurmaJaExistenteException(turma.getCodigo());

		turma.getAlunos().forEach(aluno -> {
			if (this.alunoRepository.checkIfNotExistsByAluno(aluno.getId().toString()))
				throw new AlunosTurmaNotFoundException(aluno.getId().toString());
		});

		turmaRepository.insert(turma);

		TurmaCriadaEvent event = TurmaCriadaEvent.builder().turmaId(turma.getTurmaId().toString())
				.descricao(turma.getDescricao()).anoLetivo(turma.getAnoLetivo())
				.semestre(turma.getSemestre().toString()).numeroVagas(turma.getNumeroVagas())
				.alunos(turma.getAlunos().stream().map(String::valueOf).collect(Collectors.toList()))
				.disciplinas(turma.getDisciplinas().stream().map(String::valueOf).collect(Collectors.toList())).build();

		sistemaEscolaCorePublisher.publish(event, TurmaCriadaEvent.NAME);

		return turma.getTurmaId();
	}

}
