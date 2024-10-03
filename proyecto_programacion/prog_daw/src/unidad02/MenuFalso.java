package unidad02;

import java.util.Scanner;

/**
 * Mostrar el siguiente menú
 * 
 * MENÚ. Elige una opción: 1. Comprimir archivo 2. Eliminar archivo 3. Copiar
 * archivo 4. Cerrar programa
 * 
 * Mostrará la opción elegida mostrará error si la opción no es válida
 */
public class MenuFalso {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("MENÚ. Elige una opción:");
		System.out.println("* 1. Comprimir archivo");
		System.out.println("* 2. Eliminar archivo");
		System.out.println("* 3. Copiar archivo");
		System.out.println("* 4. Cerrar programa");
		System.out.println("Elige una opción:");
		int opcion = scan.nextInt();
		/*
		 * //Con condicional compuesta if (opcion == 1) {
		 * System.out.println("Comprimiendo archivo..."); 
		 * } else if (opcion == 2) {
		 * System.out.println("Eliminando archivo..."); 
		 * } else if (opcion == 3) {
		 * System.out.println("Copiando archivo..."); 
		 * } else if (opcion == 4) {
		 * System.out.println("Hasta la próxima!"); 
		 * } else {
		 * System.err.println("Has elegido una opción incorrecta!"); 
		 * }
		 */
		switch (opcion) {
		case 1:
			System.out.println("Comprimiendo archivo...");
			break;
		case 2:
			System.out.println("Eliminando archivo...");
			break;
		case 3:
			System.out.println("Copiando archivo...");
			break;
		case 4:
			System.out.println("Hasta la próxima!");
			break;
		default:
			System.err.println("Has elegido una opción incorrecta!");
			break;
		}
	}

}
