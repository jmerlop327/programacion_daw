package unidad05;

import java.util.Random;
import java.util.Scanner;

public class CartaMain {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Carta asEspadas = new Carta("Espadas", "A");
		System.out.println(asEspadas.getPalo());
		Carta dosEspadas = new Carta("Espadas", "2");
		Carta carta1 = new Carta("Espadas", "3");
		Carta carta2 = new Carta("Bastos", "A");
		Carta carta3 = new Carta("copas", "J");
		Carta carta4 = new Carta("Espadas", "Q");
		Carta carta5 = new Carta("oros", "7");
		Carta carta6 = new Carta("Espadas", "10");
		asEspadas.equals(dosEspadas);
		dosEspadas.equals(asEspadas);
		Carta cartaVacia = new Carta();
		//Carta cartaMayor = asEspadas.mayorCarta(cartaVacia);
		//System.out.println("la mayor carta de " + asEspadas + " y " + cartaVacia + " es " + cartaMayor);
		Carta[] cartas1 = { asEspadas, dosEspadas, cartaVacia };
		Carta[] cartas = { asEspadas, dosEspadas, cartaVacia, carta1, carta2, carta3, carta4, carta5, carta6 };
		System.out.println("antes");
		mostrarCartas(cartas);
		mezclarCartas(cartas);
		int i = 1;
		mezclarCartas(cartas);
		System.out.println("después" + i++);
		mostrarCartas(cartas);
		mezclarCartas(cartas);
		System.out.println("después" + i++);
		mostrarCartas(cartas);
		mezclarCartas(cartas);
		System.out.println("después" + i++);
		mostrarCartas(cartas);
		System.out.println("mostrando baraja completa");
		//Crear una baraja
		Baraja baraja = new Baraja();
		Carta[] cartas2 = baraja.getCartas();
		mezclarCartas(cartas2);
		mostrarCartas(baraja.getCartas());
		System.out.println("mostrando ORDEN");
		ordenarCartas(cartas2);
		mostrarCartas(baraja.getCartas());
	}

	private static void mostrarCartas(Carta[] cartas) {
		for (Carta carta : cartas) {
			System.out.println(carta);
		}
	}
	

	public static void ordenarCartas (Carta[] cartas) {
		// Método de ordenación de la burbuja
				boolean intercambio = true;
				int elementosPorRecorrer = cartas.length-1;
				while (intercambio) {
					intercambio = false;
					for (int i = 0;i<elementosPorRecorrer;i++) {
						// si la carta de la izq es menor que la de la derecha las tengo que cambiar
						Carta cartaIzq = cartas[i]; 
						Carta cartaDch = cartas[i+1];
						Carta mayor = cartaIzq.mayorCarta(cartaDch);
						if (mayor.equals(cartaIzq)) {
							// si están desordenados intercambiamos los elementos adyacentes
							Carta aux = cartaIzq;
							cartas[i] = cartaDch;
							cartas[i+1] = aux;
							intercambio = true;
						}
					}
					elementosPorRecorrer--;
				}
	}
	
	public static void mezclarCartas(Carta[] cartas) {
		Random rand = new Random();
		for (int i = cartas.length - 1; i > 0; i--) {
			int aleatorio = rand.nextInt(i+1);
			Carta aux = cartas[i];
			cartas[i] = cartas[aleatorio];
			cartas[aleatorio] = aux;
		}
	}

}
