/**
 * 
 */
package unidad05.practica;

import unidad05.persona.Persona;

/**
 * 
 */
public class CuentaAhorro extends CuentaBancaria {

	private static float tipoIntAnualPorDefecto = 0.05f;
	private float tipoIntAnual;

	/**
	 * @param titular
	 * @param saldo
	 */
	public CuentaAhorro(Persona titular, float saldo) {
		super(titular, saldo);
		this.setTipoIntAnual(tipoIntAnualPorDefecto);
	}

	public static void setTipoIntAnualPorDefecto(float newTipoIntAnualPorDefecto) {
		tipoIntAnualPorDefecto = newTipoIntAnualPorDefecto;
	}

	public float getTipoIntAnual() {
		return tipoIntAnual;
	}

	public void setTipoIntAnual(float tipoIntAnual) {
		this.tipoIntAnual = tipoIntAnual;
	}

	@Override
	public void mostrarInfo() {
		StringBuilder sb = new StringBuilder();
		float porcentaje = this.tipoIntAnual * 100;
		String porcentajeStr = String.format("%.2f", porcentaje);
		sb.append("Tipo de cuenta: Cuenta Ahorro. ").append("Tipo de interés anual: ").append(porcentajeStr)
				.append("%");
		sb.append("-----\n");
		super.mostrarInfo();
		System.out.println(sb);

	}

}
