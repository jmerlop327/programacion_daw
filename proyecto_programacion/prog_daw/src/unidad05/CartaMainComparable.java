package unidad05;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class CartaMainComparable {

	public static void main(String[] args) throws CloneNotSupportedException {
		Carta asEspadas = new Carta("Espadas", "1");
		Carta dosEspadas = new Carta("Espadas", "2");
		Carta carta1 = new Carta("Espadas", "3");
		Carta carta2 = new Carta("Bastos", "1");
		Carta carta4 = new Carta("Espadas", "11");
		Carta carta3 = new Carta("copas", "10");
		Carta carta5 = new Carta("oros", "7");
		Carta carta6 = new Carta("Espadas", "10");
		Carta carta6Clonada = (Carta) carta6.clone();

		// Carta cartaMayor = asEspadas.mayorCarta(cartaVacia);
		// System.out.println("la mayor carta de " + asEspadas + " y " + cartaVacia + "
		// es " + cartaMayor);
		Carta[] cartas = { asEspadas, dosEspadas, carta1, carta2, carta3, carta4, carta5, carta6, carta6Clonada };
		System.out.println("antes");
		mostrarCartas(cartas);
//		System.out.println("despues");
//		Arrays.sort(cartas);
//		mostrarCartas(cartas);

		// Creamos un objeto de tipo carta para llamar al método comparador
		Carta cartaCompare = new Carta();
		// Creamos un objeto Comparator con ::
		Comparator<Carta> comparatorPorNumero = cartaCompare::comparePorNumero;
		// Utilizamos el Comparator en el método sort
		Arrays.sort(cartas, comparatorPorNumero);
		System.out.println("despues NUM");
		mostrarCartas(cartas);
		Comparator<Carta> comparatorPorPalo = cartaCompare::comparePorPalo;
		Arrays.sort(cartas, comparatorPorPalo);
		System.out.println("despues PALO");
		mostrarCartas(cartas);
		

	}

	private static void mostrarCartas(Carta[] cartas) {
		for (Carta carta : cartas) {
			System.out.println(carta);
		}
	}

	public static void ordenarCartas(Carta[] cartas) {
		// Método de ordenación de la burbuja
		boolean intercambio = true;
		int elementosPorRecorrer = cartas.length - 1;
		while (intercambio) {
			intercambio = false;
			for (int i = 0; i < elementosPorRecorrer; i++) {
				// si la carta de la izq es menor que la de la derecha las tengo que cambiar
				Carta cartaIzq = cartas[i];
				Carta cartaDch = cartas[i + 1];
				Carta mayor = cartaIzq.mayorCartaComparable(cartaDch);
				if (mayor.equals(cartaIzq)) {
					// si están desordenados intercambiamos los elementos adyacentes
					Carta aux = cartaIzq;
					cartas[i] = cartaDch;
					cartas[i + 1] = aux;
					intercambio = true;
				}
			}
			elementosPorRecorrer--;
		}
	}

	public static void mezclarCartas(Carta[] cartas) {
		Random rand = new Random();
		for (int i = cartas.length - 1; i > 0; i--) {
			int aleatorio = rand.nextInt(i + 1);
			Carta aux = cartas[i];
			cartas[i] = cartas[aleatorio];
			cartas[aleatorio] = aux;
		}
	}

}
