package programame2025;

import java.util.Scanner;
//https://aceptaelreto.com/problem/statement.php?id=272
public class TresDedos272 {

	static Scanner in;

	public static void casoDePrueba() {

		// TU CÓDIGO AQUÍ.
		// Procesa un único caso leyendo con
		// in.next*()
		int numBase10 = in.nextInt();
		StringBuilder numBase6Sb = new StringBuilder();
		int resto = numBase10;
		while (resto >= 6) {
			numBase6Sb.append(resto % 6);
			resto /= 6;
		}
		numBase6Sb.append(resto);
		System.out.println(numBase6Sb.reverse());
	} // casoDePrueba

	public static void main(String[] args) {

		in = new java.util.Scanner(System.in);

		int numCasos = in.nextInt();
		for (int i = 0; i < numCasos; i++)
			casoDePrueba();

	} // main

}
