package unidad04;

import java.util.Scanner;

public class SombrasCamping207 {

	static Scanner in;

	public static boolean casoDePrueba() {
		int c = in.nextInt();
		int f = in.nextInt();
		int a = in.nextInt();
		final int ARBOL = 2;
		final int SOMBRA = 1;
		final int SOL = 0;

		// LEER CASO DE PRUEBA
		if (c == 0 && f == 0 && a == 0) {
			return false;
		} else {
			// CÓDIGO PRINCIPAL AQUÍ
			// Procesa un único caso leyendo con
			// in.next*()
			int[][] camping = new int[c][f];
			int sombras = 0;
			for (int i = 0; i < a; i++) {
				camping[in.nextInt() - 1][in.nextInt() - 1] = ARBOL;
			}
			for (int i = 0; i < c; i++) {
				for (int j = 0; j < f; j++) {
					if (camping[i][j] == ARBOL) {
						// mirar alrededor del arbol, si es 0(SOL), pongo un uno (SOMBRA)
						for (int t = i - 1; t <= i + 1; t++) {
							for (int u = j - 1; u <= j + 1; u++) {
								if (t >= 0 && t < c && u >= 0 && u < f) {
									if (camping[t][u] == SOL) {
										camping[t][u] = SOMBRA;
										sombras++;
									}
								}
							}
						}
					}
				}
			}
			System.out.println(sombras);
			return true;
		}

	} // casoDePrueba

	public static void main(String[] args) {

		in = new java.util.Scanner(System.in);

		while (casoDePrueba())
			;

	} // main
}
