package unidad05;

public class Triangulo {
	Punto v1;
	Punto v2;
	Punto v3;
	
	public Triangulo() {
		this.v1 = new Punto(0d,1d);
		this.v2 = new Punto(1d,0d);
		this.v3 = new Punto(-1d,0d);
	}
	public Triangulo(Punto v1,Punto v2,Punto v3) {
		this.v1 = v1;
		this.v2 = v2;
		this.v3 = v3;
	}
	public Triangulo(Double v1x, Double v1y, Double v2x, Double v2y, Double v3x, Double v3y) {
		this.v1 = new Punto(v1x,v1y);
		this.v2 = new Punto(v2x,v2y);
		this.v3 = new Punto(v3y,v3y);
	}
}
