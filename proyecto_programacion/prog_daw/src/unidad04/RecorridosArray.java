package unidad04;

public class RecorridosArray {

	public static void main(String[] args) throws Exception {
		final int filas = 4;
		final int columnas = 4;
		final int limInf = 150;
		final int limSup = 999;
		int[][] array = new int[filas][columnas];
		// int[][] array = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};

		// Crear un array de 4x4 con números aleatorios del 150 al 999
		// int aleatorio150a999 = (int) (Math.random()*849 + 150);
		// Tenemos que multiplicar el random por el lim superio +1 - lim inferior
		// y despues, sumar el lim inferior y hacer casting a entero.
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				int aleatorio150a999 = (int) (Math.random() * (limSup + 1 - limInf) + limInf);
				array[i][j] = aleatorio150a999;
			}
		}
		// Muestra el array completo
		mostrarArray(array);
		// Muestra el array completo por filas y columnas
		leerArrayPorFilasColumnas(array);
		// Muestra la diagonal principal
		leerDiagonalPrincipal(array);
		// Muestra la diagonal secundaria
		leerDiagonalSecundaria(array);
		// Muestra el array por columnas y filas
		leerArrayPorColumnasFilas(array);
		// Muestra el array por filas y columnas en orden inverso
		leerArrayPorFilasColumnasReverse(array);
		// Muestra el array por columnas y filas en orden inverso
		leerArrayPorColumnasFilasReverse(array);
		// Muestra el borde exterior del array empezando por el 00 y acabando por el 10
		

	}

	private static void leerArrayPorColumnasFilasReverse(int[][] array) {
		// calculamos dimensión del array
				int filas = array.length;
				int columnas = array[0].length;
				System.out.println("----------INICIO leerArrayPorColumnasFilasReverse------------");
				for (int i = filas -1; i >= 0; i--) {
					for (int j = columnas - 1; j >= 0; j--) {
						System.out.print(array[j][i] + "\t");
					}
				}
				System.out.println("\n-------------FIN leerArrayPorColumnasFilasReverse------------");
		
	}

	private static void leerArrayPorFilasColumnasReverse(int[][] array) {
		// calculamos dimensión del array
				int filas = array.length;
				int columnas = array[0].length;
				System.out.println("----------INICIO leerArrayPorFilasColumnasReverse------------");
				for (int i = filas-1; i >= 0; i--) {
					for (int j = columnas-1; j >= 0; j--) {
						System.out.print(array[i][j] + "\t");
					}
				}
				System.out.println("\n-------------FIN leerArrayPorFilasColumnasReverse------------");
		
	}

	private static void leerArrayPorColumnasFilas(int[][] array) {
		// calculamos dimensión del array
		int filas = array.length;
		int columnas = array[0].length;
		System.out.println("----------INICIO leerArrayPorColumnasFilas------------");
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				System.out.print(array[j][i] + "\t");
			}
		}
		System.out.println("\n-------------FIN leerArrayPorColumnasFilas------------");

		
	}

	private static void leerArrayPorFilasColumnas(int[][] array) {
		// calculamos dimensión del array
		int filas = array.length;
		int columnas = array[0].length;
		System.out.println("----------INICIO leerArrayPorFilasColumnas------------");
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				System.out.print(array[i][j] + "\t");
			}
		}
		System.out.println("\n-------------FIN leerArrayPorFilasColumnas------------");
		
	}

	private static void leerDiagonalSecundaria(int[][] array) {
		System.out.println("----------INICIO DIAGONAL SECUNDARIA------------");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i][array.length - 1 - i] + "\t");
		}
		System.out.println("\n-------------FIN DIAGONAL SECUNDARIA------------");
		
	}

	private static void leerDiagonalPrincipal(int[][] array) {
		System.out.println("----------INICIO DIAGONAL PRINCIPAL------------");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i][i] + "\t");
		}
		System.out.println("\n-------------FIN DIAGONAL PRINCIPAL------------");

	}

	private static void mostrarArray(int[][] array) {
		// calculamos dimensión del array
		int filas = array.length;
		int columnas = array[0].length;
		System.out.println("----------INICIO ARRAY------------");
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				System.out.print(array[i][j] + "\t");
			}
			System.out.print("\n");
		}
		System.out.println("\n-------------FIN ARRAY------------");

	}

}