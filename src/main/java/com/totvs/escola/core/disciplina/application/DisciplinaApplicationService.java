package com.totvs.escola.core.disciplina.application;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.totvs.escola.core.amqp.EscolaPublisher;
import com.totvs.escola.core.disciplina.amqp.events.DisciplinaCriadaEvent;
import com.totvs.escola.core.disciplina.domain.model.Disciplina;
import com.totvs.escola.core.disciplina.domain.model.DisciplinaId;
import com.totvs.escola.core.disciplina.repository.DisciplinaRepository;

@Service
@Transactional
public class DisciplinaApplicationService {

	private DisciplinaRepository repository;

	private EscolaPublisher sistemaEscolaCorePublisher;

	public DisciplinaApplicationService(DisciplinaRepository repository,
			EscolaPublisher sistemaEscolaCorePublisher) {
		this.repository = repository;
		this.sistemaEscolaCorePublisher = sistemaEscolaCorePublisher;
	}

	public DisciplinaId handle(CriarDisciplinaCommand cmd) {
		Disciplina disciplina = Disciplina.builder().disciplinaId(DisciplinaId.generate())
				.cargaHoraria(cmd.getCargaHoraria()).descricao(cmd.getDescricao()).sigla(cmd.getSigla())
				.professorId(cmd.getProfessorId()).build();

		repository.insert(disciplina);

		DisciplinaCriadaEvent event = DisciplinaCriadaEvent.builder()
				.disciplinaId(disciplina.getDisciplinaId().toString()).descricao(disciplina.getDescricao())
				.cargaHoraria(disciplina.getCargaHoraria()).sigla(disciplina.getSigla())
				.professorId(disciplina.getProfessorId().toString()).build();

		sistemaEscolaCorePublisher.publish(event, DisciplinaCriadaEvent.NAME);

		return disciplina.getDisciplinaId();
	}

}
