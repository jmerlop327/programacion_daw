package unidad02.boletin;

import java.util.Scanner;

/**
 * Escribe un programa que ordene tres números enteros introducidos por teclado.
 */
public class Ejercicio08 {

	public static void main(String[] args) {
		// declaración del scanner para obtener los datos por teclado
		Scanner scan = new Scanner(System.in);
		// Petición al usuario de los datos de entrada y se guardan en variables
		System.out.println("Este programa devuelve tres números introducidos por teclado de manera ordenada.");
		System.out.println("Debes introducir números distintos, en caso contrario dará error.");
		System.out.print("Introduce el primer número:");
		int numero1 = scan.nextInt();
		System.out.print("\nIntroduce el segundo número:");
		int numero2 = scan.nextInt();
		System.out.println("\nIntroduce el tercer número:");
		int numero3 = scan.nextInt();
		scan.close();
		if (numero1 == numero2 || numero1 == numero3 || numero2 == numero3) {
			System.err.println("Error. Debes introducir 3 números distintos.");
		} else {
			// Cálculo del mayor número
			int mayor = 0;
			int mediano = 0;
			int menor = 0;
			// primer caso
			if (numero1 > numero2) {
				mayor = numero1;
				menor = numero2;
				mediano = numero3;
				if (mayor < numero3) {
					mediano = mayor;
					mayor = numero3;
				} else if (menor > numero3) {
					mediano = menor;
					menor = numero3;
				}
			} else {
				// numero2 >numero1
				mayor = numero2;
				menor = numero1;
				mediano = numero3;
				if (mayor < numero3) {
					mediano = mayor;
					mayor = numero3;
				} else if (menor > numero3) {
					mediano = menor;
					menor = numero3;
				}
			}

			// respuesta final del programa
			System.out.println("\nEl mayor número es: " + mayor);
			System.out.println("\nEl número mediano es: " + mediano);
			System.out.println("\nEl menor número es: " + menor);
		}

	}
}