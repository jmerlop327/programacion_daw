package unidad05.practica;

import unidad05.persona.Persona;

public abstract class CuentaCorriente extends CuentaBancaria {
	private String entidadesAutorizadas;

	public CuentaCorriente(Persona titular, float saldo, String entidadesAutorizadas) {
		super(titular, saldo);
		this.entidadesAutorizadas = entidadesAutorizadas;
	}

	public String getEntidadesAutorizadas() {
		return entidadesAutorizadas;
	}

	public void setEntidadesAutorizadas(String entidadesAutorizadas) {
		this.entidadesAutorizadas = entidadesAutorizadas;
	}

	@Override
	public void mostrarInfo() {
		StringBuilder sb = new StringBuilder();
		sb.append("Lista de entidades autorizadas: ").append(this.entidadesAutorizadas);
		super.mostrarInfo();
		System.out.println(sb);

	}
}
