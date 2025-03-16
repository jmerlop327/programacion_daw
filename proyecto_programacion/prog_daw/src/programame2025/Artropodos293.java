package programame2025;

import java.util.Scanner;

public class Artropodos293 {

	static Scanner in;

	public static void casoDePrueba() {

		// TU CÓDIGO AQUÍ.
		// Procesa un único caso leyendo con
		// in.next*()
		int insectos = in.nextInt();
		int aracnidos = in.nextInt();
		int crustaceos = in.nextInt();
		int escolo = in.nextInt();
		int anillosEscolo = in.nextInt();
		int patas = insectos * 6 + aracnidos * 8 + crustaceos * 10 + escolo * anillosEscolo * 2;
		System.out.println(patas);

	} // casoDePrueba

	public static void main(String[] args) {

		in = new java.util.Scanner(System.in);

		int numCasos = in.nextInt();
		for (int i = 0; i < numCasos; i++)
			casoDePrueba();

	} // main
}
