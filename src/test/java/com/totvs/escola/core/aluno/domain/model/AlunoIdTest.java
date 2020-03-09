package com.totvs.escola.core.aluno.domain.model;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class AlunoIdTest {

	@Test
	public void deveGerarUUID() {
		AlunoId id = AlunoId.generate();
		assertNotNull(id);
	}

	@Test
	public void deveGerarUUIDFromString() {
		String id = "63897109-cffd-49a9-b1ee-04d03bf59286";

		AlunoId alunoId = AlunoId.fromString(id);
		assertEquals(alunoId.toString(), id);

		System.out.println(alunoId.toString() + " -----> " + id);
	}

	@Test
	public void deveRetornarTipoString() {
		AlunoId id = AlunoId.generate();
		assertNotNull(id);
	}

	@Test
	public void naoDeveConstruirAoPassarValorNull() {
		assertThatExceptionOfType(NullPointerException.class).isThrownBy(() -> AlunoId.fromString(null));
	}

}
