package unidad02.boletin;

import java.util.Scanner;

/**
 * Realiza un programa que resuelva una ecuación de segundo grado ax2 + bx + c =
 * 0
 */
public class Ejercicio04 {

	public static void main(String[] args) {
		// Scanner y recolección de datos
		Scanner scan = new Scanner(System.in);
		System.out.println("Siendo la ecuación ax2 + bx + c = 0");
		System.out.println("Introduzca el valor a");
		double a = scan.nextDouble();
		System.out.println("Introduzca el valor b");
		double b = scan.nextDouble();
		System.out.println("Introduzca el valor c");
		double c = scan.nextDouble();
		scan.close();
		// Operaciones
		if (a == 0) {
			System.out.println("El valor a no puede ser 0");
		} else if (Math.pow(b, 2) <= 4 * a * c) {
			System.out.println("El valor b cuadrado debe ser mayor que 4*a*c");
		} else {
			double xPositivo = (-b + Math.sqrt(Math.pow(b, 2) - (4 * a * c))) / (2 * a);
			double xNegativo = (-b - Math.sqrt(Math.pow(b, 2) - (4 * a * c))) / (2 * a);
			System.out.println("Las soluciones son " + xPositivo + " y " + xNegativo);
		}
	}

}
