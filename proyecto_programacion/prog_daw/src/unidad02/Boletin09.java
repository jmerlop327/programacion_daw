package unidad02;

import java.util.Scanner;

public class Boletin09 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce el carácter para formar la pirámide");
		String input = sc.nextLine();
		System.out.println("Introduce la dirección de la pirámide");
		System.out.println("Introduce 1 para arriba");
		System.out.println("Introduce 2 para abajo");
		System.out.println("Introduce 3 para la derecha");
		System.out.println("Introduce 4 para la izquierda");
		int inputDireccion = sc.nextInt();

		boolean correcto = false;
		char caracter = 1;
		if (input.length() == 1) {
			caracter = input.charAt(0);
			if (caracter >= 'A' && caracter <= 'Z') {
				correcto = true;
			} else if (caracter >= 'a' && caracter <= 'z') {
				correcto = true;
			} else if (caracter >= '0' && caracter <= '9') {
				correcto = true;
			} else if (caracter == '$' || caracter == '€' || caracter == '+' || caracter == '*') {
				correcto = true;
			}
		} else {
			System.err.println("Solo puedes introducir un carácter");
		}

		if (correcto) {
			switch (inputDireccion) {
			case 1:
				String piramide = "  " + caracter + "  " + "\n" + " " + caracter + caracter + caracter + " " + "\n"
						+ caracter + caracter + caracter + caracter + caracter;
				System.out.println(piramide);

				break;
			case 2:

				break;
			case 3:

				break;
			case 4:

				break;

			default:
				System.err.println("La entrada no es válida");
				break;
			}
		} else {
			System.err.println("La entrada no es válida");
		}

	}

}
