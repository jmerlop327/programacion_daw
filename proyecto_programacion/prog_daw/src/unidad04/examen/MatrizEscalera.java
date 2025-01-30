package unidad04.examen;

public class MatrizEscalera {

	public static void main(String[] args) {
		int[][] matrizNoEsc = { { 0, 0, 2 }, { 0, 3, 4 }, { 5, 1, 0 } };
		int[][] matrizSiEsc = { { 0, 0, 1 }, { 0, 2, 3 }, { 4, 5, 0 } };
		int[][] mat = crearMatrizDimMN(4, 4);
		mostrarMatriz(mat);
		System.out.println("------------------");
		mostrarEscalera(mat);
		System.out.println("------------------");
		mostrarMatriz(matrizSiEsc);
		System.out.println("------------------");
		mostrarEscalera(matrizSiEsc);
		System.out.println("------------------");
		mostrarMatriz(matrizNoEsc);
		System.out.println("------------------");
		mostrarEscalera(matrizNoEsc);
		System.out.println("------------------");
	}

	private static int[][] crearMatrizDimMN(int filas, int columnas) {
		int[][] matriz = new int[filas][columnas];
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				matriz[i][j] = (int) (Math.random() * 21) - 10;
			}
		}
		return matriz;
	}

	private static void mostrarMatriz(int[][] matriz) {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz.length; j++) {
				System.out.print(matriz[i][j] + "\t");
			}
			System.out.print("\n");
		}
	}

	private static boolean esTipoEscalera(int[][] matriz) {
		boolean esEscalera = matriz.length == matriz[0].length;
		int dim = matriz.length;
		int escalonAnterior = Integer.MIN_VALUE;
		int sumaAnterior = Integer.MIN_VALUE;
		if (esEscalera) {
			int i = 0;
			int j = 0;
			while (esEscalera && i < dim) {
				j = dim - i - 1;
				if (matriz[i][j] < escalonAnterior) {
					esEscalera = false;
				}
				int sumaActual = 0;
				while (esEscalera && j < dim) {
					sumaActual += matriz[i][j];
					j++;
				}
				if (sumaActual < sumaAnterior) {
					esEscalera = false;
				}
				i++;
			}
		}
		return esEscalera;
	}
	
	private static void mostrarEscalera(int[][] matriz) throws IllegalArgumentException {
		if (esTipoEscalera(matriz)) {
			int dim = matriz.length;
			for (int i = 0; i < dim; i++) {
				for (int j = 0; j < dim; j++) {
					if (j >= dim - i - 1) {
						System.out.print(matriz[i][j] + "\t");						
					} else {
						System.out.print("\t");
					}
				}
				System.out.print("\n");
			}
		} else {
			throw new IllegalArgumentException("La matriz no es tipo escalera");
		}
	}
}
