package com.totvs.escola.core.aluno.application;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.totvs.escola.core.aluno.domain.model.Aluno;
import com.totvs.escola.core.aluno.domain.model.AlunoId;
import com.totvs.escola.core.aluno.repository.AlunoRepository;

@Service
@Transactional
public class AlunoApplicationService {

	@Autowired
	private AlunoRepository repository;

	public AlunoApplicationService(AlunoRepository repository) {
		this.repository = repository;
	}

	public AlunoId handle(AlunoCommand cmd) {
		Aluno aluno = Aluno.builder().alunoId(AlunoId.generate()).email(cmd.getEmail()).nome(cmd.getNome())
				.formaIngresso(cmd.getFormaIngresso()).cpf(cmd.getCpf()).build();
		repository.insert(aluno);

		return aluno.getAlunoId();
	}

}
