package programame2025;

import java.util.Scanner;
//https://aceptaelreto.com/problem/statement.php?id=223
public class AprendiendoAMultiplicar223 {
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
		int longSerie = 0;
		int longSerieMax = 0;
		for (int i = 0; i < cantidadNumeros; i++) {
			int numActual = in.nextInt();
			if (longSerie == 0 && numActual != 0) {
				inicio = i;
				fin = i;
				longSerie++;
			} else if (longSerie > 0 && numActual != 0) {
				longSerie++;
				fin = i;
			} else if (longSerie > 0 && numActual == 0) {
				if (longSerie > longSerieMax) {
					inicioMax = inicio;
					finMax = fin;
					longSerieMax = longSerie;
					longSerie = 0;
				} else {
					longSerie = 0;
				}
			}
		}
		if (longSerie > longSerieMax) {
			inicioMax = inicio;
			finMax = fin;
			longSerieMax = longSerie;
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
// main}
}