package unidad05.practica;

import unidad05.persona.Persona;

public class CuentaCorrientePersonal extends CuentaCorriente {
	private static float comisionMantenimientoPorDefecto = 23.45f;
	private float comisionMantemiento;
	public CuentaCorrientePersonal(Persona titular, float saldo, String entidadesAutorizadas) {
		super(titular, saldo, entidadesAutorizadas);
		this.setComisionMantemiento(comisionMantenimientoPorDefecto);
	}
	public float getComisionMantemiento() {
		return comisionMantemiento;
	}
	public void setComisionMantemiento(float comisionMantemiento) {
		this.comisionMantemiento = comisionMantemiento;
	}
	public static void setComisionMantenimientoPorDefecto(float newComisionMantenimientoPorDefecto) {
		comisionMantenimientoPorDefecto = newComisionMantenimientoPorDefecto;
	}
	@Override
	public void mostrarInfo() {
		StringBuilder sb = new StringBuilder();
		sb.append("Tipo de cuenta: Cuenta Corriente Personal.\n");
		sb.append("Comisión de mantenimiento anual: ").append(this.comisionMantemiento).append(" €");
		sb.append("-----\n");
		super.mostrarInfo();
		System.out.println(sb);
	}
	
}
