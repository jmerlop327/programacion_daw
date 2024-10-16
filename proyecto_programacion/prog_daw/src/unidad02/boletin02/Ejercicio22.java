package unidad02.boletin02;

import java.util.Scanner;

/**
 * Escribe un programa que diga si un número introducido por teclado es o no
 * primo. Un número primo es aquel que sólo es divisible entre él mismo y la
 * unidad.
 */
public class Ejercicio22 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce un número para ver si es primo o no:");
		int numero = sc.nextInt();
		boolean esPrimo = true;
		sc.close();
		// con for
//		for (int divisor = 2; divisor < numero/2; divisor++) {
//			if (numero % divisor == 0) {
//				esPrimo = false;
//			}
//		}
		// con while
		int divisor = 2;
		while (esPrimo && divisor < numero / 2) {
			if (numero % divisor == 0) {
				esPrimo = false;
			}
			divisor++;
		}
		if (esPrimo) {
			System.out.printf("El número %d es primo", numero);
		} else {
			System.out.printf("El número %d no es primo", numero);
		}
	}

}
