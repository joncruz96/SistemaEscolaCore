package com.totvs.escola.core.aluno.domain.model;

import static java.util.FormattableFlags.ALTERNATE;
import static java.util.Objects.requireNonNull;
import static lombok.AccessLevel.PRIVATE;

import java.util.Formattable;
import java.util.Formatter;

import com.google.common.base.Preconditions;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
@AllArgsConstructor(access = PRIVATE)
public final class CPF implements Formattable, Comparable<CPF> {

	private final String valor;

	public static CPF from(String valor) {

		requireNonNull(valor);

		String digitos = valor.replaceAll("\\D", "");

		Preconditions.checkArgument(digitos.matches("\\d{11}"));
		Preconditions.checkArgument(!digitos.matches("(\\d)\\1+"));
		Preconditions.checkArgument(isValido(digitos.substring(0, 10)));
		Preconditions.checkArgument(isValido(digitos));

		return new CPF(digitos);
	}

	static boolean isValido(String digitos) {
		if (Long.parseLong(digitos) % 10 == 0) {
			return somaPonderada(digitos) % 11 < 2;
		} else {
			return somaPonderada(digitos) % 11 == 0;
		}
	}

	static int somaPonderada(String digitos) {
		char[] cs = digitos.toCharArray();
		int soma = 0;
		for (int i = 0; i < cs.length; i++) {
			soma += Character.digit(cs[i], 10) * (cs.length - i);
		}
		return soma;
	}

	@Override
	public String toString() {
		return valor;
	}

	@Override
	public void formatTo(Formatter formatter, int flags, int width, int precision) {

		StringBuilder sb = new StringBuilder();

		boolean alternate = (flags & ALTERNATE) == ALTERNATE;

		if (alternate) {

			sb.append(valor);

			while (width > sb.length()) {
				sb.insert(0, '0');
			}
		} else {
			sb.append(String.format("%s.%s.%s-%s", valor.substring(0, 3), valor.substring(3, 6), valor.substring(6, 9),
					valor.substring(9)));
		}

		formatter.format(sb.toString());
	}

	@Override
	public int compareTo(CPF outro) {
		return valor.compareToIgnoreCase(outro.valor);
	}
}
