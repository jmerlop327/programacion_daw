package unidad05.examen;

import java.util.Arrays;

public class Granja implements Productor {
	private String nombre;
	private Trabajador[] trabajadores;

	public Granja(String nombre) {
		this.nombre = nombre;
		this.trabajadores = new Trabajador[100];
	}

	public void contratarTrabajador(Trabajador trab) {
		boolean contratado = false;
		int indice = 0;
		while (!contratado && indice < this.trabajadores.length) {
			if (null == trabajadores[indice]) {
				trabajadores[indice] = trab;
				contratado = true;
			}
			indice++;
		}
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	public Ganadero[] getGanaderos() {
		Ganadero[] ganaderos = new Ganadero[this.trabajadores.length];
		int indiceGanaderos = 0;
		for (Trabajador trabajador : this.trabajadores) {
			if (trabajador instanceof Ganadero) {
				Ganadero ganadero = (Ganadero) trabajador;
				ganaderos[indiceGanaderos++] = ganadero;
			}
		}
		return ganaderos;
	}

	public Agricultor[] getAgricultores() {
		Agricultor[] agricultores = new Agricultor[this.trabajadores.length];
		int indiceAgricultores = 0;
		for (Trabajador trabajador : this.trabajadores) {
			if (trabajador instanceof Agricultor) {
				Agricultor agricultor = (Agricultor) trabajador;
				agricultores[indiceAgricultores++] = agricultor;
			}
		}
		return agricultores;
	}

	@Override
	public double calcularProduccion() {
		double produccionTotal = 0d;
		for (Trabajador trabajador : this.trabajadores) {
			if (null != trabajador && trabajador instanceof Agricultor) {
				Agricultor agricultor = (Agricultor) trabajador;
				produccionTotal += agricultor.calcularProduccion();
			} else if (null != trabajador && trabajador instanceof Ganadero) {
				produccionTotal += ((Ganadero) trabajador).calcularProduccion();
			}
		}
		return produccionTotal;
	}

	@Override
	public void mostrarDatos() {
		int numTrabajadores = 0;
		for (Trabajador trabajador : this.trabajadores) {
			if (null != trabajador) {
				numTrabajadores++;
			}
		}
		Trabajador[] copiaTrab = Arrays.copyOf(this.trabajadores, numTrabajadores);
		Arrays.sort(copiaTrab);
		for (Trabajador trabajador : copiaTrab) {
			if (null != trabajador && trabajador instanceof Agricultor) {
				Agricultor agricultor = (Agricultor) trabajador;
				agricultor.mostrarDatos();
			} else if (null != trabajador && trabajador instanceof Ganadero) {
				((Ganadero) trabajador).mostrarDatos();
			}
		}

	}
}
