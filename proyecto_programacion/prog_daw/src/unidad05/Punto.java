package unidad05;

import java.util.Objects;

public class Punto {
	// Atributos
	Double x;
	Double y;

	// Constructores
	public Punto() {
		this.x = 0d;
		this.y = 0d;
	}

	/**
	 * @param x
	 * @param y
	 */
	public Punto(Double x, Double y) {
		this.x = x;
		this.y = y;
	}

	// Getters y setters
	/**
	 * @return the x
	 */
	public Double getX() {
		return this.x;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(Double x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public Double getY() {
		return this.y;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(Double y) {
		this.y = y;
	}

	public boolean equals(Punto otroPunto) {
		boolean iguales = true;
		if (!this.x.equals(otroPunto.getX()) || !this.y.equals(otroPunto.getY())) {
			iguales = false;
		}
		return iguales;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Punto: (").append(this.x).append(", ");
		builder.append(this.y).append(")");
		return builder.toString();
	}

	public void desplazar(Double despX, Double despY) {
		this.x += despX;
		this.y += despY;
	}

	public Punto obtenerInverso() {
		Punto puntoInverso = new Punto(-this.x, -this.y);
		return puntoInverso;
	}

	public Double calcularArea() {
		return Math.abs(this.x * this.y);
	}

	public Double calcularPerimetro() {
		return (Math.abs(this.x) + Math.abs(this.y)) * 4;
	}
	
	public Double calcularDistancia(Punto otroPunto) {
		Double distancia = Math.sqrt(Math.pow(this.x - otroPunto.getX(), 2) + Math.pow(this.y - otroPunto.getY(), 2));
		return distancia;
	}

}
