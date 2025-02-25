package unidad05.empleado;

public abstract class Empleado implements Currante {
	//Atributos de clase (static)
	//Atributos
	private String nombre;
	private int tareasTerminadas;
	//Constructores
	public Empleado() {
		this.nombre = "";
		this.tareasTerminadas = 0;
	}
	public Empleado(String nombre) {
		this.nombre = nombre;
		this.tareasTerminadas = 0;
	}
	//getters y setters
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getTareasTerminadas() {
		return tareasTerminadas;
	}
	public void anadeTareaTerminada() {
		this.tareasTerminadas++;
	}
	public void setTareasTerminadas(int tareasTerminadas) {
		this.tareasTerminadas = tareasTerminadas;
	}
	//métodos de instancia
	//toString equals...
	public String toString() {
		return this.nombre + ". Tareas finalizadas: " + this.tareasTerminadas;
	}
	//métodos de clase (static) NombreClase.nombreMetodo(parametros)
}
