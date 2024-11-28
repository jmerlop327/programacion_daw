package unidad04.boletin;

import java.util.Scanner;

public class Ej02 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] numeros = new int[10];
		for (int i = 0; i < numeros.length; i++) {
			System.out.println("Introduce un número:");
			numeros[i] = scan.nextInt();
		}
		scan.close();

		for (int i = numeros.length - 1; i > 0; i--) {
			System.out.print(numeros[i] + ", ");
		}
		System.out.print(numeros[0]);
		
	}

}
