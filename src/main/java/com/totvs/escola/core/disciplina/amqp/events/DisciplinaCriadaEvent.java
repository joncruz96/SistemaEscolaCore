package com.totvs.escola.core.disciplina.amqp.events;

import javax.validation.constraints.NotEmpty;

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
public class DisciplinaCriadaEvent {

	@NonNull
	private String disciplinaId;

	@NonNull
	private String descricao;

	@NonNull
	private String sigla;

	@NotEmpty
	private int cargaHoraria;

	@NonNull
	private String professorId;

}
