package unidad05.vehiculos;

public abstract class Vehiculo {
	private static Integer vehiculosCreados = 0;
	private static Double kilometrosTotales = 0d;
	private Double kilometrosRecorridos;

	public Vehiculo() {
		vehiculosCreados++;
		this.kilometrosRecorridos = 0d;
	}

	public Double getKilometrosRecorridos() {
		return kilometrosRecorridos;
	}

	public void setKilometrosRecorridos(Double kilometrosRecorridos) {
		double kms = this.kilometrosRecorridos;
		this.kilometrosRecorridos = kilometrosRecorridos;
		// Reajustar los km totales
		if (kms > kilometrosRecorridos) {
			double diferencia = kms - kilometrosRecorridos;
			kilometrosTotales -= diferencia;			
		} else {
			double diferencia = kilometrosRecorridos - kms;
			kilometrosTotales += diferencia;
		}
	}

	public void andar(double kilometros) {
		this.kilometrosRecorridos += kilometros;
		kilometrosTotales += kilometros;
	}

}
