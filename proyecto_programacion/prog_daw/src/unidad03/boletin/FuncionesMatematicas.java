package unidad03.boletin;

public class FuncionesMatematicas {
	
	/**
	 * Devuelve true si el número pasado por parámetro es primo
	 * @param numero
	 * @return esPrimo
	 */
	public static boolean esPrimo (long numero) {
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
	 */
	public static long siguientePrimo(long numero) {
		
	}
	
}
