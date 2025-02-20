package unidad05.equipo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import unidad05.util.Utilidades;

public class Equipo {
	private static int numeroEquipos = 0;
	private String nombre;
	private String cif;
	// private String direccion;
	// private String telefono;
	// private String nombrePresidente;
	// private String observaciones;
	private LocalDate fechaFundacion;
	private boolean masCienAbonados;
	private char categoria;

	/**
	 * Constructor por defecto
	 */
	public Equipo() {
		this.nombre = "";
		this.cif = "";
		this.fechaFundacion = null;
		this.masCienAbonados = false;
		this.categoria = '0';
	}

	/**
	 * @param nombre
	 * @param cif
	 * @param fechaFundacion
	 * @param masCienAbonados
	 * @param categoria
	 * @throws EquipoCategoriaNoValidaException
	 * @throws EquipoCifNoValidoException
	 */
	public Equipo(String nombre, String cif, LocalDate fechaFundacion, boolean masCienAbonados, char categoria)
			throws EquipoCategoriaNoValidaException, EquipoCifNoValidoException {
		this.nombre = nombre;
		if (Utilidades.checkCif(cif)) {
			this.cif = cif;
		} else {
			throw new EquipoCifNoValidoException("El cif no es correcto");
		}
		this.fechaFundacion = fechaFundacion;
		this.masCienAbonados = masCienAbonados;
		this.categoria = this.checkCategoria(categoria);
		numeroEquipos++;
	}

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

	/**
	 * @return the cif
	 */
	public String getCif() {
		return cif;
	}

	/**
	 * @param cif the cif to set
	 * @throws EquipoCifNoValidoException 
	 */
	public void setCif(String cif) throws EquipoCifNoValidoException {
		if (Utilidades.checkCif(cif)) {
			this.cif = cif;
		} else {
			throw new EquipoCifNoValidoException("El cif no es correcto");
		}
	}

	/**
	 * @return the fechaFundacion
	 */
	public LocalDate getFechaFundacion() {
		return fechaFundacion;
	}

	/**
	 * @param fechaFundacion the fechaFundacion to set
	 */
	public void setFechaFundacion(LocalDate fechaFundacion) {
		this.fechaFundacion = fechaFundacion;
	}

	/**
	 * @return the masCienAbonados
	 */
	public boolean isMasCienAbonados() {
		return masCienAbonados;
	}

	/**
	 * @param masCienAbonados the masCienAbonados to set
	 */
	public void setMasCienAbonados(boolean masCienAbonados) {
		this.masCienAbonados = masCienAbonados;
	}

	/**
	 * @return the categoria
	 */
	public char getCategoria() {
		return categoria;
	}

	/**
	 * @param categoria the categoria to set
	 * @throws EquipoCategoriaNoValidaException 
	 */
	public void setCategoria(char categoria) throws EquipoCategoriaNoValidaException {
		this.categoria = this.checkCategoria(categoria);
	}

	/**
	 * @return the numeroEquipos
	 */
	public static int getNumeroEquipos() {
		return numeroEquipos;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Equipo: ");
		if (nombre != null) {
			builder.append(nombre);
		}
		if (cif != null) {
			builder.append(", con identificación fiscal ");
			builder.append(cif);
			builder.append(". ");
		}
		if (fechaFundacion != null) {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy");
			String anioFund = fechaFundacion.format(dtf);
			builder.append("Fundado en " + anioFund);
			builder.append(". ");
		}
		switch (this.categoria) {
		case 'I':
			builder.append("Juega en la categoría infantil y ");
			break;
		case 'J':
			builder.append("Juega en la categoría juvenil y ");
			break;
		case 'A':
			builder.append("Juega en la categoría adulto y ");
			break;
		default:
			builder.append("No tiene categoría asignada y ");
			break;
		}
		if (this.masCienAbonados) {
			builder.append("tiene más de cien abonados.");
		} else {
			builder.append("tiene menos de cien abonados.");
		}
		return builder.toString();
	}

	private char checkCategoria(char categoria) throws EquipoCategoriaNoValidaException {
		char cat = categoria;
		if (categoria == 'i' || categoria == 'j' || categoria == 'a') {
			cat = Character.toUpperCase(categoria);
		} else if (categoria != 'I' && categoria != 'J' && categoria != 'A') {
			throw new EquipoCategoriaNoValidaException("Categoría no válida");
		}
		return cat;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + categoria;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	public boolean equals(Equipo otroEquipo) {
		boolean equals = false;
		if (null != this.nombre && this.nombre.equals(otroEquipo.nombre) && this.categoria == otroEquipo.categoria) {
			equals = true;
		}
		return equals;
	}

}
