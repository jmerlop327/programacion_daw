package unidad02;

import java.util.Scanner;

/**
 * Introduciendo un año de nacimiento, el programa dirá si el usuario es:
 * bebé: 0-2 años
 * niñ@: 3-11 años
 * adolescente: 12-18 años
 * adulto: 19-65 años
 * anciano: +65 años
 * mostrará error si la edad es menor de 0 años
 */
public class EtapaVital {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Introduce tu año de nacimiento:");
		int anio = scan.nextInt();
		int edad = 2024-anio;
		if (edad < 0) {
			System.err.println("No se puede introducir un año mayor que el actual");
		} else if (edad <= 2) {
			System.out.println("Eres un bebé");
		} else if (edad < 12) {
			System.out.println("Eres un@ niñ@");
		} else if (edad <= 18) {
			System.out.println("Eres un@ adolescente");
		} else if (edad <= 65) {
			System.out.println("Eres un@ adult@");
		} else {
			System.out.println("Eres un@ ancian@");			
		}
	}

}
