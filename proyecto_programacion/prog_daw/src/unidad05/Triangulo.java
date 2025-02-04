package unidad05;

public class Triangulo {
	// Atributos
	Punto v1;
	Punto v2;
	Punto v3;

	// Constructores
	public Triangulo() {
		this.v1 = new Punto(0d, 1d);
		this.v2 = new Punto(1d, 0d);
		this.v3 = new Punto(-1d, 0d);
	}

	public Triangulo(Punto v1, Punto v2, Punto v3) {
		this.v1 = v1;
		this.v2 = v2;
		this.v3 = v3;
	}

	public Triangulo(Double v1x, Double v1y, Double v2x, Double v2y, Double v3x, Double v3y) {
		this.v1 = new Punto(v1x, v1y);
		this.v2 = new Punto(v2x, v2y);
		this.v3 = new Punto(v3y, v3y);
	}

	// Métodos heredados de object
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Triangulo:\n").append("vértice 1: ").append(v1);
		sb.append("vértice 2: ").append(v2);
		sb.append("vértice 3: ").append(v3);
		return sb.toString();
	}

	public boolean equals(Triangulo otroTriangulo) {
		return false;
	}

	// Métodos del objeto
	public Triangulo copiar(Double despX, Double despY) {
		Punto v1 = new Punto();
		v1.setX(this.v1.getX());
		v1.setY(this.v1.getY());
		v1.desplazar(despX, despY);

		Punto v2 = new Punto();
		v2.setX(this.v2.getX());
		v2.setY(this.v2.getY());
		v2.desplazar(despX, despY);

		Punto v3 = new Punto(this.v3.getX() + despX, this.v3.getY() + despY);
		Triangulo copia = new Triangulo(v1, v2, v3);
		return copia;
	}

	public void desplazar(Double despX, Double despY) {
		this.v1.desplazar(despX, despY);
		this.v2.desplazar(despX, despY);
		this.v3.desplazar(despX, despY);
	}

	public Double calcularPerimetro() {
		Double result = this.v1.calcularDistancia(this.v2) + this.v2.calcularDistancia(this.v3)
				+ this.v1.calcularDistancia(this.v3);
		return result;
	}

	public Double calcularArea() {
		// Mediante la fórmula de Herón
		Double s = this.calcularPerimetro() / 2;
		Double ladoA = this.v1.calcularDistancia(this.v2);
		Double ladoB = this.v2.calcularDistancia(this.v3);
		Double ladoC = this.v3.calcularDistancia(this.v1);
		Double area = Math.sqrt(s * (s - ladoA) * (s - ladoB) * (s - ladoC));
		return area;
	}
}
