package unidad05.empresa;

import unidad05.util.Utilidades;

public class Empleado {
	private static final String TEXTO_PATTERN = "\\w{2,}";
	// Atributos
	private String nombre;
	private String apellidos;
	private String dni;
	private float sueldoBruto;
	private int edad;
	private String telefono;
	private String direccion;

	// Constructores
	/**
	 * @param nombre
	 * @param apellidos
	 * @param dni
	 * @param sueldoBruto
	 * @throws EmpleadoException
	 */
	public Empleado(String nombre, String apellidos, String dni, float sueldoBruto) throws EmpleadoInvalidoException {
		if (null != nombre && nombre.matches(TEXTO_PATTERN) && null != apellidos && nombre.matches(TEXTO_PATTERN)
				&& null != dni && Utilidades.checkDni(dni)) {
			this.nombre = nombre;
			this.apellidos = apellidos;
			this.dni = dni;
			this.sueldoBruto = sueldoBruto;
			this.edad = 0;
			this.telefono = "";
			this.direccion = "";
		} else {
			throw new EmpleadoInvalidoException("Datos inválidos para nombre, apellidos y/o D.N.I.");
		}
	}

	/**
	 * @param nombre
	 * @param apellidos
	 * @param dni
	 * @param sueldoBruto
	 * @param edad
	 * @param telefono
	 * @param direccion
	 * @throws EmpleadoException
	 */
	public Empleado(String nombre, String apellidos, String dni, float sueldoBruto, int edad, String telefono,
			String direccion) throws EmpleadoInvalidoException {
		this(nombre, apellidos, dni, sueldoBruto);
		this.edad = edad;
		this.telefono = telefono;
		this.direccion = direccion;
	}
	// getters y setters

	/**
	 * @return the sueldoBruto
	 */
	public float getSueldoBruto() {
		return sueldoBruto;
	}

	/**
	 * @param sueldoBruto the sueldoBruto to set
	 */
	public void setSueldoBruto(float sueldoBruto) {
		this.sueldoBruto = sueldoBruto;
	}

	/**
	 * @return the edad
	 */
	public int getEdad() {
		return edad;
	}

	/**
	 * @param edad the edad to set
	 */
	public void setEdad(int edad) {
		this.edad = edad;
	}

	/**
	 * @return the telefono
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * @param telefono the telefono to set
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	/**
	 * @return the direccion
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * @param direccion the direccion to set
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @return the apellidos
	 */
	public String getApellidos() {
		return apellidos;
	}

	/**
	 * @return the dni
	 */
	public String getDni() {
		return dni;
	}
	// Métodos de instancia

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Empleado:\n");
		builder.append(nombre);
		builder.append(" ");
		builder.append(apellidos);
		builder.append(". D.N.I.: ");
		builder.append(dni);
		builder.append("\n");
//		builder.append("Sueldo=");
//		builder.append(sueldoBruto);
//		builder.append(", edad=");
//		builder.append(edad);
//		builder.append(", ");
//		if (telefono != null ) {
//			builder.append("telefono=");
//			builder.append(telefono);
//			builder.append(", ");
//		}
//		if (direccion != null) {
//			builder.append("direccion=");
//			builder.append(direccion);
//		}
//		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
		return result;
	}

	public boolean equals(Empleado otroEmpleado) {
		if (this == otroEmpleado)
			return true;
		if (!(otroEmpleado instanceof Empleado))
			return false;
		Empleado other = (Empleado) otroEmpleado;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		return true;
	}

}
