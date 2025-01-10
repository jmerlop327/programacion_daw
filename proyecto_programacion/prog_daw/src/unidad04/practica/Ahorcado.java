package unidad04.practica;

import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class Ahorcado {

	public static void main(String[] args) {
		final String[] PALABRAS = { "zanahoria", "mandarina", "limón", "aguacate", "patata", "espinaca", "fresa",
				"mango", "manzana", "coliflor" };
		Scanner input = new Scanner(System.in);
		int opcion = 0;
		do {
			System.out.println("""
					Elige la opción deseada:
					1.- Jugar
					2.- Salir del juego
					""");
			try {
				opcion = input.nextInt();
				input.nextLine();
			} catch (InputMismatchException e) {
				opcion = 0;
			}
			if (opcion == 1) {
				int random = (int) (Math.random() * PALABRAS.length);
				final String INCOGNITA = PALABRAS[random];
				String resuelta = "";
				for (int i = 0; i < INCOGNITA.length(); i++) {
					resuelta += "_ ";
				}
				
				
				/////////////////
				String opcionLetra = "";
				String letrasIncorrectas = "";
				do {
					System.out.println("Palabra: " + resuelta);
					System.out.println("""
							L.- Probar letra
							R.- Resolver palabra
							S.- Salir
							""");
					opcionLetra = input.nextLine();
					if ("L".equalsIgnoreCase(opcionLetra)) {
						System.out.println("Indica la letra");
						String letra = input.nextLine();
						String resueltaAux = "";
						if (INCOGNITA.contains(letra)) {
							for (int i = 0; i < INCOGNITA.length(); i++) {
								if (INCOGNITA.charAt(i) == letra.charAt(0)) {
									resueltaAux += letra + " ";
								} else if (INCOGNITA.charAt(i) != letra.charAt(0) && resuelta.charAt(i*2) != '_') {
									resueltaAux += resuelta.charAt(i*2) + " ";
								} else {
									resueltaAux += "_ ";
								}
							}
							resuelta = resueltaAux;
						} else {
							System.out.println("La palabra no contiene la letra " + letra);
							letrasIncorrectas += letra;
						}
					} else if ("R".equalsIgnoreCase(opcionLetra)) {
						System.out.println("has elegido R " + INCOGNITA);
						System.out.println(resuelta);
					} else if (!"S".equalsIgnoreCase(opcionLetra)) {
						System.err.println("Opción incorrecta!");
					}
				}
				while(!"S".equalsIgnoreCase(opcionLetra));
				
				//////////////////
			} else if (opcion != 2) {
				System.err.println("Opción incorrecta!");
			}
		} while (opcion != 2);
		System.out.println("Hasta la próxima!");
	}

}
