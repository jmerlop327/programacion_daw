package unidad02;

import java.util.Scanner;

public class EjemploScanner {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce una cadena:");
		String cadena = sc.nextLine();
		System.out.println("Introduce un número:");
		int numero = sc.nextInt();
		System.out.println("Introduce una segunda cadena:");
		sc.nextLine();
		cadena = sc.next();
		System.out.println("El número es: " + numero + " - " + cadena);
	}

}
