package unidad02.boletin02;

import java.util.Scanner;

/**
 * Devuelve según la opción:
 * 1. cuál es la primera cifra de un número entero introducido por teclado
 * 2. cuál es la última cifra de un número entero introducido por teclado
 */
public class CifraPrimeraUltima {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Introduce un número entero:");
		int numero = scan.nextInt();
		
		System.out.println("""
Elige una opción:
1. Primera cifra
2. Última cifra
""");
		//Obligamos al usuario a introducir una opción válida
		boolean correcto = true;
		do {
			int opcion = scan.nextInt();
			switch (opcion) {
			case 1:
				//Obtiene la primera cifra del número
				int dividendo = numero;
				int primeraCifra = 0;
				while (dividendo != 0) {
					primeraCifra = dividendo;
					// la siguiente línea es equivalente a --> dividendo = dividendo / 10;
					dividendo /= 10;				
				}
				System.out.println("La primera cifra del número " + numero + " es " + primeraCifra);
				break;
			case 2:
				//Obtiene la última cifra del número
				int ultimaCifra = numero % 10;
				System.out.println("La última cifra del número " + numero + " es " + ultimaCifra);
				break;

			default:
				// no se ha introducido ni 1 ni 2
				correcto = false;
				System.out.print("No has elegido una opción válida! Debes elegir 1 o 2. Opción:");
				break;
			}
		} while(!correcto);
		scan.close();
	}

}
