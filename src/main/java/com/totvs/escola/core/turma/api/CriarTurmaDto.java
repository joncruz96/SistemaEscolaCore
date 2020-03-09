package com.totvs.escola.core.turma.api;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CriarTurmaDto {

	@ApiModelProperty(value = "Descricao da turma.", required = true)
	@NotBlank(message = "{CriarTurmaDto.descricao.NotBlank}")
	@Size(max = 60, message = "{CriarTurmaDto.descricao.Size}")
	private String descricao;

	@ApiModelProperty(value = "Periodo Letivo da turma.", required = true)
	@NotBlank(message = "{CriarTurmaDto.semestre.NotBlank}")
	private String semestre;

	@ApiModelProperty(value = "Numero de Vagas da turma.", required = true)
	@NotBlank(message = "{CriarTurmaDto.numeroVagas.NotBlank}")
	private int numeroVagas;

	@ApiModelProperty(value = "Ano Letivo da turma.", required = true)
	@NotBlank(message = "{CriarTurmaDto.anoLetivo.NotBlank}")
	private int anoLetivo;

	@ApiModelProperty(value = "Alunos da turma.", required = false)
	private List<String> alunos;

	@ApiModelProperty(value = "Disciplinas da turma.", required = false)
	private List<String> disciplinas;

}
