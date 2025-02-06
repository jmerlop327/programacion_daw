package unidad05;

public class Gato extends Mamifero {

	public Gato (String lugarNacimiento) {
		super(lugarNacimiento, 4, Boolean.TRUE);
	}
	public void maulla() {
		System.out.println("Miau miau");
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		String domestico = this.isDomestico() ? "doméstico" : "salvaje";
		sb.append("El animal es un gato. Que es un animal ").append(domestico).append("\n").append(super.toString());
		return sb.toString();
	}

}
