package unidad02.boletin;

import java.util.Scanner;

/**
 * 20. Escribe un programa que muestre los n primeros términos de la serie de
 * Fibonacci. El primer término de la serie de Fibonacci es 0, el segundo es 1 y
 * el resto se calcula sumando los dos anteriores, por lo que tendríamos que los
 * términos son 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144... El número n se
 * debe introducir por teclado.
 */
public class Ejercicio20 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduce cuántos números quieres en la serie de Fibonacci:");
		int n = scan.nextInt();
		String salida ="";
		scan.close();
		if (n == 1) {
			salida ="0";
		} else if (n == 2) {
			salida = "0, 1";
		} else {
			salida = "0, 1";
			int f1 = 1;
			int f2 = 0;
			for (int indice = 3;indice <= n;indice++) {
				int nuevo = f2 + f1;
				salida = salida + ", " +  nuevo;
				f2 = f1;
				f1 = nuevo;
			}
		}
		System.out.println(salida);
	}

}
