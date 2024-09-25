package unidad01;

import java.util.Scanner;

public class ParImpar {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Introduce un número entero y veremos si es par o impar: ");
		int numero;
		numero = scan.nextInt();
		String paridad;
		paridad = numero % 2 == 0 ? "PAR" : "IMPAR";
		System.out.println("El número introducido es " + paridad);
		scan.close();
	}

}
