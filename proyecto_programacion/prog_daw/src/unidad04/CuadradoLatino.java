package unidad04;

import java.util.Scanner;

/**
 * Crear un cuadrado latino en Java
 * 
 * Un cuadrado latino de orden N es una matriz cuadrada de N filas y N columnas
 * en la que su primera fila contiene los N primeros números naturales y cada
 * una de las filas siguientes contiene la rotación de la fila anterior un lugar
 * a la derecha.
 * 
 * Por ejemplo, un cuadrado latino de orden 4 es una matriz cuadrada de tamaño 4
 * x 4 con el siguiente contenido:
 *
 * 
 * 1 2 3 4
 * 4 1 2 3
 * 3 4 1 2
 * 2 3 4 1
 */
public class CuadradoLatino {

	public static void main(String[] args) {
		System.out.println("Vamos a crear un cuadrado latino, introduce la dimensión del cuadrado");
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[][] cuadradoLatino = new int[n][n];
		// Obtenemos datos del usuario para rellenar la primera fila
		for (int i = 0; i < n; i++) {
			System.out.println("Introduce el siguiente número de la primera fila");
			int numActual = scanner.nextInt();
			cuadradoLatino[0][i] = numActual;
		}
		// Rellenar el resto de filas con rotaciones de la anterior
		// cuadradoLatino[0].length
		for (int j = 1; j < n; j++) {
			int numAux = cuadradoLatino[j - 1][n - 1];
			for (int i = n - 1; i > 0; i--) {
				cuadradoLatino[j][i] = cuadradoLatino[j - 1][i - 1];
			}
			cuadradoLatino[j][0] = numAux;
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(cuadradoLatino[i][j] + "\t");
			}
			System.out.print("\n");
		}
	}

}
