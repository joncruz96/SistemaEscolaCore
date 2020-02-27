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
public class AlunoDto {

	@ApiModelProperty(value = "Forma ingresso do aluno.", required = true)
	@NotBlank(message = "{AlunoDTO.formaIngresso.NotBlank}")
	@Size(max = 60, message = "{AlunoDTO.formaIngresso.Size}")
	private String formaIngresso;

	@ApiModelProperty(value = "Documento CPF do aluno.", required = true)
	@NotBlank(message = "{AlunoDTO.cpf.NotBlank}")
	@Size(min = 11, max = 14, message = "{AlunoDTO.cpf.Size}")
	private String cpf;

	@ApiModelProperty(value = "Nome do aluno.", required = true)
	@NotBlank(message = "{AlunoDTO.nome.NotBlank}")
	private String nome;

	@ApiModelProperty(value = "Email do aluno.", required = true)
	@NotBlank(message = "{AlunoDTO.email.NotBlank}")
	private String email;

}
