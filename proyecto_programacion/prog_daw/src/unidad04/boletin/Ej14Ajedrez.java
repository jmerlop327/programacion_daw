package unidad04.boletin;

import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;

public class Ej14Ajedrez {
	/**
	 * Desarrolla un programa que, al proporcionarle una posición en un tablero de
	 * ajedrez, determine las casillas a las cuales un alfil ubicado en esa posición
	 * podría saltar. Conforme a la ilustración adjunta, se destaca que el alfil se
	 * desplaza exclusivamente en diagonal. El tablero consta de 64 casillas, siendo
	 * las columnas designadas por las letras de la "a" a la "h" y las filas
	 * numeradas del 1 al 8.
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Introduce la posición inicial del alfil a-h 1-8");
		String input = scanner.nextLine();
		char letra = input.charAt(0);
		int numero = Integer.parseInt(StringUtils.substring(input, input.length() - 1));
		String[][] tablero = new String[8][8];
		System.out.println("\ta\tb\tc\td\te\tf\tg\th");
		for (int fila = 8; fila >= 1; fila--) {
			System.out.print(fila + "\t");
			for (char col = 'a'; col <= 'h'; col++) {
				if (col == letra && fila == numero) {
					System.out.print("A" + "\t");
					tablero[fila][col] = "A";
				} else {

					System.out.print("\t");
				}
			}
			System.out.print("\n");
		}
		// Hacia arriba y derecha
		char letraAux = letra+1;
		int numeroAux = numero+1;
		while (letraAux <= 'h' && numeroAux <= 8) {
			tablero[letraAux][numeroAux] = "X";
			letraAux++;
			numeroAux++;
		}
	}

	private static boolean esMovimiento() {
		// TODO Auto-generated method stub
		return false;
	}

}
