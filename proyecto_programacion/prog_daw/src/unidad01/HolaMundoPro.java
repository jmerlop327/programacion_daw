package unidad01;

import java.util.Scanner;

/**
 * Clase para el saludo pro en java
 * Saluda con Hola amigo si el usuario no introduce su nombre
 * Saluda con Hola nombre si el usuario introduce su nombre
 */
public class HolaMundoPro {

	public static void main(String[] args) {
		// metodo main
		Scanner scan = new Scanner(System.in);
		System.out.print("Introduce tu nombre:");
		String nombre = scan.nextLine();
		// Cuando el usuario no mete ningún nombre, el valor que guarda es una cadena
		// vacía, es decir, ""
		// Versión con operador ternario
		// nombre = "".equals(nombre) ? "amigo" : nombre;
		// Versión con if
		if ("".equals(nombre)) {
			nombre = "amigo";
		}
		System.out.println("Hola " + nombre + "!");
		scan.close();
	}

}
