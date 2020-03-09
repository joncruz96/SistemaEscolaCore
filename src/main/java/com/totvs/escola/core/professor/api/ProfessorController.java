package com.totvs.escola.core.professor.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.totvs.escola.core.pessoa.domain.model.CPF;
import com.totvs.escola.core.professor.application.CriarProfessorCommand;
import com.totvs.escola.core.professor.application.ProfessorApplicationService;
import com.totvs.escola.core.professor.domain.model.ProfessorId;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(path = "/api/v1/professor", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
public class ProfessorController {

	@Autowired
	private ProfessorApplicationService service;

	@PostMapping
	@ApiOperation(value = "Cadastrar um novo Professor.", httpMethod = "POST", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Professor cadastrado com sucesso."),
			@ApiResponse(code = 400, message = "O Professor não pode ser cadastrado pois possui alguma informação inválida.") })
	public ResponseEntity<Void> criar(@RequestBody CriarProfessorDto dto) {

		var cmd = CriarProfessorCommand.of(CPF.from(dto.getCpf()), dto.getTitulacao(), dto.getEmail(), dto.getNome());

		ProfessorId id = service.handle(cmd);

		var uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/").path(id.toString()).build().toUri();

		return ResponseEntity.created(uri).build();
	}

}
