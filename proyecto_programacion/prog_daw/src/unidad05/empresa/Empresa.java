package unidad05.empresa;

public class Empresa {
	// Atributos
	private String nombre;
	private String cif;
	private String telefono;
	private String direccion;
	private Empleado[] empleados;

	// Constructores
	/**
	 * @param nombre
	 * @param cIF
	 */
	public Empresa(String nombre, String cif) {
		this.nombre = nombre;
		this.cif = cif;
		this.telefono = "";
		this.direccion = "";
		this.empleados = new Empleado[100];
	}

	/**
	 * @param nombre
	 * @param cif
	 * @param telefono
	 * @param direccion
	 */
	public Empresa(String nombre, String cif, String telefono, String direccion) {
		this(nombre, cif);
		this.telefono = telefono;
		this.direccion = direccion;
		this.empleados = new Empleado[100];
	}

}
