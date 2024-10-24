package unidad02.examen;

import java.util.Scanner;

public class Ej01 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int opcion = 0;
		boolean salir = false;
		float lm = 11f;
		float prog = 11f;
		final String NO_EV = "NOEV";
		do {
			System.out.println("""
					----------------| Grado D. CFGS DAW |--------------
					| 1 – Módulo de Lenguaje de Marcas |
					| 2 – Módulo de Programación |
					| 0 – Resumen y salir |
					---------------------------------------------------
					""");
			System.out.println("Elige una opción:");
			opcion = scan.nextInt();
			switch (opcion) {
			case 0:
				salir = true;
				break;
			case 1:
				System.out.println("Introduce la nota de LM:");
				lm = scan.nextFloat();
				if (lm < 0 || lm > 10) {
					lm = 11f;
					System.out.println("La nota introducida para LM es incorrecta debe estar entre 0 y 10");
				}
				break;
			case 2:
				System.out.println("Introduce la nota de PROG:");
				prog = scan.nextFloat();
				if (prog < 0 || prog > 10) {
					prog = 11f;
					System.out.println("La nota introducida para PROG es incorrecta debe estar entre 0 y 10");
				}
				break;

			default:
				System.out.println("Has elegido una opción incorrecta!");
				break;
			}
		} while (!salir);
		scan.close();
		System.out.println("Calificaciones DAW");
		String progSt = (prog > 10 || prog < 0) ? NO_EV : "" + prog;
		System.out.println("Módulo de Programación:" + progSt);
		String lmST = (lm > 10 || lm < 0) ? NO_EV : "" + lm;
		System.out.println("Módulo de Lenguaje de Marcas:" + lmST);
	}

}
