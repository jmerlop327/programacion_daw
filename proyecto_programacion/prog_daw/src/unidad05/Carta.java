package unidad05;

import java.util.Objects;

public class Carta {
	private static final String[] ORDEN_PALOS = { "OROS", "COPAS", "ESPADAS", "BASTOS" };
	private static final String[] ORDEN_NUMEROS = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };
	
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
	 * Devuelve la carta mayor entre la carta pasada por parámetro y la actual
	 * orden establecido:
	 * oros > copas > espadas > bastos
	 * A > 2 > 3 > 4 > 5 > ... 10 > J > Q > K
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

	
}
