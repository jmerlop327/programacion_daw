package unidad04.boletin;

import java.util.Scanner;

/**
 * Escribe un programa que lea 15 números por teclado y que los almacene en un
 * array. Rota los elementos de ese array una posición a la derecha, es decir,
 * el elemento de la posición 0 debe pasar a la posición 1, el de la 1 a la 2,
 * etc. El número que se encuentra en la última posición debe pasar a la
 * posición 0. Finalmente, muestra el contenido del array.
 */
public class Ej05 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] numeros = new int[15];
		System.out.println("Introduce 15 números separados por espacios:");
		for (int i = 0; i < numeros.length; i++) {
			numeros[i] = scan.nextInt();
		}
		// Para rotar, guardamos el último, modificamos todos los valores y al final
		// guardamos el último en la primera posición
		int ultimo = numeros[numeros.length - 1];
		for (int i = numeros.length - 1; i > 0; i--) {
			numeros[i] = numeros[i - 1];
		}
		numeros[0] = ultimo;

		scan.close();
	}

}
