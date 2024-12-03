package unidad04.boletin;

import java.util.Scanner;

/**
 * Escribe un programa que pida 10 números por teclado y que luego muestre los
 * números introducidos junto con las palabras “máximo” y “mínimo” al lado del
 * máximo y del mínimo respectivamente
 */
public class Ej04 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] numeros = new int[10];
		System.out.println("Introduce 10 números enteros separados por espacios:");
		for (int i = 0; i < numeros.length; i++) {
			numeros[i] = scan.nextInt();
		}
		scan.close();

		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		int maxIndex = -1;
		int minIndex = -1;
		for (int i = numeros.length - 1; i >= 0; i--) {
			int numActual = numeros[i];
			if (numActual > max) {
				max = numActual;
				maxIndex = i;
			}
			if (numActual < min) {
				min = numActual;
				minIndex = i;
			}

		}
		for (int i = 0; i < numeros.length; i++) {
			int numAtual = numeros[i];
			if (i != maxIndex && i != minIndex) {
				System.out.print(numAtual + "\t");				
			}
			if (i==maxIndex) {
				System.out.print(numAtual + " (máximo)\t");
			}
			if (i==minIndex) {
				System.out.print(numAtual + " (mínimo)\t");
			}
		}
	}

}
