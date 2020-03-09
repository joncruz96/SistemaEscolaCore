package com.totvs.escola.core.professor.api;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CriarProfessorDto {

	@ApiModelProperty(value = "Titulacao do aluno.", required = true)
	@NotBlank(message = "{ProfessorDto.titulacao.NotBlank}")
	private String titulacao;

	@ApiModelProperty(value = "Documento CPF do aluno.", required = true)
	@NotBlank(message = "{ProfessorDto.cpf.NotBlank}")
	@Size(min = 11, max = 14, message = "{AlunoDto.cpf.Size}")
	private String cpf;

	@ApiModelProperty(value = "Nome do aluno.", required = true)
	@NotBlank(message = "{ProfessorDto.nome.NotBlank}")
	private String nome;

	@ApiModelProperty(value = "Email do aluno.", required = true)
	@NotBlank(message = "{ProfessorDto.email.NotBlank}")
	private String email;

}
