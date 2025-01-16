package unidad05;

import java.util.Objects;

public class Carta {
	//Atributos
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
	 * Devuelve true si la carta pasada por parámetro es mayor que la actual
	 * orden establecido:
	 * oros > copas > espadas > bastos
	 * A > K > Q > J > 10 > ... > 2
	 * @param carta
	 * @return
	 */
	public boolean mayorCarta (Carta carta) {
		boolean mayorPalo = true;
		final String[] ORDEN_NUMEROS = {"A", "K", "Q", "J", "10", "9", "8", ""};
		if (this.palo.equalsIgnoreCase(carta.getPalo())) {
			
		}
	}
	
	
}
