package unidad05;

import java.util.Comparator;
import java.util.Objects;

public class Carta implements Comparable<Carta>, Comparator<Carta>, Cloneable {
	private static final String[] ORDEN_PALOS = { "BASTOS", "ESPADAS", "COPAS", "OROS" };
	private static final String[] ORDEN_NUMEROS = { "1", "2", "3", "4", "5", "6", "7", "10", "11", "12" };

	// Atributos
	private String palo;
	private String numero;

	// Constructores
	public Carta(String palo, String numero) {
		this.palo = palo;
		this.numero = numero;
	}

	public Carta() {
		this.palo = "oros";
		this.numero = "2";
	}
	// getters y setters

	/**
	 * @return the palo
	 */
	public String getPalo() {
		return this.palo;
	}

	/**
	 * @return the numero
	 */
	public String getNumero() {
		return this.numero;
	}

	// métodos
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(this.numero).append(" ").append(this.palo);
		return builder.toString();
	}

	@Override
	public int hashCode() {
		return Objects.hash(numero, palo);
	}

	public boolean equals(Carta carta) {
		boolean igualPalo = this.palo.equalsIgnoreCase(carta.getPalo());
		boolean igualNumero = this.numero.equalsIgnoreCase(carta.getNumero());
		return igualPalo && igualNumero;
	}

	/**
	 * Devuelve la carta mayor entre la carta pasada por parámetro y la actual orden
	 * establecido: oros > copas > espadas > bastos A > 2 > 3 > 4 > 5 > ... 10 > J >
	 * Q > K
	 * 
	 * @param carta
	 * @return cartaMayor
	 */
	public Carta mayorCarta(Carta carta) {
		Carta mayorCarta = this;
		if (this.palo.equalsIgnoreCase(carta.getPalo())) {
			int indiceThis = calculaIndice(ORDEN_NUMEROS, this.numero);
			int indiceOtra = calculaIndice(ORDEN_NUMEROS, carta.getNumero());
			mayorCarta = indiceThis < indiceOtra ? carta : this;
		} else {
			int indiceThis = calculaIndice(ORDEN_PALOS, this.palo.toUpperCase());
			int indiceOtra = calculaIndice(ORDEN_PALOS, carta.getPalo().toUpperCase());
			mayorCarta = indiceThis < indiceOtra ? this : carta;
		}
		return mayorCarta;
	}

	/**
	 * Devuelve la carta mayor entre la carta pasada por parámetro y la actual orden
	 * establecido: oros > copas > espadas > bastos A > 2 > 3 > 4 > 5 > ... 10 > J >
	 * Q > K
	 * 
	 * @param carta
	 * @return cartaMayor
	 */
	public Carta mayorCartaComparable(Carta carta) {
		Carta mayorCarta = this;
		// utilizar el compareTo
		if (mayorCarta.compareTo(carta) < 0) {
			mayorCarta = carta;
		}
		return mayorCarta;
	}

	private int calculaIndice(String[] orden, String dato) {
		boolean encontrado = false;
		int indice = 0;
		int indiceRecorrido = 0;
		while (!encontrado && indiceRecorrido < orden.length) {
			if (orden[indiceRecorrido].equalsIgnoreCase(dato)) {
				indice = indiceRecorrido;
				encontrado = true;
			}
			indiceRecorrido++;
		}
		return indice;
	}

	@Override
	public int compareTo(Carta o) {
		int compare = 0;
		if (this.palo.equalsIgnoreCase(o.palo)) {
			compare = Integer.parseInt(this.numero) - Integer.parseInt(o.numero);
		} else if (this.palo.equalsIgnoreCase("BASTOS")) {
			compare = 1;
		} else if (this.palo.equalsIgnoreCase("ESPADAS") && !o.palo.equalsIgnoreCase("BASTOS")) {
			compare = 1;
		} else if (this.palo.equalsIgnoreCase("COPAS") && !o.palo.equalsIgnoreCase("BASTOS")
				&& !o.palo.equalsIgnoreCase("ESPADAS")) {
			compare = 1;
		} else {
			compare = -1;
		}
		return compare;
	}

	@Override
	public int compare(Carta o1, Carta o2) {
		// TODO Auto-generated method stub
		return o1.compareTo(o2);
	}

	public int comparePorNumero(Carta o1, Carta o2) {
		Integer numero1 = Integer.parseInt(o1.getNumero());
		Integer numero2 = Integer.parseInt(o2.getNumero());
		return numero1 - numero2;
	}

	public int comparePorPalo(Carta o1, Carta o2) {
		int paloO1 = o1.getPaloLevel();
		int paloO2 = o2.getPaloLevel();
		return paloO1 - paloO2;
	}

	private int getPaloLevel() {
		int level = 0;
		switch (this.palo.toUpperCase()) {
		case "OROS":
			level = 1;
			break;
		case "ESPADAS":
			level = 3;
			break;
		case "COPAS":
			level = 2;
			break;
		case "BASTOS":
			level = 4;
			break;
		default:
			break;
		}
		return level;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

}
