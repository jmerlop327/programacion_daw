package unidad06;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class MePilloElToro270Map {

	static Scanner in;

	public static boolean casoDePrueba() {

		// LEER CASO DE PRUEBA
		int casos = in.nextInt();
		in.nextLine();
		Map<String, Integer> tareas = new TreeMap<String, Integer>();
		if (casos == 0)
			return false;
		else {
			// CÓDIGO PRINCIPAL AQUÍ
			// Procesa un único caso leyendo con
			// in.next*()
			for (int i = 0; i < casos; i++) {
				String nombreAlumno = in.nextLine();
				String notaTarea = in.nextLine();
				if (notaTarea.equals("CORRECTO")) {
					if (tareas.containsKey(nombreAlumno)) {
						tareas.put(nombreAlumno, tareas.get(nombreAlumno) + 1);
					} else {
						tareas.put(nombreAlumno, 1);
					}
				} else {
					// INCORRECTO
					if (tareas.containsKey(nombreAlumno)) {
						tareas.put(nombreAlumno, tareas.get(nombreAlumno) - 1);
					} else {
						tareas.put(nombreAlumno, -1);
					}
				}

			}
			Set<String> nombresAlumnos = tareas.keySet();
			//recorrer las claves del map y mostrar los datos indicados
			for () {
				
			}
			return true;
		}

	} // casoDePrueba

	public static void main(String[] args) {

		in = new java.util.Scanner(System.in);

		while (casoDePrueba())
			;

	} // main
}
