package unidad02.boletin;

import java.util.Scanner;

/**
 * 15. Escribe un programa que pida por teclado un día de la semana (Lunes,
 * martes…) y que diga qué asignatura toca a primera hora ese día.
 */
public class Ejercicio15 {


	public static void main(String[] args) {
		final String ENDES = "Entornos de desarrollo";
		final String PROG = "Programación";
		final String BBDD = "Bases de datos";
		final String LUNES = "lunes";
		final String MARTES = "martes";
		final String MIERC_TILDE = "miércoles";
		final String MIERC = "miercoles";
		
		Scanner teclado = new Scanner(System.in);
		System.out.println("Introduce un día de la semana para saber que materia tienes a primera hora.");
		String input = teclado.nextLine().toLowerCase();
		teclado.close();
		String dia = "";
		String materia = "";
		boolean finde = false;
		boolean correcto = true;
		switch (input) {
		case LUNES:
			materia = ENDES;
			dia = LUNES;
			break;
		case MARTES:
			materia = PROG;
			dia = MARTES;
			break;
		case MIERC:
		case MIERC_TILDE:
			materia = BBDD;
			dia = MIERC_TILDE;
			break;
		//TODO:continuar con el resto de días

		default:
			correcto = false;
			break;
		}
		if (!finde && correcto) {			
			System.out.println("El " + dia + " a primera hora tienes " + materia + ".");
		} else if (finde && correcto) {
			System.out.println("Los fines de semana no hay clase.");
		} else {
			System.out.println("Has introducido un día incorrecto.");
		}

	}

}
