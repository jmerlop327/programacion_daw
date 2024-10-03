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
			if ("STOP".equalsIgnoreCase(dato)) {
				salir = true;
			} else {
				int datoEntero = Integer.parseInt(dato);
				//asignación de valor a mayorNumero con operador ternario
				//mayorNumero = datoEntero > mayorNumero ? datoEntero : mayorNumero;
				//asignación de valor a mayorNumero con una estructura de decisión
				if (datoEntero > mayorNumero) {
					mayorNumero = datoEntero;
				}
			}
			System.out.println("El mayor número introducido hasta el momento es el " + mayorNumero);
		} while (!salir);
		scan.close();
		System.out.println("El mayor número introducido al final del programa es " + mayorNumero);
		

	}

}
