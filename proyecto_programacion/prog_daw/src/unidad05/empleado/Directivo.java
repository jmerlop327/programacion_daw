/**
 * 
 */
package unidad05.empleado;

/**
 * 
 */
public class Directivo extends Empleado {

	private int jerarquia;
	/**
	 * 
	 */
	public Directivo() {
		super();
	}

	/**
	 * @param nombre
	 */
	public Directivo(String nombre, int jerarquia) {
		super(nombre);
		this.jerarquia = jerarquia;
	}
	
	public int getJerarquia() {
		return jerarquia;
	}

	public void setJerarquia(int jerarquia) {
		this.jerarquia = jerarquia;
	}

	public String toString() {
		return "Directivo de nivel " + this.jerarquia + ": " + super.toString();
	}

	@Override
	public void realizaTarea() {
		this.anadeTareaTerminada();
	}

}
