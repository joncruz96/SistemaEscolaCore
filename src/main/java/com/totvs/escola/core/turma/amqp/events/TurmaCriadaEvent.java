package com.totvs.escola.core.turma.amqp.events;

import java.util.List;

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
public class TurmaCriadaEvent {

	@NonNull
	private String turmaId;

	@NonNull
	private String descricao;

	@NotEmpty
	private int anoLetivo;

	@NonNull
	private String semestre;

	@NotEmpty
	private int numeroVagas;

	@NonNull
	private List<String> alunos;

	@NonNull
	private List<String> disciplinas;

}
