package unidad05;

import java.util.Scanner;

public class CartaMain {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Carta asEspadas = new Carta("Espadas", "A");
		System.out.println(asEspadas.getPalo());
		Carta dosEspadas = new Carta("Espadas", "2");
		asEspadas.equals(dosEspadas);
		dosEspadas.equals(asEspadas);
		Carta cartaVacia = new Carta();
		Carta[] cartas = { asEspadas, dosEspadas, cartaVacia };
		for (Carta carta : cartas) {
			System.out.println(carta);
		}

	}

}
