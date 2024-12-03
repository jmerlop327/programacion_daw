package unidad04.boletin;

public class Ej09 {
	/**
	 * Escribe un programa que genere 20 números enteros aleatorios entre 0 y 100 y
	 * que los almacene en un array. El programa debe ser capaz de pasar todos los
	 * números pares a las primeras posiciones del array (del 0 en adelante) y todos
	 * los números impares a las celdas restantes. Utiliza arrays auxiliares si es
	 * necesario.
	 */
	public static void main(String[] args) {
		int[] numeros = new int[20];
		for (int i = 0; i < numeros.length; i++) {
			numeros[i] = (int) (Math.random() * 101);
		}
		int[] aux = new int[numeros.length];
		int indexPar = 0;
		int indexImpar = numeros.length -1;
		for (int i = 0; i < numeros.length; i++) {
			int numActual = numeros[i];
			if (numActual %2 == 0) {
				aux[indexPar++] = numActual;
			} else {
				aux[indexImpar--] = numActual;
			}
		}
	}

}
