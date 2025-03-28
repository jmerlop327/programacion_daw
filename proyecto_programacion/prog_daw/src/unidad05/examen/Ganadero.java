package unidad05.examen;

public class Ganadero extends Trabajador {
	private int numAnimales;

	public Ganadero(String nombre, String apellidos, double produccionBase, int numAnimales) {
		super(nombre, apellidos, produccionBase);
		this.numAnimales = numAnimales;
	}

	@Override
	public double calcularProduccion() {
		return this.getProduccionBase() + (this.numAnimales * 7.5d);
	}

	@Override
	public void mostrarDatos() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.id).append(" - ").append(this.getNombre()).append(" ").append(this.getApellidos()).append(": ")
				.append(this.calcularProduccion()).append(" unidades");
		System.out.println(sb);

	}
}
