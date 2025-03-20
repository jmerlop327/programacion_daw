package programame2025;

// Esquema de la entrada: número de casos
import java.util.*;
//https://aceptaelreto.com/problem/statement.php?id=219
public class PeniaAtletica219 {

	static Scanner in;

	public static void casoDePrueba() {
		int decimosPares = 0;
		int cantidadNumeros = in.nextInt();
		for (int i = 0; i < cantidadNumeros; i++) {
			int numero = in.nextInt();
			if (numero % 2 == 0) {
				decimosPares++;
			}
		}
		System.out.println(decimosPares);
	} // casoDePrueba

	public static void main(String[] args) {

		in = new java.util.Scanner(System.in);

		int numCasos = in.nextInt();
		for (int i = 0; i < numCasos; i++)
			casoDePrueba();

	} // main

} // class Solution