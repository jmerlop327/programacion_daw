package unidad04.boletin;

import java.util.Arrays;
import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;

public class Ej15TresEnRaya {

	static String[][] tablero = new String[3][3];
	final static String PLAYER_X = "X";
	final static String PLAYER_O = "O";

	public static void main(String[] args) {
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
			int huecosLibres = mostrarTablero();
			int numPlayer = player.equals(PLAYER_X) ? 1 : 2;
			System.out.printf("Turno del player %d\n", numPlayer);
			System.out.println("Introduce una posición libre del tablero");
			String jugada = scanner.nextLine();
			int fila = 0;
			int col = 0;
			boolean casillaOcupada = false;
			if (jugada.matches("[ABCabc][123]")) {
				fila = Integer.parseInt(jugada.substring(1)) - 1;
				String colString = jugada.substring(0, 1);
				// colString.matches("[Aa]");
				// StringUtils.equalsIgnoreCase(colString, "a");
				col = getIndicePorLetra(colString);
				if (StringUtils.EMPTY.equals(tablero[fila][col])) {
					tablero[fila][col] = player;
					int contadorCol = 0;
					int contadorFila = 0;
					int contadorDiaPrin = 0;
					int contadorDiaSec = 0;

					// compruebo la fila
					for (int k = 0; k < tablero.length; k++) {
						if (tablero[k][col] == player) {
							contadorCol++;
						}
						if (tablero[fila][k] == player) {
							contadorFila++;
						}
						// estamos en la diagonal principal
						if (fila == col) {
							if (tablero[k][k] == player) {
								contadorDiaPrin++;
							}
						}
						// estamos en la diagonal secundaria
						if (fila == tablero[0].length - col - 1) {
							if (tablero[k][tablero[0].length - k - 1] == player) {
								contadorDiaSec++;
							}
						}
					}
					if (contadorFila == 3 || contadorCol == 3 || contadorDiaPrin == 3 || contadorDiaSec == 3) {
						if (PLAYER_X.equals(player)) {
							ganaPlayer1 = true;
						} else {
							ganaPlayer2 = true;
						}
					} else {
						hayHuecos = (huecosLibres - 1 == 0) ? false : true;
					}
				} else {
					// El jugador ha introducido un valor correcto pero dicha casilla está ocupada
					casillaOcupada = true;
				}
			} else if (jugada.matches("[123][ABCabc]")) {
				fila = Integer.parseInt(jugada.substring(1)) - 1;
				String colString = jugada.substring(0, 1);
				// colString.matches("[Aa]");
				// StringUtils.equalsIgnoreCase(colString, "a");
				col = getIndicePorLetra(colString);
				if (StringUtils.EMPTY.equals(tablero[fila][col])) {
					tablero[fila][col] = player;
					int contadorCol = 0;
					int contadorFila = 0;
					int contadorDiaPrin = 0;
					int contadorDiaSec = 0;

					// compruebo la fila
					for (int k = 0; k < tablero.length; k++) {
						if (tablero[k][col] == player) {
							contadorCol++;
						}
						if (tablero[fila][k] == player) {
							contadorFila++;
						}
						// estamos en la diagonal principal
						if (fila == col) {
							if (tablero[k][k] == player) {
								contadorDiaPrin++;
							}
						}
						// estamos en la diagonal secundaria
						if (fila == tablero[0].length - col - 1) {
							if (tablero[k][tablero[0].length - k - 1] == player) {
								contadorDiaSec++;
							}
						}
					}
					if (contadorFila == 3 || contadorCol == 3 || contadorDiaPrin == 3 || contadorDiaSec == 3) {
						if (PLAYER_X.equals(player)) {
							ganaPlayer1 = true;
						} else {
							ganaPlayer2 = true;
						}
					} else {
						hayHuecos = (huecosLibres - 1 == 0) ? false : true;
					}
				} else {
					// El jugador ha introducido un valor correcto pero dicha casilla está ocupada
					casillaOcupada = true;
				}
			} else {
				System.err.println(
						"Entrada inválida, debe introducir una jugada como \"[letra][numero]\" o \"[numero][letra]\"");
			}
			if (casillaOcupada) {
				System.err.println("La casilla introducida está ocupada.");
			} else if (ganaPlayer1) {
				System.out.println("Enhorabuena player 1. Has ganado!");
			} else if (ganaPlayer2) {
				System.out.println("Enhorabuena player 2. Has ganado!");
			} else {
				player = cambioJugador(player);
			}
		} while (!ganaPlayer1 && !ganaPlayer2 && hayHuecos);
		System.out.println("Hasta Luego!");
		
	}

	private static int getIndicePorLetra(String colString) {
		int col = 0;
		if ("A".equals(colString) || "a".equals(colString)) {
			col = 0;
		} else if ("B".equals(colString) || "b".equals(colString)) {
			col = 1;
		} else if ("C".equals(colString) || "c".equals(colString)) {
			col = 2;
		}
		return col;
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
	private static int mostrarTablero() {
		int huecosLibres = 0;
		System.out.println("  a\t b\t c");
		for (int i = 0; i < tablero.length; i++) {
			System.out.print(i + 1 + "|");
			for (int j = 0; j < tablero[0].length; j++) {
				if (j == tablero[0].length - 1) {
					System.out.print(tablero[i][j]);
				} else {
					System.out.print(tablero[i][j] + "\t");
				}
				if (StringUtils.EMPTY.equals(tablero[i][j])) {
					huecosLibres++;
				}
			}
			System.out.print("|");
			System.out.print("\n");
		}
		return huecosLibres;
	}

}
