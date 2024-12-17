package unidad04.boletin;

import java.util.Arrays;
import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;

public class Ej15TresEnRaya {

	static String[][] tablero = new String[3][3];
	final static String PLAYER_X = "X";
	final static String PLAYER_O = "O";

	public static void main(String[] args) {
		//TODO: Controlar la victoria de los jugadores 
		//TODO: Controlar si hay espacios libres
		//TODO: COntrolar si un usuario ha introducido una casilla ocupada (entradaCorrecta booleano)
		boolean ganaPlayer1 = false;
		boolean ganaPlayer2 = false;
		boolean hayHuecos = true;
		String player = PLAYER_X;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Bienvenido al 3 en raya");
		Arrays.fill(tablero[0], StringUtils.EMPTY);
		Arrays.fill(tablero[1], StringUtils.EMPTY);
		Arrays.fill(tablero[2], StringUtils.EMPTY);
		System.out.println("Introduce una posición libre del tablero");
		do {
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
				if (StringUtils.EMPTY.equals(tablero[fila][col])) {
					tablero[fila][col] = player;
				}
			} else if (jugada.matches("[123][ABCabc]")) {

			} else {
				System.err
						.println("Entrada inválida, debe introducir una jugada como \"letranumero\" o \"numeroletra\"");
			}
			player = cambioJugador(player);
		} while (!ganaPlayer1 && !ganaPlayer2 && hayHuecos);

	}

	/**
	 * Cambia el jugador
	 * 
	 * @param player
	 * @return
	 */
	private static String cambioJugador(String player) {
		if (PLAYER_X.equals(player)) {
			player = PLAYER_O;
		} else {
			player = PLAYER_X;
		}
		return player;
	}

	/**
	 * Muestra
	 */
	private static void mostrarTablero() {
		for (int i = 0; i < tablero.length; i++) {
			System.out.print("|");
			for (int j = 0; j < tablero[0].length; j++) {
				if (j == tablero[0].length - 1) {
					System.out.print(tablero[i][j]);
				} else {
					System.out.print(tablero[i][j] + "\t");
				}
			}
			System.out.print("|");
			System.out.print("\n");
		}
	}

}
