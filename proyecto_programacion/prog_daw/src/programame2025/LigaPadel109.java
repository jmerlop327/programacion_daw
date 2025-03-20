package programame2025;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//https://aceptaelreto.com/problem/statement.php?id=109
public class LigaPadel109 {

	static Scanner in;
	final static String FIN = "FIN";

	public static boolean casoDePrueba() {
		String categoria = in.nextLine();
		while (!FIN.equals(categoria)) {
			Map<String, Integer> clasificaciones = new HashMap<String, Integer>();
			int partidosJugados = 0;
			// LEER CASO DE PRUEBA
			String line = in.nextLine();
			// si llego aquí, tengo una categoria en line, entonces leemos los partidos
			while (!FIN.equals(line)) {

				// es un partido. se procesa el resultado
				String[] partido = line.split(" ");
				partidosJugados++;
				int setsEquipo1 = Integer.parseInt(partido[1]);
				int setsEquipo2 = Integer.parseInt(partido[3]);
				if (setsEquipo1 > setsEquipo2) {
					if (clasificaciones.get(partido[0]) == null) {
						clasificaciones.put(partido[0], 2);
					} else {
						clasificaciones.put(partido[0], clasificaciones.get(partido[0]) + 2);
					}
					if (clasificaciones.get(partido[2]) == null) {
						clasificaciones.put(partido[2], 1);
					} else {
						clasificaciones.put(partido[2], clasificaciones.get(partido[2]) + 1);
					}
				} else {
					if (clasificaciones.get(partido[0]) == null) {
						clasificaciones.put(partido[0], 1);
					} else {
						clasificaciones.put(partido[0], clasificaciones.get(partido[0]) + 1);
					}
					if (clasificaciones.get(partido[2]) == null) {
						clasificaciones.put(partido[2], 2);
					} else {
						clasificaciones.put(partido[2], clasificaciones.get(partido[2]) + 2);
					}
				}
				line = in.nextLine();
			}
			// fin de la categoria. mostrar resultado
			String ganador = calculaGanador(clasificaciones);
			int partidosNoJugados = calculaNumTotalPartidos(clasificaciones.size()) - partidosJugados;
			System.out.println(ganador + " " + partidosNoJugados);
			categoria = in.nextLine();
		}
		return false;
	} // casoDePrueba

	private static String calculaGanador(Map<String, Integer> clasificaciones) {
		String ganador = "EMPATE";
		int maxPuntos = 0;
		for (String equipo : clasificaciones.keySet()) {
			if (clasificaciones.get(equipo) > maxPuntos) {
				ganador = equipo;
				maxPuntos = clasificaciones.get(equipo);
			} else if (clasificaciones.get(equipo) == maxPuntos) {
				ganador = "EMPATE";
			}
		}
		return ganador;
	}

	private static int calculaNumTotalPartidos(int size) {
		int numPartidos = 0;
		for (int i = size - 1; i >= 0; i--) {
			numPartidos += i;
		}
		return numPartidos * 2;
	}

	public static void main(String[] args) {

		in = new java.util.Scanner(System.in);

		while (casoDePrueba())
			;

	} // main
}
