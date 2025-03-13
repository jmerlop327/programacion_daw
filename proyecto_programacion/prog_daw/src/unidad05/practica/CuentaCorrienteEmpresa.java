package unidad05.practica;

import unidad05.persona.Persona;

public class CuentaCorrienteEmpresa extends CuentaCorriente {
	private static float interesDescubiertoPorDefecto = 0.02f;
	private float comisionFija;
	private float maxDescubierto;
	private float interesDescubierto;

	public CuentaCorrienteEmpresa(Persona titular, float saldo, String entidadesAutorizadas, float comisionFija,
			float maxDescubierto) {
		super(titular, saldo, entidadesAutorizadas);
		this.comisionFija = comisionFija;
		this.maxDescubierto = maxDescubierto;
		this.interesDescubierto = interesDescubiertoPorDefecto;
	}

	/**
	 * @return the comisionFija
	 */
	public float getComisionFija() {
		return comisionFija;
	}

	/**
	 * @param comisionFija the comisionFija to set
	 */
	public void setComisionFija(float comisionFija) {
		this.comisionFija = comisionFija;
	}

	/**
	 * @return the maxDescubierto
	 */
	public float getMaxDescubierto() {
		return maxDescubierto;
	}

	/**
	 * @param maxDescubierto the maxDescubierto to set
	 */
	public void setMaxDescubierto(float maxDescubierto) {
		this.maxDescubierto = maxDescubierto;
	}

	/**
	 * @return the interesDescubierto
	 */
	public float getInteresDescubierto() {
		return interesDescubierto;
	}

	/**
	 * @param interesDescubierto the interesDescubierto to set
	 */
	public void setInteresDescubierto(float interesDescubierto) {
		this.interesDescubierto = interesDescubierto;
	}
	
	public static void setInteresDescubiertoPorDefecto(float newInteresDescubiertoPorDefecto) {
		interesDescubiertoPorDefecto = newInteresDescubiertoPorDefecto;
	}
	@Override
	public void mostrarInfo() {
		StringBuilder sb = new StringBuilder();
		sb.append("Tipo de cuenta: Cuenta Corriente Empresa.\n");
		sb.append("Comisión fija por descubierto: ").append(this.comisionFija).append(" €\n");
		sb.append("Máximo descubierto: ").append(this.maxDescubierto).append(" €\n");
		sb.append("Interés por descubierto: ").append(this.interesDescubierto * 100).append("%\n");
		sb.append("-----\n");
		super.mostrarInfo();
		System.out.println(sb);
	}
}
