package unidad06.examen;

import java.util.Scanner;

public class Ej03TaskManager {
/*
Tareas de ejemplo
Completar el proyecto final del módulo de programación.Prioridad 1.
Estudiar los apuntes de bases de datos para el examen.	Prioridad 2.
Practicar ejercicios de redes en el simulador.			Prioridad 3.
Revisar el manual de seguridad informática.			Prioridad 4.
Preparar una presentación sobre sistemas operativos.	Prioridad 5.
Actualizar el portafolio con los últimos trabajos.		Prioridad 6.
Organizar las notas de clase por temas.				Prioridad 7.
 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while (true) {
			// Mostrar las tareas ordenadas por prioridad
			System.out.println("1. Realizar tarea\n2.Añadir tarea\nElige una opción:");
			if ("1".equals(scan.nextLine())) {
				// elegir una tarea a realizar por su orden de prioridad
			} else if ("2".equals(scan.nextLine())) {
				// añadir una tarea dándole un orden de prioridad y una descripción
			} else {
				System.out.println("OPCIÓN INCORRECTA.");
			}
		}

	}

	private void realizarTarea(int prioridad) {
		// Eliminar dicha tarea y reordenar las restantes
	}

	private void aniadirTarea(int prioridad, String descripcion) {
		// Añadir la tarea de la descripción en el lugar que indica la prioridad y
		// reordenar las ya existentes
	}
}
