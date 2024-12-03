package unidad04.boletin;

public class Ej03EjemploBidimensional {
	/**
	 * Crear una matriz bidimensional de 4x4 y rellenarlas de número aleatorios
	 * entre 0 y 100
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] arrayBidimensional = new int[4][4];
		for (int i = 0; i < arrayBidimensional.length; i++) {
			for (int j = 0; j < arrayBidimensional[0].length; j++) {
				int numAleatorio = (int) (Math.random() * 101);
				arrayBidimensional[i][j] = numAleatorio;
			}
		}
		
		for (int i = 0; i < arrayBidimensional.length; i++) {
			for (int j = 0; j < arrayBidimensional[0].length; j++) {
				System.out.print(arrayBidimensional[i][j]+"\t");
			}
			System.out.print("\n");			
		}

	}

}
