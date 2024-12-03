package unidad04.boletin;

import org.apache.commons.lang3.StringUtils;

public class FuncionesCadenas {

	/**
	 * esPalindromo: Este método debería verificar si una cadena es un palíndromo,
	 * lo que significa que la cadena se lee igual de izquierda a derecha que de
	 * derecha a izquierda.
	 * 
	 * @param cadena
	 * @return esPalindromo
	 */
	public static boolean esPalindromo(String cadena) {
		boolean esPalindromo = true;
		int pos = 0;
		while (pos < cadena.length() / 2) {
			if (cadena.charAt(pos) != cadena.charAt(cadena.length() - 1 - pos)) {
				esPalindromo = false;
			}
			pos++;
		}
		return esPalindromo;
		// OTRA OPCIÓN CON STRINGUTILS
		// return StringUtils.equals(cadena, invertirCadena(cadena));
	}

	/**
	 * conteoVocales: Debería contar el número de vocales en una cadena,
	 * proporcionando así la cantidad total de letras 'a', 'e', 'i', 'o' y 'u'.
	 * Extra: Incluye las vocales acentuadas en español.
	 * 
	 * @param cadena
	 * @return
	 */
	public static int conteoVocales(String cadena) {
		int vocales = 0;
		String vocalesRegex = "[aeiouAEIOUÁÉÍÓÚáéíóúüÜ]";
		for (int posicion = 0; posicion < cadena.length(); posicion++) {
			// cadenaTexto.matches(patron)
			if (Character.toString(cadena.charAt(posicion)).matches(vocalesRegex)) {
				vocales++;
			}
			// OTRA FORMA CON COMPARACIONES
//			if (cadena.charAt(posicion) == 'a' || cadena.charAt(posicion) == 'e' || cadena.charAt(posicion) == 'i'
//					|| cadena.charAt(posicion) == 'o' || cadena.charAt(posicion) == 'u') {
//				vocales++;
//			}
		}
		return vocales;
	}

	/**
	 * Comprueba si la fecha y el formato son válidos para formatos con día, mes y
	 * año
	 * 
	 * @param fecha
	 * @param formato
	 * @return
	 */
	public static void checkEjemploRegex(String cadena, String patron) {
		if (cadena.matches(patron)) {
			System.out.println("formato correcto");
		} else {
			System.out.println("formato INcorrecto");
		}
	}

	/**
	 * d) invertirCadena: Este método debería invertir el orden de los caracteres en
	 * una cadena, de modo que el primer carácter se convierta en el último y
	 * viceversa.
	 * 
	 * @param cadena
	 * @return
	 */
	public static String invertirCadena(String cadena) {
		return StringUtils.reverse(cadena);
	}

	/**
	 * eliminarEspacios: Eliminaría todos los espacios en blanco de una cadena,
	 * devolviendo una versión de la cadena sin espacios.
	 * 
	 * @param cadenaConEspacios
	 * @return cadenaSinEspacios
	 */
	public static String eliminarEspacios(String cadenaConEspacios) {
		String cadenaSinEspacios = StringUtils.replace(cadenaConEspacios, StringUtils.SPACE, "");
		return cadenaSinEspacios;
	}

	/**
	 * eliminarEspaciosDuplicados: Eliminaría todos los espacios repetidos que haya
	 * entre dos palabras, devolviendo una versión de la cadena con sus palabras
	 * separadas con un solo espacio
	 * 
	 * @return
	 */
	public static String eliminarEspaciosDuplicados(String cadenaConEspaciosDup) {
		String cadenaSinEspaciosDupl = StringUtils.trim(cadenaConEspaciosDup);
		String result = StringUtils.normalizeSpace(cadenaSinEspaciosDupl);
		// OPCION SIN StringUtils
//		boolean hayEspacio = false;
//		for (int index = 0; index < cadenaSinEspaciosDupl.length(); index++) {
//			char caracterActual = cadenaSinEspaciosDupl.charAt(index);
//			if (' ' == caracterActual && !hayEspacio) {
//				result += caracterActual;
//				hayEspacio = true;
//			} else if (' ' != caracterActual) {
//				result += caracterActual;
//				if (hayEspacio) {
//					hayEspacio = false;
//				}
//			}
//		}
		return result;
	}

	/**
	 * contarPalabras: Contaría el número de palabras en una cadena. Esto podría
	 * hacerse contando los espacios entre las palabras.
	 * 
	 * @param cadena
	 * @return palabras
	 */
	public static int contarPalabras(String cadena) {
		String[] palabrasArray = StringUtils.split(cadena, " ");
		return palabrasArray.length;
	}

	/**
	 * esNumero: Verificaría si una cadena representa un número. Esto podría
	 * implicar comprobar si todos los caracteres en la cadena son dígitos.
	 * 
	 * @param numeroStr
	 * @return esNumero
	 */
	public static boolean esNumero(String numeroStr) {
//		OPCION controlando la excepción de parseo.
		// boolean esNumero = true;
//		try {
//			Long.parseLong(numeroStr);
//		} catch (NumberFormatException nfe) {
//			esNumero = false;
//		}
//		return esNumero;
		return StringUtils.isNumeric(numeroStr);
	}
	
}
