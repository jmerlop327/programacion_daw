package unidad04.examen;

import java.util.Scanner;

public class Pangrama {

	public static void main(String[] args) {
//		Un pangrama es una frase que contiene al menos una vez todas las
//		letras del abecedario.
//		 La entrada del programa solo debe tener letras del abecedario español
//		sin tildes, espacios, comas y puntos. El programa debe ignorar
//		mayúsculas, minúsculas y los caracteres que no sean letras. En caso de
//		introducir algún carácter que no sea de los mencionados se debe tratar
//		dicho error con una excepción y notificar al usuario convenientemente.
//		 El programa debe indicar si el texto es un pangrama o no.
//		 En caso de no ser un pangrama, el programa debe indicar las letras que
//		han faltado para serlo.
		// El veloz murcielago hindu comia feliz cardillo y kiwi. La cigueña tocaba el
		// saxofon detras del palenque de paja
		
		Scanner scan = new Scanner(System.in);
		// pasamos la entrada a minúsculas para hacerlo más sencillo (también se podría
		// pasar a mayúsculas)
		System.out.println("Introduce una frase para ver si es un pangrama");
		String input = scan.nextLine().toLowerCase();
		final String LETRAS = "abcdefghijklmnñopqrstuvwxyz";
		final String PATRON_CARACTERES_VALIDOS = "[a-zñ,\\.\\s]*";
		if (input.matches(PATRON_CARACTERES_VALIDOS)) {
			// si se cumple el patrón en la entrada recorremos las letras y comprobamos si
			// están todas
			int indice = 0;
			String letrasInput = "";
			// mientras que el número de letrasInput sea menor que todas las letras seguimos
			// avanzando en la entrada
			while (letrasInput.length() < LETRAS.length() && indice < input.length()) {
				// De esta forma, pararemos de procesar cuando estén todas las letras o cuando
				// lleguemos al final de la cadena de entrada
				String letraActual = Character.toString(input.charAt(indice));
				if (!letrasInput.contains(letraActual)) {
					// si letrasInput no tiene la letra actual la añadimos
					letrasInput += letraActual;
				}
				indice++;
			}
			// En caso de que no se encuentren todas las letras debemos indicar las que
			// faltan comparando letrasInput y las LETRAS del abecedario
			if (letrasInput.length() < LETRAS.length()) {
				System.out.println("El texto no es un pangrama. Faltan las siguientes letras:");
				for (int i = 0; i < LETRAS.length(); i++) {
					String letraActual = Character.toString(LETRAS.charAt(i));
					if (!letrasInput.contains(letraActual)) {
						System.out.println("- " + letraActual);
					}
				}
			} else {
				System.out.println("El texto es un pangrama.");
			}
		} else {
			System.out.println("El texto tiene caracteres no permitidos");

		}

	}

}
