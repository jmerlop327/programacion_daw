package programame2025;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//https://programame.com/documents/ProblemsSets/2025/ProgramaMe-2025-Navidad.pdf
//https://aceptaelreto.com/problem/statement.php?id=765&cat=172
public class PreNavidenioC {

	static Scanner in;

	public static boolean casoDePrueba() {

		// LEER CASO DE PRUEBA
		int votos = Integer.parseInt(in.next());
		Map<String, Integer> votaciones = new HashMap<String, Integer>();
		if (votos == 0) {
			return false;
		} else {
			// CÓDIGO PRINCIPAL AQUÍ
			// Procesa un único caso leyendo con
			// in.next*()
			for (int i = 0; i < votos; i++) {
				String voto = in.next();
				if (!votaciones.containsKey(voto)) {
					votaciones.put(voto, 1);
				} else {
					votaciones.put(voto, votaciones.get(voto) + 1);
				}
			}
			muestraGanadores(votaciones);
			return true;
		}

	} // casoDePrueba

	private static void muestraGanadores(Map<String, Integer> votaciones) {
		String ganadorInf = "";
		int maxVotosInf = 0;
		String ganadorAdulto = "";
		int maxVotosAdulto = 0;
		for (String voto : votaciones.keySet()) {
			if (voto.matches("[a-z]*") && votaciones.get(voto) > maxVotosInf) {
				ganadorInf = voto;
				maxVotosInf = votaciones.get(voto);
			} else if (voto.matches("[a-z]*") && votaciones.get(voto) == maxVotosInf) {
				ganadorInf = "empate";
			}
			if (voto.matches("[A-Z]*") && votaciones.get(voto) > maxVotosAdulto) {
				ganadorAdulto = voto;
				maxVotosAdulto = votaciones.get(voto);
			} else if (voto.matches("[A-Z]*") && votaciones.get(voto) == maxVotosAdulto) {
				ganadorAdulto = "EMPATE";
			}
		}
		System.out.println(ganadorInf + " " + ganadorAdulto);
	}

	public static void main(String[] args) {

		in = new java.util.Scanner(System.in);

		while (casoDePrueba())
			;

	} // main
}
