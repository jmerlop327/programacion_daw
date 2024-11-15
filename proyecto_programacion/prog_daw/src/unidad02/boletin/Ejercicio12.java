package unidad02.boletin;

import java.util.Scanner;

/**
 * Realiza un programa que nos diga cuántos dígitos tiene un número entero que
 * puede ser positivo o negativo. Se permiten números de hasta 5 dígitos.
 */
public class Ejercicio12 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		System.out.println("Este programa calcula la cantidad de cifras de un número introducido por teclado.");
		System.out.print("Introduce un número entero:");
		int num = teclado.nextInt();
		teclado.close();
		int numActual = num;
		int numCifras = 1;
		while (numActual/10 != 0) {
			numCifras++;
			numActual = numActual/10;
		}
		System.out.println("El número " + num + " tiene " + numCifras + " cifras.");

	}

}
