package unidad05;

import unidad05.exceptions.BombillaDatosIncorrectosException;

public class Bombilla {
	// Atributos
	private String marca;
	private float potencia;
	private float precio;
	private String estado;
	private static final String ON = "encendida";
	private static final String OFF = "apagada";

	// Constructores
	public Bombilla() {
		this.marca = "";
		this.potencia = 0f;
		this.precio = 0f;
		this.estado = OFF;
	}

	public Bombilla(String marca, float potencia, float precio) throws BombillaDatosIncorrectosException {
		if (potencia < 0 || precio < 0) {
			throw new BombillaDatosIncorrectosException("Error en los datos de entrada");
		}
		this.marca = marca;
		this.potencia = potencia;
		this.precio = precio;
		this.estado = OFF;
	}

	public Bombilla(String marca, float potencia, float precio, String estado)
			throws BombillaDatosIncorrectosException {
		if (potencia < 0 || precio < 0
				|| (!estado.equalsIgnoreCase("apagada") && !estado.equalsIgnoreCase("encendida"))) {
			throw new BombillaDatosIncorrectosException("Error en los datos de entrada");
		}
		this.marca = marca;
		this.potencia = potencia;
		this.precio = precio;
		this.estado = estado.toLowerCase();
	}

	// Getters y setters
	/**
	 * @return the marca
	 */
	public String getMarca() {
		return this.marca;
	}

	/**
	 * @param marca the marca to set
	 */
	public void setMarca(String marca) {
		this.marca = marca;
	}

	/**
	 * @return the potencia
	 */
	public float getPotencia() {
		return this.potencia;
	}

	/**
	 * @param potencia the potencia to set
	 * @throws BombillaDatosIncorrectosException
	 */
	public void setPotencia(float potencia) throws BombillaDatosIncorrectosException {
		if (potencia < 0) {
			throw new BombillaDatosIncorrectosException("Error en los datos de entrada");
		}
		this.potencia = potencia;
	}

	/**
	 * @return the precio
	 */
	public float getPrecio() {
		return this.precio;
	}

	/**
	 * @param precio the precio to set
	 * @throws BombillaDatosIncorrectosException
	 */
	public void setPrecio(float precio) throws BombillaDatosIncorrectosException {
		if (precio < 0) {
			throw new BombillaDatosIncorrectosException("Error en los datos de entrada");
		}
		this.precio = precio;
	}

	/**
	 * @return the estado
	 */
	public String getEstado() {
		return this.estado;
	}

	/**
	 * @param estado the estado to set
	 * @throws BombillaDatosIncorrectosException
	 */
	public void setEstado(String estado) throws BombillaDatosIncorrectosException {
		if (!estado.equalsIgnoreCase("apagada") || !estado.equalsIgnoreCase("encendida")) {
			throw new BombillaDatosIncorrectosException("Error en los datos de entrada");
		}
		this.estado = estado.toLowerCase();
	}

	// Métodos de objeto
	public void encender() {
		this.estado = ON;
	}

	public void apagar() {
		this.estado = OFF;
	}

	// Métodos generales heredados
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("__________").append("\nBombilla marca: ").append(this.marca).append("\n").append("precio: ")
				.append(this.precio).append(" €").append("\n").append("potencia: ").append(this.potencia).append(" W")
				.append("\n").append("estado: ").append(this.estado).append("\n---------");
		return sb.toString();
	}

	public boolean equals(Bombilla otraBombilla) {
		boolean iguales = false;
		if (this.marca.equalsIgnoreCase(otraBombilla.getMarca()) && this.potencia == otraBombilla.getPotencia()) {
			iguales = true;
		}
		return iguales;
	}
}
