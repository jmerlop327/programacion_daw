package unidad02;

import java.util.Scanner;

/**
 * Clase para el saludo pro en java
 * Saluda con Hola amigo si el usuario no introduce su nombre
 * Saluda con Hola nombre si el usuario introduce su nombre
 */
public class HolaMundoPro2 {

	public static void main(String[] args) {
		// metodo main
		Scanner scan = new Scanner(System.in);
		System.out.print("Introduce tu nombre:");
		String nombre = scan.nextLine();
		// Cuando el usuario no mete ningún nombre, el valor que guarda es una cadena
		// vacía, es decir, ""
		// Versión con operador ternario
		// nombre = "".equals(nombre) ? "amigo" : nombre;
		/*
		// Versión con if simple
		if ("".equals(nombre)) {
			nombre = "amigo";
		}
		System.out.println("Hola " + nombre + "!");
		*/
		// Versión con if compuesto
		if (!"".equals(nombre)) {
			// si se cumple la condición
			System.out.println("Hola " + nombre + "!");
		} else {
			// si no se cumple la condición
			System.out.println("Hola amigo!");
		}
		scan.close();
	}

}
