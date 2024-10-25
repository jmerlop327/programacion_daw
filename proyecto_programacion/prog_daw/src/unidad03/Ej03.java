package unidad03;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ej03 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		try {
			System.out.println("Introduce el parámetro A:");
			int A = scan.nextInt();
			System.out.println("Introduce el parámetro B:");
			int B = scan.nextInt();
			int result = A/B;
			System.out.printf("El resultado de %d / %d es %d", A, B, result);
		} catch (InputMismatchException e) {
			System.out.println("Solo se permite introducir números enteros");
		} catch (ArithmeticException e) {
			System.out.println("No se puede dividir por 0");			
		}

	}

}
