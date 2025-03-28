package unidad05.examen;

import java.util.Random;

public abstract class Trabajador implements Productor, Comparable<Trabajador> {
	private String nombre;
	private String apellidos;
	private double produccionBase;

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @return the apellidos
	 */
	public String getApellidos() {
		return apellidos;
	}

	protected String id;

	public Trabajador(String nombre, String apellidos, double produccionBase) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.produccionBase = produccionBase;
		this.id = generarId();
	}

	private String generarId() {
		String id = "";
		final String[] LETRAS = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q",
				"R", "S", "T", "U", "V", "W", "X", "Y", "Z" };
		Random rand = new Random();
		int indLetra1 = rand.nextInt(0, LETRAS.length - 1);
		int indLetra2 = rand.nextInt(0, LETRAS.length - 1);
		int num1 = rand.nextInt(0, 9);
		int num2 = rand.nextInt(0, 9);
		int num3 = rand.nextInt(0, 9);
		id+= LETRAS[indLetra1] + LETRAS[indLetra2] + num1 + num2 + num3;
		if (this instanceof Agricultor) {
			id+="R";
		} else if (this instanceof Ganadero) {
			id+="G";
		}
		return id;
	}

	@Override
	public int compareTo(Trabajador otroTrab) {
		if (null != this && null == otroTrab) {
			return 1;
		} else {			
			return this.id.compareTo(otroTrab.id);
		}
	}

	/**
	 * @return the produccionBase
	 */
	public double getProduccionBase() {
		return produccionBase;
	}
}
