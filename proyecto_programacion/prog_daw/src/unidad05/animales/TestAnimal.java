package unidad05.animales;

public class TestAnimal {

	public static void main(String[] args) {
		Gato felix = new Gato("Barbate");
		felix.maulla();
		System.out.println(felix);
		
		Pinguino pingu = new Pinguino("Polo norte");
		pingu.grazna();
		System.out.println(pingu);
		Atun atun = new Atun("Océano Atlántico");
		System.out.println("pesca: " + pingu.pesca(atun));
	}

}
