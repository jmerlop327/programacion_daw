package programame;

import java.util.Scanner;

public class ejG {
	static Scanner in;

	public static void main(String[] args) {
		in = new Scanner(System.in);
		int numCasos = in.nextInt();
		for (int i = 0; i < numCasos; i++) {
			casoDePrueba();
		}
	}

	public static boolean casoDePrueba() {
		int filas = in.nextInt();
		int cols = in.nextInt();
		int filasOcultas = in.nextInt();
		int colsOcultas = in.nextInt();
		int celdas = filas*cols;
		int celdasOcultas = filasOcultas*cols + colsOcultas*filas - filasOcultas*colsOcultas;
		int celdasVisibles = celdas-celdasOcultas;
		System.out.println(celdasVisibles);
		return true;
	}

}
