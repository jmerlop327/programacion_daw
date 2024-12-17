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
		int[][] corral = new int[filas][cols];
		int pollitos = in.nextInt();
		for (int p = 0; p < pollitos; p++) {
			in.nextLine();
			String comportamientoPollito = in.nextLine();
			String[] datosPollito = comportamientoPollito.split(" ");
			int fila = Integer.parseInt(datosPollito[0]) - 1;
			int col = Integer.parseInt(datosPollito[1]) - 1;
			String direccion = datosPollito[2];
			int pasos = Integer.parseInt(datosPollito[3]);

			switch (direccion) {
			case "N":
				int i = fila, j = col;
				int factor = 1;
				int repeticiones = 0;
				int limite = 1;
				corral[i][j] = corral[i][j] + 1;
				while (pasos > 0) {
					repeticiones = 0;
					while (repeticiones < limite && !chocado(corral, i, j)) {
						i = i - factor;
						corral[i][j] = corral[i][j] + 1;
						repeticiones++;
					}
					pasos--;
					if (pasos > 0) {
						j = j + factor;
						corral[i][j] = corral[i][j] + 1;
						pasos--;
					}
					factor = -(factor);
					limite++;
				}
				break;
			case "S":

				break;
			case "E":

				break;
			case "W":

				break;
			}
			for (int i = 0; i < filas; i++) {
				for (int j = 0; j < cols; j++) {
					System.out.print(corral[i][j]+" ");
				}
				System.out.print("\n");
			}
		}

	} // casoDePrueba

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
