package unidad02;

import java.util.Scanner;

/**
 * Devuelve el mayor número de los introducidos por teclado
 */
public class MayorNumeroWhile {

	public static void main(String[] args) {
		// opción B. Establecemos una instruccion de parada
				// La instrucción de parada será STOP
				
		// declaración del scanner para obtener los datos por teclado
		Scanner scan = new Scanner(System.in);
		// Petición al usuario de los datos de entrada y se guardan en variables
		System.out.println("Este programa devuelve el mayor de todos los números introducidos por teclado.");
		System.out.print("Introduce \"STOP\" cuando quieras parar de introducir números");
		int mayorNumero = Integer.MIN_VALUE;
		String dato = "";
		boolean salir = false;
		do {
			System.out.println("Introduce un entero:");
			dato = scan.nextLine();
			salir = "STOP".equalsIgnoreCase(dato) ? true : false;
		} while (!salir);
		
//		while (condicion) {
//			
//		}
		System.out.println("El mayor número introducido es el " + mayorNumero);
		

	}

}
