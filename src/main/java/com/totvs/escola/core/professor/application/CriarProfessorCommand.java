package com.totvs.escola.core.professor.application;

import com.totvs.escola.core.pessoa.domain.model.CPF;

import lombok.Data;
import lombok.Getter;

@Getter
@Data(staticConstructor = "of")
public class CriarProfessorCommand {

	private final CPF cpf;

	private final String nome;

	private final String email;

	private final String titulacao;

}
