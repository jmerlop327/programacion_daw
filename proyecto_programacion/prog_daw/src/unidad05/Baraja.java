package unidad05;

public class Baraja {
	private static final String[] ORDEN_PALOS = { "OROS", "COPAS", "ESPADAS", "BASTOS" };
	private static final String[] ORDEN_NUMEROS = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };
	
	private Carta[] cartas;
	private String tipo;
	
	public Baraja(Carta[] cartas) {
		this.cartas = cartas;
		this.tipo = "";
	}
	
	public Baraja() {
		this.cartas = crearBaraja();
		this.tipo = "";
	}
	public Baraja(String tipo) {
		//this.cartas = crearBaraja(tipo);
		this.tipo = "tipo";
	}
	
	/**
	 * @return the cartas
	 */
	public Carta[] getCartas() {
		return cartas;
	}

	/**
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}

	public Carta[] crearBaraja() {
		final int NUM_CARTAS = ORDEN_PALOS.length * ORDEN_NUMEROS.length;
		Carta[] baraja = new Carta[NUM_CARTAS];
		int indiceBaraja = 0;
		for (int i = 0; i < ORDEN_PALOS.length; i++) {
			for (int j = 0; j < ORDEN_NUMEROS.length; j++) {
				Carta c = new Carta(ORDEN_PALOS[i], ORDEN_NUMEROS[j]);
				baraja[indiceBaraja++] = c;
			}
		}
		return baraja;
	}
}
