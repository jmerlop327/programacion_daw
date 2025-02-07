package unidad05.animales;

public abstract class Mamifero extends Animal {
	private boolean domestico;
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
	
	public Mamifero(String lugarNacimiento, Integer numPatas, boolean domestico) {
		super(lugarNacimiento, numPatas);
		this.domestico = domestico;
	}
	public void mama() {
		System.out.println("El animal está mamando");
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Es un mamífero.\n").append(super.toString());
		return sb.toString();
	}
}
