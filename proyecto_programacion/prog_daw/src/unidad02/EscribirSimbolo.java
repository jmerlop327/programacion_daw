package unidad02;

import java.util.Scanner;

public class EscribirSimbolo {

	public static void main(String[] args) {
		// Operaciones de entrada y salida E/S para la toma de datos
		Scanner scan = new Scanner(System.in);		
		boolean error = false;
		String simbolo = "";
		int repeticiones = 0;
		String direccion = "";
		do {
			// se ejecuta la primera vez
			// y se sigue ejecutando si hay error
			System.out.println("Introduce el símbolo que quieres repetir (+ * $ €)");
			simbolo = scan.nextLine();

			System.out.println("Introduce cuántas veces quieres repetirlo");
			repeticiones = scan.nextInt();

			System.out.println("Introduce en qué dirección lo quieres escribir (vertical horizontal)");
			scan.nextLine();
			direccion = scan.nextLine();
			if (!"+".equals(simbolo) && !"*".equals(simbolo) && !"$".equals(simbolo) && !"€".equals(simbolo)) {
				error = true;
			}
			if (repeticiones < 3 || repeticiones > 10) {
				error = true;
			}
			if (!"vertical".equalsIgnoreCase(direccion) && !"horizontal".equalsIgnoreCase(direccion)) {
				error = true;
			}
			if (error)
				System.err.println("Los datos de entrada no son correctos!");
		} while (error);

		// procesado de los datos
		int indice = 0;
		while (indice < repeticiones && !error) {
			if ("vertical".equalsIgnoreCase(direccion)) {
				System.out.println(simbolo);
			} else {
				System.out.print(simbolo);
			}
			indice++;
		}

	}

}
