package unidad05.examen;

public class Agricultor extends Trabajador {
	private double cosechaRecolectada;

	public Agricultor(String nombre, String apellidos, double produccionBase, int cosechaRecolectada) {
		super(nombre, apellidos, produccionBase);
		this.cosechaRecolectada = cosechaRecolectada;
	}

	@Override
	public double calcularProduccion() {
		return this.getProduccionBase() + (this.cosechaRecolectada * 0.05d);
	}

	@Override
	public void mostrarDatos() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.id).append(" - ").append(this.getNombre()).append(" ").append(this.getApellidos()).append(": ")
				.append(this.calcularProduccion()).append(" unidades");
		System.out.println(sb);

	}

}
