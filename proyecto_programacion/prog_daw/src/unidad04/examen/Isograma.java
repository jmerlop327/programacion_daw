package unidad04.examen;

import java.util.Scanner;

public class Isograma {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		System.out.println("Introduzce un texto para ver si es un isograma");
		try {
			String texto = teclado.nextLine();
			StringBuilder textoLimpio = limpiarTexto(texto);
			if (esIsograma(textoLimpio)) {
				System.out.println("Es isograma");
			} else {
				System.out.println("No es isograma");
				mostrarLetrasRepetidas(textoLimpio);
			}

		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}

	}

	private static StringBuilder limpiarTexto(String texto) throws IllegalArgumentException {
		StringBuilder textoLimpioSb = new StringBuilder();
		final String patron = "[a-zñ0-9\\s]*";
		String textoMin = texto.toLowerCase();
		if (textoMin.matches(patron)) {
			textoLimpioSb = new StringBuilder(textoMin);
		} else {
			throw new IllegalArgumentException("Caracteres incorrectos");
		}
		return textoLimpioSb;
	}

	private static boolean esIsograma(StringBuilder text) {
		String caracteresValidos = "abcdefghijklmnñopqrstuvwxyz";
		boolean esIsograma = true;
		int index = 0;
		while (esIsograma && index < caracteresValidos.length()) {
			char actual = caracteresValidos.charAt(index);
			int indexTexto = 0;
			int repeticiones = 0;
			while (repeticiones <= 1 && indexTexto < text.length()) {
				if (actual == text.charAt(indexTexto)) {
					repeticiones++;
				}
				if (repeticiones > 1) {
					esIsograma = false;
				}
				indexTexto++;
			}
			index++;
		}
		return esIsograma;
	}

	private static void mostrarLetrasRepetidas(StringBuilder texto) {
		String caracteresValidos = "abcdefghijklmnñopqrstuvwxyz";
		for (char caracter : caracteresValidos.toCharArray()) {
			int repeticiones = 0;
			for (int i = 0; i < texto.length(); i++) {
				if (caracter == texto.charAt(i)) {
					repeticiones++;
				}
			}
			if (repeticiones > 1) {
				StringBuilder sb = new StringBuilder();
				sb.append(caracter).append(": ").append(repeticiones);
				System.out.println(sb);
			}
		}
	}
}
