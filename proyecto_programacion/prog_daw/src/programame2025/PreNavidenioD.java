package programame2025;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

//https://programame.com/documents/ProblemsSets/2025/ProgramaMe-2025-Navidad.pdf
//https://aceptaelreto.com/problem/statement.php?id=766
public class PreNavidenioD {

	// Creamos la clase Trabajador como clase static
	static class Trabajador implements Comparable<Trabajador> {
		private int horasTrabajadas;
		private int litrosSolicitados;

		public Trabajador(int horasTrabajadas, int litrosSolicitados) {
			this.horasTrabajadas = horasTrabajadas;
			this.litrosSolicitados = litrosSolicitados;
		}

		/**
		 * @return the horasTrabajadas
		 */
		public int getHorasTrabajadas() {
			return horasTrabajadas;
		}

		/**
		 * @param horasTrabajadas the horasTrabajadas to set
		 */
		public void setHorasTrabajadas(int horasTrabajadas) {
			this.horasTrabajadas = horasTrabajadas;
		}

		/**
		 * @return the litrosSolicitados
		 */
		public int getLitrosSolicitados() {
			return litrosSolicitados;
		}

		/**
		 * @param litrosSolicitados the litrosSolicitados to set
		 */
		public void setLitrosSolicitados(int litrosSolicitados) {
			this.litrosSolicitados = litrosSolicitados;
		}

		@Override
		public int compareTo(Trabajador otroTrabajador) {
			int compare = otroTrabajador.horasTrabajadas - this.horasTrabajadas;
			if (compare == 0) {
				compare = this.litrosSolicitados - otroTrabajador.litrosSolicitados;
			}
			return compare;
		}

	}
	//Fin clase trabajador
	static Scanner in;

	public static boolean casoDePrueba() {

		// LEER CASO DE PRUEBA
		int litrosHorchata = in.nextInt();
		int numTrabajores = in.nextInt();
		if (litrosHorchata == 0 && numTrabajores == 0) {
			return false;
		} else {
			// CÓDIGO PRINCIPAL AQUÍ
			// Procesa un único caso leyendo con
			// in.next*()
			List<Trabajador> trabajadores = new ArrayList<Trabajador>();
			for (int i = 0; i < numTrabajores; i++) {
				int horasTrabajadas = in.nextInt();
				int litrosSolicitados = in.nextInt();
				Trabajador trab = new Trabajador(horasTrabajadas, litrosSolicitados);
				trabajadores.add(trab);
			}
			// Ordenamos la List de Trabajador por su orden natural (Comparable - compareTo)
			Collections.sort(trabajadores);
			int trabajadoresSatisfechos = 0;
			// Creamos un iterator de Trabajador
			Iterator<Trabajador> itTrabajador = trabajadores.iterator();
			boolean quedaHorchata = true;
			// Recorremos el Iterator mientras existen elementos por recorrer
			while (itTrabajador.hasNext() && quedaHorchata) {
				Trabajador trabajador = itTrabajador.next();
				if (litrosHorchata >= trabajador.getLitrosSolicitados()) {
					litrosHorchata -= trabajador.getLitrosSolicitados();
					trabajadoresSatisfechos++;
				} else {
					quedaHorchata = false;
				}
			}
			System.out.println(trabajadoresSatisfechos + " " + litrosHorchata);
			return true;
		}

	} // casoDePrueba

	public static void main(String[] args) {

		in = new java.util.Scanner(System.in);

		while (casoDePrueba())
			;

	} // main
}
