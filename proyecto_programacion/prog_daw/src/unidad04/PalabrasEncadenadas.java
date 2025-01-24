package unidad04;

import java.util.Scanner;

public class PalabrasEncadenadas {

	/**
	 * Método para comprobar si las palabras están encadenadas
	 * 
	 * @param palabras
	 * @return
	 */
	public static boolean estanEncadenadas(String palabras) {
		boolean encadenadas = true;
		String[] palabrasArray = palabras.split(" ");
		// Validar la longitud de las palabras y la lista
		int indice = 0;
		while (encadenadas && indice < palabrasArray.length) {
			String palabra = palabrasArray[indice];
			if (palabra.length() < 2 || palabra.length() > 24) {
				encadenadas = false;
				System.out.println("Cada palabra debe tener entre 2 y 24 caracteres.");
			}
			indice++;
		}
		if (encadenadas && (palabrasArray.length < 1 || palabrasArray.length > 50)) {
			System.out.println("La lista debe contener entre 1 y 50 palabras.");
			encadenadas = false;
		} else {
			for (int i = 0; i < palabrasArray.length - 1; i++) {
				// Comparar los dos últimos caracteres de la palabra actual con los primeros de
				// la siguiente
				if (!palabrasArray[i].endsWith(palabrasArray[i + 1].substring(0, 2))) {
					encadenadas = false;
				}
			}
		}
		return encadenadas;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Introduce una lista de palabras (escribe STOP para finalizar):");
		boolean stop = false;
		while (!stop) {
			System.out.print("--> ");
			String entrada = scanner.nextLine().trim();

			if (entrada.equalsIgnoreCase("STOP")) {
				System.out.println("Hasta la próxima!");
				stop = true;
			} else {
				// Comprobar si las palabras están encadenadas
				if (estanEncadenadas(entrada)) {
					System.out.println("Palabras encadenadas!");
				} else {
					System.out.println("Las palabras no están encadenadas.");
				}
			}

		}

		scanner.close();
	}
}
