package com.totvs.escola.core.turma.api;

import java.util.ArrayList;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.totvs.escola.core.aluno.domain.model.AlunoId;
import com.totvs.escola.core.disciplina.domain.model.DisciplinaId;
import com.totvs.escola.core.turma.application.CriarTurmaCommand;
import com.totvs.escola.core.turma.application.TurmaApplicationService;
import com.totvs.escola.core.turma.domain.enums.Semestre;
import com.totvs.escola.core.turma.domain.model.TurmaId;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(path = "/api/v1/turma", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
public class TurmaController {

	@Autowired
	private TurmaApplicationService service;

	@PostMapping
	@ApiOperation(value = "Cadastrar uma nova Turma.", httpMethod = "POST", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Turma cadastrada com sucesso."),
			@ApiResponse(code = 400, message = "A Turma não pode ser cadastrada pois possui alguma informação inválida.") })
	public ResponseEntity<Void> criar(@RequestBody CriarTurmaDto dto) {

		var cmd = CriarTurmaCommand.of(dto.getDescricao(), Semestre.valueOf(dto.getSemestre()), dto.getNumeroVagas(),
				dto.getAnoLetivo(),
				dto.getAlunos() != null ? dto.getAlunos().stream().map(AlunoId::fromString).collect(Collectors.toList())
						: new ArrayList<>(),
				dto.getDisciplinas() != null
						? dto.getDisciplinas().stream().map(DisciplinaId::fromString).collect(Collectors.toList())
						: new ArrayList<>());

		TurmaId id = service.handle(cmd);

		var uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/").path(id.toString()).build().toUri();

		return ResponseEntity.created(uri).build();
	}

}
