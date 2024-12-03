package unidad04.boletin;

import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;

/**
 * 6. Escribe un programa que genere un array con 10 posiciones con una letra
 * minúscula aleatoria y que las muestre por pantalla separados por espacios. El
 * programa pedirá entonces por teclado dos letras y a continuación cambiará
 * todas las ocurrencias de la primera letra por la segunda en la lista generada
 * anteriormente. Las letras modificadas deben aparecer en mayúscula. Ejemplo: a
 * b c r q p s r t e Escribe dos letras separadas por espacio: r m a b c M q p s
 * M t e
 * 
 */
public class Ej06 {

	public static void main(String[] args) {
		char[] letras = new char[10];
		String salida = StringUtils.EMPTY;
		for (int i = 0; i < letras.length; i++) {
			char random = (char) (Math.random() * ('z' - 'a') + 'a');
			letras[i] = random;
			salida += random + StringUtils.SPACE;
		}
		System.out.println(salida);
		System.out.println("Introduce la letra a sustituir y la que sustituye separadas por un espacio:");
		Scanner scanner = new Scanner(System.in);
		String cambio = scanner.nextLine();
		scanner.close();
		char caracterSustitucion = cambio.charAt(0);
		int diferencia = (int)('A' - 'a');
		char caracterSustituto = (char)(cambio.charAt(2) + diferencia);
		salida = StringUtils.EMPTY;
		for (int i = 0; i < letras.length; i++) {
			char caracterActual  = letras[i];
			if (caracterActual == caracterSustitucion) {
				caracterActual = caracterSustituto;
				salida += caracterSustituto + StringUtils.SPACE;
			} else {
				salida += caracterActual + StringUtils.SPACE;
			}
		}
		System.out.println(salida);
	}

}
