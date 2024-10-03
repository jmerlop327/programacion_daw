package unidad02;

import java.util.Scanner;

/**
 * Se introducen 3 números enteros por teclado y debe devolver
 * el mayor de ellos
 */
public class MayorNumeroDeTres {

	public static void main(String[] args) {
		//declaración del scanner para obtener los datos por teclado
		Scanner scan = new Scanner(System.in);
		//Petición al usuario de los datos de entrada y se guardan en variables
		System.out.println("Este programa devuelve el mayor de tres números introducidos por teclado.");
		System.out.print("Introduce el primer número:");
		int numero1 = scan.nextInt();
		System.out.print("\nIntroduce el segundo número:");
		int numero2 = scan.nextInt();
		System.out.println("\nIntroduce el tercer número:");
		int numero3 = scan.nextInt();
		scan.close();
		
		//Cálculo del mayor número
		int mayor;
		if (numero1 >= numero2) {
			mayor = numero1;
			if (mayor < numero3) {
				mayor = numero3;
			}
		} else {
			mayor = numero2;
			if (mayor < numero3) {
				mayor = numero3;
			}
		}
		
		//respuesta final del programa
		System.out.println("\nEl mayor número es: " + mayor);

	}

}
