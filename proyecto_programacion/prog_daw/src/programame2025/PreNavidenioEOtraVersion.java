package programame2025;

import java.util.Arrays;
import java.util.Scanner;

//https://programame.com/documents/ProblemsSets/2025/ProgramaMe-2025-Navidad.pdf
//https://aceptaelreto.com/problem/statement.php?id=767
public class PreNavidenioEOtraVersion {

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
			int primeraAltura = Integer.MIN_VALUE;
			// Calculo cuanto tiene que medir el primer arco
			for (int i = 0; i < numPuntos; i++) {
				int punto = in.nextInt();
				puntos[i] = punto;
				if (punto >= max) {
					max = punto;
					primeraAltura = punto + i;
				}
			}
			
			int[] alturas = new int[numPuntos];
			int[] pilares = new int[numPuntos];
			StringBuilder sb = new StringBuilder();
			// calculo la altura de cada punto desdendiendo 1 por tramo. Empezando en la
			// altura del primero
			alturas[0] = primeraAltura;
			pilares[0] = primeraAltura - puntos[0];
			sb.append(alturas[0] - puntos[0]);
			for (int i = 1; i < numPuntos; i++) {
				alturas[i] = alturas[i - 1] - 1;
				pilares[i] = alturas[i] - puntos[i];
				sb.append(" ").append(alturas[i] - puntos[i]);
			}
			String respuesta = Arrays.toString(pilares);
			respuesta = respuesta.replace("[", "").replace("]", "").replace(",", "");
			System.out.println(respuesta);
			// System.out.print(sb);
			return true;
		}

	} // casoDePrueba

	public static void main(String[] args) {

		in = new java.util.Scanner(System.in);

		while (casoDePrueba())
			;

	} // main
}
