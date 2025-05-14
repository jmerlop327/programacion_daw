package unidad06.examen;

import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Ej03TaskManager {
	/*
	 * Tareas de ejemplo Completar el proyecto final del módulo de
	 * programación.Prioridad 1. Estudiar los apuntes de bases de datos para el
	 * examen. Prioridad 2. Practicar ejercicios de redes en el simulador. Prioridad
	 * 3. Revisar el manual de seguridad informática. Prioridad 4. Preparar una
	 * presentación sobre sistemas operativos. Prioridad 5. Actualizar el portafolio
	 * con los últimos trabajos. Prioridad 6. Organizar las notas de clase por
	 * temas. Prioridad 7.
	 */
	static Map<Integer, String> tareas = new TreeMap<Integer, String>();

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		tareas.put(1, "Completar el proyecto final del módulo de programación");
		tareas.put(2, "Estudiar los apuntes de bases de datos para el examen");
		tareas.put(3, "Practicar ejercicios de redes en el simulador");
		tareas.put(4, "Revisar el manual de seguridad informática");
		tareas.put(5, "Preparar una presentación sobre sistemas operativos");
		tareas.put(6, "Actualizar el portafolio con los últimos trabajos");
		tareas.put(7, "Organizar las notas de clase por temas");
		while (true) {
			// Mostrar las tareas ordenadas por prioridad
			mostrarTareas();
			System.out.println("\n------\n1. Realizar tarea\n2. Añadir tarea\nElige una opción:");
			String opcion = scan.nextLine();
			if ("1".equals(opcion)) {
				mostrarTareas();
				// elegir una tarea a realizar por su orden de prioridad
				System.out.println("Indica el número de la tarea que quieres realizar");
				String tarea = scan.nextLine();
				Integer tareaInt = Integer.parseInt(tarea);
				// Controlar NumberFormatException
				realizarTarea(tareaInt);
			} else if ("2".equals(opcion)) {
				// añadir una tarea dándole un orden de prioridad y una descripción
				System.out.println("Indica la prioridad de la tarea");
				Integer prioridad = Integer.parseInt(scan.nextLine());
				System.out.println("Indica la descripción de la tarea");
				String descripcion = scan.nextLine();
				aniadirTarea(prioridad, descripcion);
			} else {
				System.out.println("OPCIÓN INCORRECTA.");
			}
		}

	}

	private static void realizarTarea(int prioridad) {
		// Eliminar dicha tarea y reordenar las restantes
		if (tareas.containsKey(prioridad)) {
			tareas.remove(prioridad);
		} else {
			System.out.printf("La tarea %d no existe\n", prioridad);
		}
		Map<Integer, String> tareasAux = new TreeMap<Integer, String>();
		Integer nuevaClave = 1;
		// Reasignar claves consecutivas
		for (Integer prio : tareas.keySet()) {
			tareasAux.put(nuevaClave, tareas.get(prio));
			nuevaClave++;
		}
		// Actualizar el map original
		tareas = tareasAux;
	}

	private static void aniadirTarea(int prioridad, String descripcion) {
		// Añadir la tarea de la descripción en el lugar que indica la prioridad y
		// reordenar las ya existentes
		if (!tareas.containsKey(prioridad) && prioridad >= 1) {
			tareas.put(tareas.size() + 1, descripcion);
		} else {
			Map<Integer, String> tareasAux = new TreeMap<Integer, String>();
			Integer nuevaClave = 1;
			// Reasignar claves consecutivas
			for (Integer prio : tareas.keySet()) {
				String descAnterior = tareas.get(prio - 1);
				if (prio < prioridad) {
					tareasAux.put(nuevaClave, tareas.get(prio));
				} else if (prio == prioridad) {
					tareasAux.put(nuevaClave, descripcion);

				} else {
					tareasAux.put(nuevaClave, tareas.get(prio - 1));
				}
				nuevaClave++;
			}
			tareasAux.put(nuevaClave, tareas.get(tareas.size()));
			// Actualizar el map original
			tareas = tareasAux;
		}
	}

	private static void mostrarTareas() {
		for (Integer prioridad : tareas.keySet()) {
			System.out.println(prioridad + ". " + tareas.get(prioridad));
		}
	}
}
