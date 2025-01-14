package unidad04.practica;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;

public class Ahorcado {


	public static void main(String[] args) {
		final String[] PALABRAS = { "zanahoria", "mandarina", "limón", "aguacate", "patata", "espinaca", "fresa",
				"mango", "manzana", "coliflor" };
		final String LETRASVALIDAS = "a-zA-ZñÑáéíóúÁÉÍÓÚüÜ";
		int oportunidades = 5;
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
				final String INCOGNITA_SIN_TILDE = quitarTildes(INCOGNITA);
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
						String letra = quitarTildes(input.nextLine());
						String resueltaAux = "";
						//TODO: considerar las letras ya usadas que han sido correctas
						if (letrasIncorrectas.contains(letra)) {
							System.out.println("La letra ya ha sido utilizada");
						} else if (!letra.matches(LETRASVALIDAS)) {
							System.out.println("Debe introducir un carácter válido");
						} else {
							if (INCOGNITA_SIN_TILDE.contains(letra)) {
								for (int i = 0; i < INCOGNITA_SIN_TILDE.length(); i++) {
									if (INCOGNITA_SIN_TILDE.charAt(i) == letra.charAt(0)) {
										//adaptación
										resueltaAux += INCOGNITA.charAt(i) + " ";
									} else if (INCOGNITA_SIN_TILDE.charAt(i) != letra.charAt(0) && resuelta.charAt(i*2) != '_') {
										resueltaAux += resuelta.charAt(i*2) + " ";
									} else {
										resueltaAux += "_ ";
									}
								}
								resuelta = resueltaAux;
							} else {
								oportunidades--;
								System.out.println("La palabra no contiene la letra " + letra);
								letrasIncorrectas += letra;
							}
						}
						
					} else if ("R".equalsIgnoreCase(opcionLetra)) {
						System.out.println("Indica la palabra");
						String palabra = quitarTildes(input.nextLine());
						//TODO: tildes may min
						if (INCOGNITA_SIN_TILDE.equalsIgnoreCase(palabra)) {
							System.out.println("Enhorabuena, has ganado!");
						} else {
							oportunidades--;
							System.out.println("La palabra no es correcta!");
						}
					} else if (!"S".equalsIgnoreCase(opcionLetra)) {
						System.err.println("Opción incorrecta!");
					}
				}
				while(!"S".equalsIgnoreCase(opcionLetra));
				
				//////////////////
			} else if (opcion != 2) {
				System.err.println("Opción incorrecta!");
			}
		} while (opcion != 2 && oportunidades > 0);
		if (oportunidades == 0) {
			System.out.println("Has agotado todos los intentos. Suerte para la próxima vez!");
		}
		System.out.println("Hasta la próxima!");
	}

	private static String quitarTildes(String palabra) {
		String palabraSinTildes = palabra.toLowerCase();
		palabraSinTildes = StringUtils.replace(palabra, "á", "a");
		palabraSinTildes = StringUtils.replace(palabra, "é", "é");
		palabraSinTildes = StringUtils.replace(palabra, "í", "í");
		palabraSinTildes = StringUtils.replace(palabra, "ó", "ó");
		palabraSinTildes = StringUtils.replace(palabra, "ú", "u");
		palabraSinTildes = StringUtils.replace(palabra, "ü", "u");
		return palabraSinTildes;
	}

}
