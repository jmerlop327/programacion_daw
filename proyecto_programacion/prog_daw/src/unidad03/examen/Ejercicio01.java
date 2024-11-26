package unidad03.examen;

import java.util.Date;
import java.util.Scanner;

public class Ejercicio01 {

	public static void main(String[] args) {
		int opcion = -1;
		Scanner input = new Scanner(System.in);
		Date now = new Date();
		do {
			mostrarMenu();
			opcion = input.nextInt();
			switch (opcion) {
			case 0:
				System.out.println("Cerrando el programa...");
				System.out.println("Hasta la próxima!");
				break;
			case 1:
				System.out.printf("Son las %s\n\n", UtilidadesExamen.obtenerHoraActual(now));
				break;
			case 2:
				System.out.printf("Hoy es %s\n\n", UtilidadesExamen.obtenerDiaSemana(now));
				break;
			case 3:
				System.out.printf("Quedan %d días hasta las vacaciones\n\n",
						UtilidadesExamen.obtenerDiasHastaVacas(now));
				break;

			default:
				break;
			}
		} while (opcion != 0);
		input.close();

	}

	private static void mostrarMenu() {
		System.out.println("""
				------------------| MENÚ FECHAS |--------------------------------
				| 1 – Qué hora es? |
				| 2 – Qué día de la semana es? |
				| 3 – Cuántos días quedan para para las vacaciones de Navidad? |
				| 0 – Cerrar el programa |
				-----------------------------------------------------------------
				Introduce la opción deseada:
								""");
	}

}
