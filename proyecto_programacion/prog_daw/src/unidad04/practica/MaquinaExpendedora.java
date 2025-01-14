package unidad04.practica;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MaquinaExpendedora {

	public static void main(String[] args) {
		String[][] productos = { { "Coca-Cola", "Sprite", "Fanta naranja" }, { "Fanta limón", "Red Bull", "Monster" },
				{ "Pepsi", "Schweppes tónica", "Agua mineral" }, { "Cruzcampo", "Heineken", "Zumo de piña" } };
		int[][] cantidad = new int[productos.length][productos[0].length];
		for (int i = 0; i < cantidad.length; i++) {
			Arrays.fill(cantidad[i], 5);
		}
		StringBuilder patternSB = new StringBuilder();
		patternSB.append("[1-").append(productos.length).append("][1-").append(productos[0].length).append("]");
		String pattern = patternSB.toString();
		// "productos.length][productos[0].length]
		Scanner scanner = new Scanner(System.in);
		boolean salir = false;
		do {
			System.out.println("""
					Introduce una opción
					1.- Pedir bebida
					2.- Mostrar bebidas
					3.- Apagar la máquina
					""");
			int opcion =0;
			try {
				opcion = scanner.nextInt();
			} catch (InputMismatchException e) {
				opcion = 0;
				//si hay error limpiamos el buffer
				scanner.nextLine();
			}
			switch (opcion) {
			case 1:
				System.out.println("Introduzca la posición de la bebida que desea tomar");
				// para vaciar el buffer después del nextInt
				scanner.nextLine();
				String opcionBebida = scanner.nextLine();
				if (!opcionBebida.matches(pattern)) {
					// Dos opciones, levantar exception o mostrar error
					// throw new IllegalArgumentException("opción de bebida incorrecta");
					System.err.println("La posición introducida no es correcta");
				} else {
					int fila = Integer.parseInt(opcionBebida.substring(0, 1)) -1;
					int col = Integer.parseInt(opcionBebida.substring(1)) -1;
					if (cantidad[fila][col] > 0) {
						// hay producto disponible
						System.out.println("Aquí tiene su " + productos[fila][col]);
						cantidad[fila][col]--;
					} else {
						// no hay
						System.out.println("Lo sentimos, no queda " + productos[fila][col]);
					}
				}
				break;
			case 2:
				System.out.println("Las bebidas disponibles son:");
				for (int i = 0; i < productos.length; i++) {
					for (int j = 0; j < productos[0].length; j++) {
						if (cantidad[i][j] > 0) {
							System.out.println(productos[i][j] + " " + (i + 1) + (j + 1));
						}
					}
				}
				break;
			case 3:
				salir = true;
				break;
			default:
				System.err.println("La opción elegida es incorrecta");
				break;
			}

		} while (!salir);

	}

}
