package unidad04.examen;

import java.util.Random;

public class MatrizFlecha {

	// Método principal para pruebas
	public static void main(String[] args) {
		// Crear una matriz cuadrada 4x4
		int[][] matrizNoFlecha = crearMatrizDimMN(4, 4);
		System.out.println("Matriz generada:");
		mostrarMatriz(matrizNoFlecha);
		if (esTipoFlecha(matrizNoFlecha)) {
			System.out.println("La matriz es de tipo flecha.");
		} else {
			System.out.println("La matriz no es de tipo flecha.");
		}
		int[][] matrizFlecha = { { -3, 0, 0, 1 }, { 4, -2, 0, 0 }, { -5, 6, 8, 0 }, { 7, -4, 10, 15 } };
		System.out.println("Matriz flecha puesta a mano:");
		mostrarMatriz(matrizFlecha);
		if (esTipoFlecha(matrizFlecha)) {
			System.out.println("La matriz es de tipo flecha.");
		} else {
			System.out.println("La matriz no es de tipo flecha.");
		}
	}

	/**
	 * Método para mostrar la matriz
	 * 
	 * @param matriz
	 */
	public static void mostrarMatriz(int[][] matriz) {
		for (int[] fila : matriz) {
			for (int elemento : fila) {
				System.out.print(elemento + " \t");
			}
			System.out.println();
		}
	}

	/**
	 * Método para crear una matriz con dimensiones dadas y valores aleatorios entre
	 * -100 y 100
	 * 
	 * @param filas
	 * @param columnas
	 * @return
	 */
	public static int[][] crearMatrizDimMN(int filas, int columnas) {
		Random random = new Random();
		int[][] matriz = new int[filas][columnas];

		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				// Valores entre -100 y 100
				int aleatorio = random.nextInt(201) - 100;
				matriz[i][j] = aleatorio;
			}
		}

		return matriz;
	}

	// Método para verificar si la matriz es tipo flecha
	public static boolean esTipoFlecha(int[][] matriz) {
		boolean esTipoFlecha = true;
		if (matriz.length == matriz[0].length) {
			// Primer valor de la diagonal, partiremos comparando con este
			int sumaAnterior = matriz[0][0];
			// Empezamos en el 2º elemento de la diagonal comparando con el anterior
			for (int i = 1; i < matriz.length; i++) {
				// Elemento de la diagonal
				int sumaActual = matriz[i][i];

				for (int j = 0; j < i; j++) {
					// Suma los elementos de la fila hacia la izquierda
					sumaActual += matriz[i][j];
					// Suma elementos de la columna hacia arriba
					sumaActual += matriz[j][i];
				}

				if (sumaActual <= sumaAnterior) {
					// No cumple la condición de ser tipo flecha
					esTipoFlecha = false;
				}

				sumaAnterior = sumaActual;
			}
		} else {
			//Si no es cuadrada no cumple las condiciones
			esTipoFlecha = false;
		}
		return esTipoFlecha;
	}

}
