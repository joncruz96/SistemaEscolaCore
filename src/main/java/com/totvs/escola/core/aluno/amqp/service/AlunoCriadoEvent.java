package com.totvs.escola.core.aluno.amqp.service;

import com.totvs.escola.core.aluno.domain.enums.FormaIngresso;
import com.totvs.escola.core.aluno.domain.model.AlunoId;
import com.totvs.escola.core.aluno.domain.model.CPF;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public final class AlunoCriadoEvent {

	@NonNull
	private AlunoId matricula;

	@NonNull
	private FormaIngresso formaIngresso;

	@NonNull
	private CPF cpf;

	@NonNull
	private String nome;

	@NonNull
	private String email;

}
