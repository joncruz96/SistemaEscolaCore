package com.totvs.escola.core.disciplina.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.totvs.escola.core.disciplina.application.CriarDisciplinaCommand;
import com.totvs.escola.core.disciplina.application.DisciplinaApplicationService;
import com.totvs.escola.core.disciplina.domain.model.DisciplinaId;
import com.totvs.escola.core.professor.domain.model.ProfessorId;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(path = "/api/v1/disciplina", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
public class DisciplinaController {

	@Autowired
	private DisciplinaApplicationService service;

	@PostMapping
	@ApiOperation(value = "Cadastrar uma nova Disciplina.", httpMethod = "POST", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Disciplina cadastrada com sucesso."),
			@ApiResponse(code = 400, message = "A Disciplina não pode ser cadastrada pois possui alguma informação inválida.") })
	public ResponseEntity<Void> criar(@RequestBody CriarDisciplinaDto dto) {

		var cmd = CriarDisciplinaCommand.of(dto.getDescricao(), dto.getSigla(), dto.getCargaHoraria(),
				ProfessorId.fromString(dto.getProfessorId()));

		DisciplinaId id = service.handle(cmd);

		var uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/").path(id.toString()).build().toUri();

		return ResponseEntity.created(uri).build();
	}

}
