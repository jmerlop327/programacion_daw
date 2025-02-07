package unidad05.animales;

import java.util.Date;

public abstract class Animal {
	private Date fechaNacimiento;
	private String lugarNacimiento;
	private String ubicacion;
	private Integer numPatas;

	/**
	 * @return the fechaNacimiento
	 */
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	/**
	 * @param fechaNacimiento the fechaNacimiento to set
	 */
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	/**
	 * @return the lugarNacimiento
	 */
	public String getLugarNacimiento() {
		return lugarNacimiento;
	}

	/**
	 * @param lugarNacimiento the lugarNacimiento to set
	 */
	public void setLugarNacimiento(String lugarNacimiento) {
		this.lugarNacimiento = lugarNacimiento;
	}

	/**
	 * @return the ubicacion
	 */
	public String getUbicacion() {
		return ubicacion;
	}

	/**
	 * @param ubicacion the ubicacion to set
	 */
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	/**
	 * @return the numPatas
	 */
	public Integer getNumPatas() {
		return numPatas;
	}

	/**
	 * @param numPatas the numPatas to set
	 */
	public void setNumPatas(Integer numPatas) {
		this.numPatas = numPatas;
	}
	
	public Animal(String lugarNacimiento, Integer numPatas) {
		this.fechaNacimiento = new Date();
		this.lugarNacimiento = lugarNacimiento;
		this.ubicacion = lugarNacimiento;
		this.numPatas = numPatas;
	}

	public void migrar(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Nació en ").append(this.lugarNacimiento).append(" el ").append(this.fechaNacimiento)
				.append(" y tiene ").append(this.numPatas).append(" patas");
		return sb.toString();
	}
	

}
