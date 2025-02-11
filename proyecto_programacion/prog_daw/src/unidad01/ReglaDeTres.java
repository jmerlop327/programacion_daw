package unidad01;

import java.util.Scanner;

public class ReglaDeTres {

	public static void main(String[] args) {
		// Aquí escribimos nuestro código de resolución de reglas de 3
		System.out.println("""
				Introduce los valores para resolver la regla de 3
				a ---> b
				c ---> x
				""");
		// Declaración del objeto Scanner
		Scanner scan = new Scanner(System.in);
		// Definición de las variables del programa
		double a, b, c;
		System.out.print("Introduce el parámetro a (no puede ser 0):");
		a = scan.nextDouble();
		System.out.print("\nIntroduce el parámetro b:");
		b = scan.nextDouble();
		System.out.print("\nIntroduce el parámetro c:");
		c = scan.nextDouble();
		// solución x = (b*c)/a
		double x = (b*c)/a;
		System.out.println("\nLa solución de la regla de 3 es:");
		System.out.print(a);
		System.out.print(" ---> ");
		System.out.println(b);
		System.out.print(c);
		System.out.print(" ---> ");
		System.out.print(x);
		scan.close();
	}

}
