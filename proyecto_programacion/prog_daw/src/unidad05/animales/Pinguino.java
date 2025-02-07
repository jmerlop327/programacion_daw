package unidad05.animales;

public class Pinguino extends Ave implements Nadador {

	public Pinguino(String lugarNacimiento) {
		super(lugarNacimiento, Boolean.FALSE, Boolean.FALSE);
	}

	public void grazna() {
		System.out.println("Wa wa wa");
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		String domestico = this.isDomestico() ? "doméstico" : "salvaje";
		String volador = this.isVolador() ? "vuela" : "no vuela";
		sb.append("El animal es un pingüino. Que es un animal ").append(domestico).append("\n")
				.append(super.toString());
		// TODO: completar con si es doméstico y si vuela
		return sb.toString();
	}

	public void nada() {

	}

	public Pez pesca(Pez pez) {
		return pez;
	}

	public void bucea() {

	}
}
