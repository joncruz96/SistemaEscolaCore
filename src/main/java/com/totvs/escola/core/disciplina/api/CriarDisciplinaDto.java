package com.totvs.escola.core.disciplina.api;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CriarDisciplinaDto {

	@ApiModelProperty(value = "Descricao da disciplina.", required = true)
	@NotBlank(message = "{CriarDisciplinaDto.descricao.NotBlank}")
	@Size(max = 60, message = "{CriarDisciplinaDto.descricao.Size}")
	private String descricao;

	@ApiModelProperty(value = "Sigla da disciplina.", required = true)
	@NotBlank(message = "{CriarDisciplinaDto.sigla.NotBlank}")
	@Size(max = 6, message = "{CriarDisciplinaDto.sigla.Size}")
	private String sigla;

	@ApiModelProperty(value = "Carga horaria da disciplina.", required = true)
	private int cargaHoraria;

	@ApiModelProperty(value = "Professor da turma.", required = true)
	@NotBlank(message = "{CriarTurmaDto.professorId.NotBlank}")
	private String professorId;

}
