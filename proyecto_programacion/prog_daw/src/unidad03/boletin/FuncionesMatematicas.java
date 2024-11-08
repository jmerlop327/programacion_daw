package unidad03.boletin;

public class FuncionesMatematicas {

	/**
	 * Devuelve true si el número pasado por parámetro es primo
	 * 
	 * @param numero
	 * @return esPrimo
	 */
	public static boolean esPrimo(long numero) {
		boolean esPrimo = true;

		int divisor = 2;
		while (esPrimo && divisor < numero / 2) {
			if (numero % divisor == 0) {
				esPrimo = false;
			}
			divisor++;
		}
		return esPrimo;
	}

	/**
	 * Devuelve el siguiente número primo a partir del parámetro de entrada
	 * 
	 * @param numero
	 * @return siguientePrimo
	 */
	public static long siguientePrimo(long numero) {
		long siguientePrimo = numero + 1;
		boolean encontrado = false;
		while (!encontrado) {
			if (esPrimo(siguientePrimo)) {
				encontrado = true;
			} else {
				siguientePrimo++;
			}
		}
		return siguientePrimo;
	}
	
	/**
	 * Devuelve el número de dígitos que tiene el parámetro de entrada
	 * @param numero
	 * @return numCifras
	 */
	public static int digitos (long numero) {
		int numCifras = 1;
		while (numero / 10 != 0) {
			numCifras++;
			numero = numero / 10;
		}
		return numCifras;
	}
	
	/**
	 * Devuelve true si el número es capicua y false en caso contrario
	 * @param numero
	 * @return esCapicua
	 */
	public static boolean esCapicua (long numero) {
		boolean esCapicua = true;
		long numActual = numero;
		int numCifras = digitos(numActual);
		for (int i = 0; i < numCifras / 2; i++) {
			long numDiv = (long) Math.pow(10, numCifras - i - 1);
			long numMod = (long) Math.pow(10, i);
			double numDelante = (numero / numDiv) % 10;
			double numDetras = (numero / numMod) % 10;
			if (numDelante != numDetras) {
				esCapicua = false;
			}
		}
		return esCapicua;
	}

	/**
	 * Devuelve la letra correspondiente al número de dni
	 * @param dni
	 * @return letra
	 */
	public static char letraNif(long dni) {
		String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
		int resto = (int) dni % 23;
		//0: "T", 1: "R", 2: "W", 3: "A", 4: "G", 5: "M", 6: "Y", 7: "F", 
		//8: "P", 9:"D",10:"X", 11: "B", 12: "N",13: "J", 14: "Z", 
		//15: "S", 16: "Q", 17: "V", 18: "H", 19: "L", 20: "C", 21: "K",
		//22: "E".
		//OPCIÓN 1: switch con el resto
//		switch (resto) {
//		case 0:
//			letra = 'T';
//			break;
//
//		default:
//			break;
//		}
		//OPCIÓN 2: Usando charAt de String
		char letra = letras.charAt(resto);
		return letra;
	}
	
	/**
	 * Devuelve true si el dni es correcto
	 * @param dni
	 * @return correcto
	 */
	public static boolean compruebaDni(String dni) {
		if (dni.length() < 9) {
			int faltan = 9 - dni.length();
			for (int i = 0;i<faltan;i++) {
				dni = "0" + dni;
			}
		}
		char letra = dni.substring(8).charAt(0);
		long numero = Long.parseLong(dni.substring(0, 8));
		boolean correcto = letraNif(numero) == letra;
		return correcto;
	}
}
