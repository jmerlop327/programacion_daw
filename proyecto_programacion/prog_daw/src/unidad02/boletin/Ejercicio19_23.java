package unidad02.boletin;

import java.util.Scanner;

/**
 * 19. Muestra los números del 320 al 160, contando de 20 en 20 hacia atrás
 * utilizando un bucle for. EXTRA: Cambiar los valores por parámetros. inicio -
 * fin - incremento
 */
public class Ejercicio19_23 {
//	PROBLEMA INICIAL
//	public static void main(String[] args) {
//		for (int i = 320; i >= 160; i-=20) {
//			System.out.println(i);
//		}
//	}
	// PROBLEMA EXTRA
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.println("Introduce el número de inicio:");
		int inicio = scan.nextInt();
		System.out.println("Introduce el número de fin:");
		int fin = scan.nextInt();
		System.out.println("Introduce el número de incremento/decremento:");
		int incremento = scan.nextInt();
		scan.close();
		if (inicio >= fin) {
			for (int i = inicio; i >= fin; i -= incremento) {
				System.out.println(i);
			}
		} else {
			for (int i = inicio; i <= fin; i += incremento) {
				System.out.println(i);
			}
		}

	}

}
