package unidad05.empresa;

import unidad05.util.Utilidades;

public class Empresa {
	private static final String TEXTO_PATTERN = "\\w{2,}";
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
	 * @throws EmpresaNoValidaException 
	 */
	public Empresa(String nombre, String cif) throws EmpresaNoValidaException {
		if (null != nombre && !nombre.matches(TEXTO_PATTERN) && Utilidades.checkCif(cif)) {
			this.nombre = nombre;
			this.cif = cif;
			this.telefono = "";
			this.direccion = "";
			this.empleados = new Empleado[100];
		} else {
			throw new EmpresaNoValidaException("Datos inválidos para nombre y/o C.I.F.");
		}
	}

	/**
	 * @param nombre
	 * @param cif
	 * @param telefono
	 * @param direccion
	 * @throws EmpresaNoValidaException
	 */
	public Empresa(String nombre, String cif, String telefono, String direccion) throws EmpresaNoValidaException {
		this(nombre, cif);
		this.telefono = telefono;
		this.direccion = direccion;
		this.empleados = new Empleado[100];
	}

	// Getters y setters
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
	 * @return the empleados
	 */
	public Empleado[] getEmpleados() {
		return empleados;
	}

	/**
	 * @param empleados the empleados to set
	 */
	public void setEmpleados(Empleado[] empleados) {
		this.empleados = empleados;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @return the cif
	 */
	public String getCif() {
		return cif;
	}

	// Métodos de instancia
	/**
	 * Introduce el empleado en la empresa si hay capacidad para contratar
	 * 
	 * @param empleado
	 * @throws EmpresaCompletaException
	 * @throws EmpresaEmpleadoExistenteException
	 */
	public void anadirEmpleado(Empleado empleado) throws EmpresaCompletaException, EmpresaEmpleadoExistenteException {
		boolean existeEmpleado = false;
		int indice = 0;
		int indiceVacio = -1;

		while (indice < this.empleados.length && !existeEmpleado) {
			Empleado empleadoAct = this.empleados[indice];
			if (indiceVacio < 0 && null == empleadoAct) {
				indiceVacio = indice;
			}
			if (null != empleadoAct && empleadoAct.equals(empleado)) {
				existeEmpleado = true;
			}
			indice++;
		}
		if (indiceVacio < 0) {
			throw new EmpresaCompletaException("La capacidad de empleados de la empresa está completa");
		}
		if (existeEmpleado) {
			String mensaje = "El empleado con dni " + empleado.getDni() + " ya existe en la empresa";
			throw new EmpresaEmpleadoExistenteException(mensaje);
		} else {
			this.empleados[indiceVacio] = empleado;
		}
	}

	/**
	 * Elimina de la empresa el empleado que coincide con el pasado por parámetro
	 * 
	 * @param empleado
	 * @throws EmpresaEmpleadoNoExisteException
	 */
	public void eliminarEmpleado(Empleado empleado) throws EmpresaEmpleadoNoExisteException {
		boolean eliminado = false;
		int i = 0;
		while (!eliminado && i < this.empleados.length) {
			Empleado empActual = this.empleados[i];
			if (null != empActual && null != empleado && empActual.equals(empleado)) {
				this.empleados[i] = null;
				eliminado = true;
			}
		}
		if (!eliminado) {
			throw new EmpresaEmpleadoNoExisteException(
					"El empleado que se desea eliminar no forma parte de la empresa");
		}
	}

	public void mostrarInfoEmpleados() {
		int i = 1;
		System.out.println("Información de los empleados de la empresa " + this.nombre);
		for (Empleado empleado : this.empleados) {
			if (null != empleado) {
				System.out.println("" + i++ + ". " + empleado);
			}
		}
	}

	/**
	 * Muestra por pantalla tanto el DNI como los sueldos bruto y neto de los
	 * empleados de la empresa
	 */
	public void mostrarDniSueldoEmpleados() {
		StringBuilder sb = new StringBuilder();
		for (Empleado empleado : this.empleados) {
			if (null != empleado) {
				sb.append("D.N.I. ").append(empleado.getDni());
				sb.append(" Sueldo bruto: ").append(empleado.getSueldoBruto());
				sb.append(" Sueldo neto: ").append(empleado.getSueldoNeto());
			}
		}
		System.out.println(sb);
	}

	/**
	 * Devuelve la suma de todos los sueldos brutos de los empleados
	 * 
	 * @return sumaBrutos
	 */
	public double sumaSueldoBrutoEmpleados() {
		double sumaBrutos = 0d;
		for (Empleado empleado : this.empleados) {
			if (null != empleado) {
				sumaBrutos += empleado.getSueldoBruto();
			}
		}
		return sumaBrutos;
	}

	/**
	 * Devuelve la suma de todos los sueldos neto de los empleados
	 * 
	 * @return sumaNetos
	 */
	public double sumaSueldoNetoEmpleados() {
		double sumaNetos = 0d;
		for (Empleado empleado : this.empleados) {
			if (null != empleado) {
				sumaNetos += empleado.getSueldoNeto();
			}
		}
		return sumaNetos;
	}

}
