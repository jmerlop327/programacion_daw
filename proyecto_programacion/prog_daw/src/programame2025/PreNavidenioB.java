package programame2025;

import java.util.Scanner;

//https://programame.com/documents/ProblemsSets/2025/ProgramaMe-2025-Navidad.pdf
//https://aceptaelreto.com/problem/statement.php?id=764&cat=172
public class PreNavidenioB {

	static Scanner in;

	public static boolean casoDePrueba() {

		// LEER CASO DE PRUEBA
		int campanias = in.nextInt();

		if (campanias == 0) {
			return false;
		} else {
			// CÓDIGO PRINCIPAL AQUÍ
			// Procesa un único caso leyendo con
			// in.next*()
			int anillasPuestas=0;
			for (int i = 0; i < campanias; i++) {
				int capturas = in.nextInt();
				int avesAnilladas = in.nextInt();
                anillasPuestas += capturas - avesAnilladas;
			}
			System.out.println(anillasPuestas);
			return true;
		}

	} // casoDePrueba

	public static void main(String[] args) {

		in = new java.util.Scanner(System.in);

		while (casoDePrueba())
			;

	} // main
}
