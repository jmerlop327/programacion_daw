package unidad04.boletin;

import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;

public class Ej15TresEnRaya {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[][] tablero = new String[3][3];
		System.out.println("Bienvenido al 3 en raya");
		mostrarTablero();
		System.out.println("Introduce una posición libre del tablero");
		String jugada = scanner.nextLine();
		int fila = 0;
		int col = 0;
		if (jugada.matches("[ABCabc][123]")) {
			fila = Integer.parseInt(jugada.substring(1)) - 1;
			String colString = jugada.substring(0, 1);
			// colString.matches("[Aa]");
			// StringUtils.equalsIgnoreCase(colString, "a");
			if ("A".equals(colString) || "a".equals(colString)) {
				col = 0;
			} else if ("B".equals(colString) || "b".equals(colString)) {
				col = 1;
			} else if ("C".equals(colString) || "c".equals(colString)) {
				col = 2;
			}
		} else if (jugada.matches("[123][ABCabc]")) {

		} else {
			System.err.println("Entrada inválida");
		}

	}

	private static void mostrarTablero() {
		
		
	}

}
