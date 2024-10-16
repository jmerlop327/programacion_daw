package unidad02.boletin02;

import java.util.Scanner;

/**
 * Escribe un programa que lea una lista de diez números y determine cuántos son
 * positivos, y cuántos son negativos.
 */
public class Ejercicio21 {

	public static void main(String[] args) {
		System.out.println(
				"Este programa recibe 10 números enteros y devuelve cuántos son positivos y cuántos negativos");
		Scanner scan = new Scanner(System.in);
		int positivos = 0;
		int negativos = 0;
		for (int numeros = 10; numeros > 0; numeros--) {
			System.out.println("Introduce un número (quedan " + numeros + ")");
			int numero = scan.nextInt();
			if (numero >= 0) {
				// consideramos el 0 como número positivo
				positivos++;
			} else {
				negativos++;
			}
		}
		scan.close();
		/*
		 * %d: Se utiliza para insertar un número entero (de "decimal"). 
		 * %f: Se utiliza para insertar un número de punto flotante (de "float"). 
		 * %s: Para insertar cadenas de texto (de "string"). 
		 * %c: Para insertar un carácter (de "character").
		 */
		System.out.printf("Has introducido %d números positivos y %d números negativos", positivos, negativos);

	}

}
