package unidad04.boletin;

import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;

public class Ej14Ajedrez {
	private static final String MARCA = "X";

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
		scanner.close();
		char letra = input.charAt(0);
		int numero = Integer.parseInt(StringUtils.substring(input, input.length() - 1));
		int letraMatriz = letra - 'a';
		int numeroMatriz = 8 - numero;
		String posicionesValidas = StringUtils.EMPTY;
		String[][] tablero = new String[8][8];
		tablero[numeroMatriz][letraMatriz] = "A";
		// Hacia arriba y derecha
		int letraAux = letraMatriz + 1;
		int numeroAux = numeroMatriz - 1;
		while (estaEnTablero(letraAux, numeroAux)) {
			tablero[numeroAux][letraAux] = MARCA;
			if (StringUtils.isEmpty(posicionesValidas)) {
				posicionesValidas += traducirPosicion(letraAux, numeroAux);
			} else {
				posicionesValidas += ", " + traducirPosicion(letraAux, numeroAux);
			}
			letraAux++;
			numeroAux--;
		}
		// Hacia arriba e izquierda
		letraAux = letraMatriz - 1;
		numeroAux = numeroMatriz - 1;
		while (estaEnTablero(letraAux, numeroAux)) {
			tablero[numeroAux][letraAux] = MARCA;
			if (StringUtils.isEmpty(posicionesValidas)) {
				posicionesValidas += traducirPosicion(letraAux, numeroAux);
			} else {
				posicionesValidas += ", " + traducirPosicion(letraAux, numeroAux);
			}
			letraAux--;
			numeroAux--;
		}
		// Hacia abajo y derecha
		letraAux = letraMatriz + 1;
		numeroAux = numeroMatriz + 1;
		while (estaEnTablero(letraAux, numeroAux)) {
			tablero[numeroAux][letraAux] = MARCA;
			if (StringUtils.isEmpty(posicionesValidas)) {
				posicionesValidas += traducirPosicion(letraAux, numeroAux);
			} else {
				posicionesValidas += ", " + traducirPosicion(letraAux, numeroAux);
			}
			letraAux++;
			numeroAux++;
		}
		// Hacia abajo e izquierda
		letraAux = letraMatriz - 1;
		numeroAux = numeroMatriz + 1;
		while (estaEnTablero(letraAux, numeroAux)) {
			tablero[numeroAux][letraAux] = MARCA;
			if (StringUtils.isEmpty(posicionesValidas)) {
				posicionesValidas += traducirPosicion(letraAux, numeroAux);
			} else {
				posicionesValidas += ", " + traducirPosicion(letraAux, numeroAux);
			}
			letraAux--;
			numeroAux++;
		}
		// Pintar tablero
		mostrarTablero(tablero, posicionesValidas);
	}

	/**
	 * Muestra el tablero pasado como parámetro por la consola
	 * 
	 * @param tablero
	 */
	private static void mostrarTablero(String[][] tablero, String posicionesValidas) {
		System.out.println("\ta\tb\tc\td\te\tf\tg\th");
		for (int fila = 0; fila <= 7; fila++) {
			System.out.print(8 - fila + "\t");
			for (int col = 0; col <= 7; col++) {
				String casilla = tablero[fila][col];
				if (null != casilla) {
					System.out.print(casilla);
				}
				System.out.print("\t");
			}
			System.out.print("\n");
		}
		System.out.println(posicionesValidas);
	}

	/**
	 * Devuelve true si la posición está dentro del tablero
	 * 
	 * @param letraAux
	 * @param numeroAux
	 * @return
	 */
	private static boolean estaEnTablero(int letraAux, int numeroAux) {
		return letraAux >= 0 && letraAux <= 7 && numeroAux >= 0 && numeroAux <= 7;
	}

	private static String traducirPosicion(int letra, int numero) {
		String posicion = StringUtils.EMPTY;
		char letraPos = (char) ('a' + letra);
		int numeroPos = 8 - numero;
		posicion = posicion + letraPos + numeroPos;
		return posicion;
	}

}
