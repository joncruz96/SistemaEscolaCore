package com.totvs.escola.core.aluno.api;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CriarAlunoDto {

	@ApiModelProperty(value = "Forma ingresso do aluno.", required = true)
	@NotBlank(message = "{AlunoDto.formaIngresso.NotBlank}")
	@Size(max = 60, message = "{AlunoDto.formaIngresso.Size}")
	private String formaIngresso;

	@ApiModelProperty(value = "Matrícula do aluno.", required = false)
	private String matricula;

	@ApiModelProperty(value = "Documento CPF do aluno.", required = true)
	@NotBlank(message = "{AlunoDto.cpf.NotBlank}")
	@Size(min = 11, max = 14, message = "{AlunoDto.cpf.Size}")
	private String cpf;

	@ApiModelProperty(value = "Nome do aluno.", required = true)
	@NotBlank(message = "{AlunoDto.nome.NotBlank}")
	private String nome;

	@ApiModelProperty(value = "Email do aluno.", required = true)
	@NotBlank(message = "{AlunoDto.email.NotBlank}")
	private String email;

}
