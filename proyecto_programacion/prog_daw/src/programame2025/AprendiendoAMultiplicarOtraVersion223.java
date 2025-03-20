package programame2025;

import java.util.Scanner;

public class AprendiendoAMultiplicarOtraVersion223 {
	static Scanner in;

	public static void casoDePrueba() {

		// TU CÓDIGO AQUÍ.
		// Procesa un único caso leyendo con
		// in.next*()
		int cantidadNumeros = in.nextInt();
		int inicio = 0;
		int inicioMax = 0;
		int fin = 0;
		int finMax = 0;
		int longSerieMax = 0;
		int longSerie = 0;
		boolean finSerie = false;
		if (cantidadNumeros == 1) {
			int numActual = in.nextInt();
			inicioMax = 0;
			finMax = 0;
			if (numActual != 0) {				
				longSerieMax = 1;
			} else {
				longSerieMax = 0;
			}
		} else {
			for (int i = 0; i < cantidadNumeros; i++) {
				int numActual = in.nextInt();
				if (longSerie == 0 && numActual != 0) {
					inicio = i;
					longSerie++;
				} else if (longSerie > 0 && i == cantidadNumeros - 1 && numActual != 0) {
					// Cuando termine la línea de números tendré que procesar la última secuencia
					fin = i;
					finSerie = true;
					longSerie++;
				} else if (longSerie > 0 && numActual != 0) {
					longSerie++;
				} else if (longSerie > 0 && numActual == 0) {
					fin = i - 1;
					finSerie = true;
				}
				if (finSerie && longSerie > longSerieMax) {
					longSerieMax = longSerie;
					inicioMax = inicio;
					finMax = fin;
					longSerie = 0;
					finSerie = false;
				} else if (finSerie) {
					longSerie = 0;
					finSerie = false;
				}
			}
		}

		if (longSerieMax > 0) {
			System.out.println(longSerieMax + " -> [" + inicioMax + "," + finMax + "]");
		} else {
			System.out.println("SIGUE BUSCANDO");
		}
	} // casoDePrueba

	public static void main(String[] args) {

		in = new java.util.Scanner(System.in);

		int numCasos = in.nextInt();
		for (int i = 0; i < numCasos; i++)
			casoDePrueba();

	}
}