package unidad03;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ej01_02 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int opcion = 0;
		do {
			UtilidadesEj01_02.mostrarMenu();
			boolean correcto = true;
			System.out.println("Elige una opción:");
			//EXTRA:Manejo de excepción
			try {
				//Código susceptible de lanzar excepcion
				opcion = scan.nextInt();
			} catch(InputMismatchException ime) {
				//código a ejecutar si se produce una excepción
				correcto = false;
				//este next line, solo vacía el buffer de "basura"
				scan.nextLine();
				System.out.println("Solo se permiten números del 1 al 6.");
			}
			if (correcto) {
				switch (opcion) {
				case 1:
					int entero = UtilidadesEj01_02.aniadir(opcion);
					break;
				case 2:
					System.out.println("Has borrado un elemento!");
					break;
				case 3:
					System.out.println("Has modificado un elemento!");
					break;
				case 4:
					System.out.println("Has mostrado un elemento por pantalla!");
					break;
				case 5:
					System.out.println("Hasta pronto!");
					break;
				case 6:
					System.out.println("Cuántos saltos quieres introducir?");
					int saltos = scan.nextInt();
					UtilidadesEj01_02.saltos(saltos);
					break;
				default:
					System.out.println("Has elegido una opción incorrecta!");
					break;
				}
			}
		} while (opcion != 5);
	}
}
