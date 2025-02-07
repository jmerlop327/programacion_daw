package unidad05.animales;

public abstract class Ave extends Animal {
	private boolean domestico;
	private boolean volador;
	private Integer huevosPuestos;
	/**
	 * @return the domestico
	 */
	public boolean isDomestico() {
		return domestico;
	}
	
	
	/**
	 * @param domestico the domestico to set
	 */
	public void setDomestico(boolean domestico) {
		this.domestico = domestico;
	}
	
	public boolean isVolador() {
		return volador;
	}


	public void setVolador(boolean volador) {
		this.volador = volador;
	}


	public Ave(String lugarNacimiento, boolean domestico, boolean volador) {
		super(lugarNacimiento, 2);
		this.domestico = domestico;
		this.volador = volador;
		this.huevosPuestos = 0;
	}
	public void poneHuevo() {
		this.huevosPuestos++;
	}
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Es un ave.\n").append(super.toString());
		// TODO: Añadir si vuela o no y cuántos huevos ha puesto
		return sb.toString();
	}
}
