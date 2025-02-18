package unidad05.equipo;

import java.time.LocalDate;

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
	 * @param nombre
	 * @param cif
	 * @param fechaFundacion
	 * @param masCienAbonados
	 * @param categoria
	 * @throws EquipoCategoriaNoValidaException 
	 * @throws EquipoCifNoValidoException 
	 */
	public Equipo(String nombre, String cif, LocalDate fechaFundacion, boolean masCienAbonados, char categoria) throws EquipoCategoriaNoValidaException, EquipoCifNoValidoException {
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
	 */
	public void setCif(String cif) {
		this.cif = cif;
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
	 */
	public void setCategoria(char categoria) {
		this.categoria = categoria;
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
		builder.append("Equipo [");
		if (nombre != null) {
			builder.append("nombre=");
			builder.append(nombre);
			builder.append(", ");
		}
		if (cif != null) {
			builder.append("cif=");
			builder.append(cif);
			builder.append(", ");
		}
		if (fechaFundacion != null) {
			builder.append("fechaFundacion=");
			builder.append(fechaFundacion);
			builder.append(", ");
		}
		builder.append("masCienAbonados=");
		builder.append(masCienAbonados);
		builder.append(", categoria=");
		builder.append(categoria);
		builder.append("]");
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
}
