package unidad04.boletin;

public class Ej11_2 {
	/**
	 * Desarrolla un programa guarde 20 números enteros aleatorios en un array
	 * bidimensional de 4x5. El programa exhibirá las sumas parciales tanto por
	 * filas como por columnas, simularizando la presentación de una hoja de
	 * cálculo. La suma total se deberá mostrar en la esquina inferior derecha del
	 * array.
	 */
	public static void main(String[] args) {
		int[][] arrayBidimensional = new int[4][3];
		boolean esCuadrada = false;
		if (arrayBidimensional.length == arrayBidimensional[0].length) {
			esCuadrada = true;
		}
		for (int i = 0; i < arrayBidimensional.length; i++) {
			for (int j = 0; j < arrayBidimensional[0].length; j++) {
				int numAleatorio = (int) (Math.random() * 10);
				arrayBidimensional[i][j] = numAleatorio;
			}
		}
		int sumaFila = 0;
		
		int sumaDiagonal = 0;
		for (int i = 0; i < arrayBidimensional.length; i++) {
			for (int j = 0; j < arrayBidimensional[0].length; j++) {
				System.out.print(arrayBidimensional[i][j] + "\t");
				sumaFila += arrayBidimensional[i][j];
				if (esCuadrada && i==j) {					
					sumaDiagonal += arrayBidimensional[i][j];
				}
				
			}
			System.out.print(sumaFila + "\n");
			sumaFila = 0;
		}
		
		int sumaCol = 0;
		for (int j = 0; j < arrayBidimensional[0].length; j++) {
			for (int i = 0; i < arrayBidimensional.length; i++) {
				sumaCol += arrayBidimensional[i][j];
			}
			System.out.print(sumaCol + "\t");
			sumaCol = 0;
		}
		if (esCuadrada) {			
			System.out.print(sumaDiagonal);
		}
	}

}
