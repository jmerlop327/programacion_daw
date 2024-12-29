package unidad04.boletin;

import java.util.Scanner;

public class ComidaPollitos328 {

	static Scanner in;

	public static void casoDePrueba() {
		// TU CÓDIGO AQUÍ.
		// Procesa un único caso leyendo con
		// in.next*()
		int filas = in.nextInt();
		int cols = in.nextInt();
		int pollitos = in.nextInt();
		int[][] corral = new int[filas][cols];
		in.nextLine();
		for (int p = 0; p < pollitos; p++) {
			String comportamientoPollito = in.nextLine();
			String[] datosPollito = comportamientoPollito.split(" ");
			int fila = Integer.parseInt(datosPollito[0]) - 1;
			int col = Integer.parseInt(datosPollito[1]) - 1;
			String direccion = datosPollito[2];
			int pasos = Integer.parseInt(datosPollito[3]);
			int i = fila, j = col;
			int factor = 1;
			int limite = 1;
			corral[fila][col]++;
			boolean chocado = false;

			switch (direccion) {
			case "N":
				while (pasos > 0 && !chocado) {
					int repeticiones = 1;
					while (pasos > 0 && !chocado && repeticiones <= limite) {
						i -= factor;
						chocado = chocado(corral, i, j);
						if (pasos > 0 && !chocado) {
							corral[i][j]++;
						}
						pasos--;
						repeticiones++;
					}
					repeticiones = 1;
					while (pasos > 0 && !chocado && repeticiones <= limite) {
						j += factor;
						chocado = chocado(corral, i, j);
						if (pasos > 0 && !chocado) {
							corral[i][j]++;
						}
						pasos--;
						repeticiones++;
					}
					factor *= -1;
					limite++;
				}
				break;
			case "S":
				while (pasos > 0 && !chocado) {
					int repeticiones = 1;
					while (pasos > 0 && !chocado && repeticiones <= limite) {
						i += factor;
						chocado = chocado(corral, i, j);
						if (pasos > 0 && !chocado) {
							corral[i][j]++;
						}
						pasos--;
						repeticiones++;
					}
					repeticiones = 1;
					while (pasos > 0 && !chocado && repeticiones <= limite) {
						j -= factor;
						chocado = chocado(corral, i, j);
						if (pasos > 0 && !chocado) {
							corral[i][j]++;
						}
						pasos--;
						repeticiones++;
					}
					factor *= -1;
					limite++;
				}
				break;
			case "E":
				while (pasos > 0 && !chocado) {
					int repeticiones = 1;
					while (pasos > 0 && !chocado && repeticiones <= limite) {
						j += factor;
						chocado = chocado(corral, i, j);
						if (pasos > 0 && !chocado) {
							corral[i][j]++;
						}
						pasos--;
						repeticiones++;
					}
					repeticiones = 1;
					while (pasos > 0 && !chocado && repeticiones <= limite) {
						i += factor;
						chocado = chocado(corral, i, j);
						if (pasos > 0 && !chocado) {
							corral[i][j]++;
						}
						pasos--;
						repeticiones++;
					}
					factor *= -1;
					limite++;
				}
				break;
			case "W":
				while (pasos > 0 && !chocado) {
					int repeticiones = 1;
					while (pasos > 0 && !chocado && repeticiones <= limite) {
						j -= factor;
						chocado = chocado(corral, i, j);
						if (pasos > 0 && !chocado) {
							corral[i][j]++;
						}
						pasos--;
						repeticiones++;
					}
					repeticiones = 1;
					while (pasos > 0 && !chocado && repeticiones <= limite) {
						i -= factor;
						chocado = chocado(corral, i, j);
						if (pasos > 0 && !chocado) {
							corral[i][j]++;
						}
						pasos--;
						repeticiones++;
					}
					factor *= -1;
					limite++;
				}
				break;
			}
		}
		mostrarCorral(filas, cols, corral);

	} // casoDePrueba

	private static void mostrarCorral(int filas, int cols, int[][] corral) {
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < cols; j++) {
				if (j < cols - 1) {					
					System.out.print(corral[i][j] + " ");
				} else {
					System.out.print(corral[i][j]);
				}
			}
			System.out.print("\n");
		}
		System.out.print("---\n");
	}

	private static boolean chocado(int[][] corral, int fila, int columna) {
		boolean chocado = false;
		if (fila < 0 || fila >= corral.length || columna < 0 || columna >= corral[0].length) {
			chocado = true;
		}
		return chocado;
	}

	public static void main(String[] args) {

		in = new java.util.Scanner(System.in);

		int numCasos = in.nextInt();
		for (int i = 0; i < numCasos; i++)
			casoDePrueba();

	} // main

}
