package programame2025;

import java.util.Scanner;

//https://programame.com/documents/ProblemsSets/2025/ProgramaMe-2025-Navidad.pdf
//https://aceptaelreto.com/problem/statement.php?id=767
public class PreNavidenioE {

	static Scanner in;

	public static boolean casoDePrueba() {

		// LEER CASO DE PRUEBA
		int numPuntos = in.nextInt();
		if (numPuntos == 0) {
			return false;
		} else {
			// CÓDIGO PRINCIPAL AQUÍ
			// Procesa un único caso leyendo con
			// in.next*()
			int[] puntos = new int[numPuntos];
			int max = Integer.MIN_VALUE;
			int posMax = -1;
			// guardo los puntos y calculo el máximo y su posición
			for (int i = 0; i < numPuntos; i++) {
				int punto = in.nextInt();
				if (punto >= max) {
					max = punto;
					posMax = i;
				}
				puntos[i] = punto;
			}
			int[] salida = new int[numPuntos];
			// El de la derecha del todo debe ser x metros más bajo que el máximo
			// siendo x la distancia entre ellos
			// si no existe esa diferencia, el máximo debe incrementarse
			if (puntos[numPuntos - 1] >= max - numPuntos + posMax + 1) {
				max += numPuntos - posMax;
				salida[numPuntos - 1] = puntos[numPuntos - 1];
			} else {
				salida[numPuntos - 1] = puntos[posMax] - numPuntos + posMax + 1;
			}
			for (int i = numPuntos - 2; i >= 0; i--) {
				salida[i] = salida[i + 1] + 1;
			}
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < numPuntos; i++) {
				sb.append(salida[i] - puntos[i]).append(" ");
			}
			// borro el último espacio
			sb.deleteCharAt(sb.length() - 1);
			System.out.println(sb);
			return true;
		}

	} // casoDePrueba

	public static void main(String[] args) {

		in = new java.util.Scanner(System.in);

		while (casoDePrueba())
			;

	} // main
}
