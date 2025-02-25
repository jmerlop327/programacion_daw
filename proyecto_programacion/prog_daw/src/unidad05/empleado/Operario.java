/**
 * 
 */
package unidad05.empleado;

/**
 * 
 */
public abstract class Operario extends Empleado {

	private String tipoMaquinaria;
	/**
	 * 
	 */
	public Operario() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param nombre
	 */
	public Operario(String nombre, String tipoMaquinaria) {
		super(nombre);
		this.tipoMaquinaria = tipoMaquinaria;
	}

	public String getTipoMaquinaria() {
		return tipoMaquinaria;
	}

	public void setTipoMaquinaria(String tipoMaquinaria) {
		this.tipoMaquinaria = tipoMaquinaria;
	}
	
	public String toString() {
		return "Maneja " + this.tipoMaquinaria + ": " + super.toString(); 
	}

}
