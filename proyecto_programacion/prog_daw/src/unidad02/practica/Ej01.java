package unidad02.practica;

import java.util.Scanner;

public class Ej01 {

	public static void main(String[] args) {
		final String PASSWORD = "miContra#seña";
		Scanner sc = new Scanner(System.in);
		boolean esCorrecto = false;
		int intentos = 0;
		do {
			System.out.println("Introduce tu contraseña:");
			String input = sc.nextLine();
			intentos++;
			if (PASSWORD.equals(input)) {
				esCorrecto = true;
			} else {
				System.out.printf("Contraseña incorrecta. Te quedan %d intentos.\n", 3-intentos);
			}
		} while(!esCorrecto && intentos < 3);
		sc.close();
		if (esCorrecto) {
			System.out.println("Bienvenido a tu espacio personal!");
		} else {
			System.out.println("No te quedan más intentos. Cuenta bloqueada.");
		}
	}

}
