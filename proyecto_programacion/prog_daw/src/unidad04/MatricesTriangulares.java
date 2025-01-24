package unidad04;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MatricesTriangulares {

	static Scanner in;

	public static boolean esMatrizTriangular(int[][] matriz) {

		boolean triangular = false;
		int dim = matriz.length;
		if (dim == matriz[0].length) {
			boolean trianguloSup = true;
			boolean trianguloInf = true;
			int i = 0;
			while (i < dim && (trianguloInf || trianguloSup)) {
				int j = 0;
				while (j < dim && (trianguloInf || trianguloSup)) {
					int elemento = matriz[i][j];
					if (j > i && elemento != 0) {
						trianguloSup = false;
					}
					if (i > j && elemento != 0) {
						trianguloInf = false;
					}
					j++;
				}
				i++;
			}
			if (trianguloInf || trianguloSup) {
				triangular = true;
			} else {
				triangular = false;
			}
		}
		return triangular;

	}

	public static void main(String[] args) {

		in = new Scanner(System.in);
		try {
			System.out.println("Número de filas");
			int filas = in.nextInt();
			System.out.println("Número de columnas");
			int cols = in.nextInt();
			System.out.printf("Has elegido una matriz de %dx%d\n", filas, cols);
			int[][] matriz = new int[filas][cols];
			System.out.printf("Introduce todos los elementos separados por espacios");
			//limpiamos buffer
			in.nextLine();
			//comprobamos la entrada
			String input = in.nextLine();
			String[] numerosString = input.split(" ");
			if (numerosString.length != filas*cols) {
				throw new IllegalArgumentException("La cantidad de números introducidos no coincide con las dimensiones de la matriz");
			}
			int index = 0;
			for (int i = 0; i < filas; i++) {
				for (int j = 0; j < cols; j++) {
					matriz[i][j] = Integer.parseInt(numerosString[index++]);
				}
			}
			mostrarMatriz(matriz);
			if (esMatrizTriangular(matriz)) {
				System.out.println("La matriz introducida es triangular.");
			} else {
				System.out.println("La matriz introducida no es triangular.");
			}
		} catch (InputMismatchException e) {
			System.out.println("Los datos introducidos no son correctos. Solo se permiten números enteros");
		} catch (NumberFormatException e) {
			System.out.println("Los datos introducidos no son correctos. Solo se permiten números enteros");
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
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

}
