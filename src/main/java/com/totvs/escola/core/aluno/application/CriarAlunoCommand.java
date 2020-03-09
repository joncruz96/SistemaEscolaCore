package com.totvs.escola.core.aluno.application;

import com.totvs.escola.core.aluno.domain.enums.FormaIngresso;
import com.totvs.escola.core.pessoa.domain.model.CPF;

import lombok.Data;
import lombok.Getter;

@Getter
@Data(staticConstructor = "of")
public class CriarAlunoCommand {

	private final FormaIngresso formaIngresso;

	private final CPF cpf;

	private final String nome;

	private final String email;

}
