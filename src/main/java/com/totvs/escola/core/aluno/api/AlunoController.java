package com.totvs.escola.core.aluno.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.totvs.escola.core.aluno.application.AlunoApplicationService;
import com.totvs.escola.core.aluno.application.AlunoCommand;
import com.totvs.escola.core.aluno.domain.enums.FormaIngresso;
import com.totvs.escola.core.aluno.domain.model.AlunoId;
import com.totvs.escola.core.aluno.domain.model.CPF;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(path = "/api/v1/alunos", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
public class AlunoController {

	@Autowired
	private AlunoApplicationService service;

	@PostMapping
	@ApiOperation(value = "Cadastrar um novo Aluno.", httpMethod = "POST", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Aluno cadastrado com sucesso."),
			@ApiResponse(code = 400, message = "O Aluno não pode ser cadastrado pois possui alguma informação inválida.") })
	public ResponseEntity<Void> criar(@RequestBody AlunoDto dto) {

		var cmd = AlunoCommand.of(FormaIngresso.valueOf(dto.getFormaIngresso()), CPF.from(dto.getCpf()), dto.getEmail(),
				dto.getNome());

		AlunoId id = service.handle(cmd);

		var uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/").path(id.toString()).build().toUri();

		return ResponseEntity.created(uri).build();
	}

}
