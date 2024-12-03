package unidad04;

import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;

public class EjemploAbecedario {

	public static void main(String[] args) {
		// EXTRA: parametrizamos el rango de caracteres
		Scanner scanner = new Scanner(System.in);
		System.out.println("Introduce el caracter inicial");
		String input = scanner.nextLine();
		try {
			if (input.length() != 1) {
				throw new IllegalArgumentException();
			}
			char caracterInicial = input.charAt(0);
			System.out.println("Introduce el caracter final");
			input = scanner.nextLine();
			if (input.length() != 1) {
				throw new IllegalArgumentException();
			}
			char caracterFinal = input.charAt(0);
			scanner.close();
			if (caracterFinal < caracterInicial) {
				throw new IllegalArgumentException();
			}
			int dimension = 1 + caracterFinal - caracterInicial;
			char[] caracteres = new char[dimension];
			char caracterActual = caracterInicial;
			for (int indice = 0; indice < dimension; indice++) {
				caracteres[indice] = caracterActual++;
			}

			System.out.println("Mostramos los caracteres del array");
			String output = StringUtils.EMPTY;
			for (int indice = 0; indice < dimension; indice++) {
				output += StringUtils.SPACE + caracteres[indice];
			}
			System.out.println(output);
		} catch (IllegalArgumentException e) {
			System.err.println(
					"Error en la entrada. Debe introducir un caracter inicial y uno final en el orden adecuado.");
		} finally {
			scanner.close();
		}

	}

}
