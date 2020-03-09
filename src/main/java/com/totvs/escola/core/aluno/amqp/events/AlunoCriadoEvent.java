package com.totvs.escola.core.aluno.amqp.events;

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
	private String alunoId;

	@NonNull
	private String formaIngresso;

	@NonNull
	private String matricula;

	@NonNull
	private String cpf;

	@NonNull
	private String nome;

	@NonNull
	private String email;

}
