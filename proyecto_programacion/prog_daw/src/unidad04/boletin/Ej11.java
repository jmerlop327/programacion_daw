package unidad04.boletin;

public class Ej11 {
	/**
	 * Desarrolla un programa guarde 20 números enteros aleatorios en un array
	 * bidimensional de 4x5. El programa exhibirá las sumas parciales tanto por
	 * filas como por columnas, simularizando la presentación de una hoja de
	 * cálculo. La suma total se deberá mostrar en la esquina inferior derecha del
	 * array.
	 */
	public static void main(String[] args) {
		int[][] arrayBidimensional = new int[4][5];
		for (int i = 0; i < arrayBidimensional.length; i++) {
			for (int j = 0; j < arrayBidimensional[0].length; j++) {
				int numAleatorio = (int) (Math.random() * 10);
				arrayBidimensional[i][j] = numAleatorio;
			}
		}
		int sumaFila = 0;
		int[] sumaCol = new int[arrayBidimensional[0].length];
		int sumaTotal = 0;
		for (int i = 0; i < arrayBidimensional.length; i++) {
			for (int j = 0; j < arrayBidimensional[0].length; j++) {
				System.out.print(arrayBidimensional[i][j] + "\t");
				sumaFila += arrayBidimensional[i][j];
				sumaTotal += arrayBidimensional[i][j];
				sumaCol[j] += arrayBidimensional[i][j];
			}
			System.out.print(sumaFila + "\n");
			sumaFila = 0;
		}
		for (int num : sumaCol) {
			System.out.print(num + "\t");
			num=10;
		}
		System.out.print(sumaTotal);
	}

}
