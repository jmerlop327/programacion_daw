package unidad06.vehiculos.base;

public class Vehiculo implements Comparable<Vehiculo> {

	private String marca;
	private String matricula;
	private int numKM;
	private int anioMatriculacion;
	private String descripcion;
	private float precio;
	private String dniPropietario;

	public Vehiculo(String marca, String matricula, int numKM, int anioMatriculacion, String descripcion, float precio,
			String dniPropietario) {
		this.marca = marca;
		this.matricula = matricula;
		this.numKM = numKM;
		this.anioMatriculacion = anioMatriculacion;
		this.descripcion = descripcion;
		this.precio = precio;
		this.dniPropietario = dniPropietario;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public int getNumKM() {
		return numKM;
	}

	public void setNumKM(int numKM) {
		this.numKM = numKM;
	}

	public int getAnioMatriculacion() {
		return anioMatriculacion;
	}

	public void setAnioMatriculacion(int anioMatriculacion) {
		this.anioMatriculacion = anioMatriculacion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public String getDniPropietario() {
		return dniPropietario;
	}

	public void setDniPropietario(String dniPropietario) {
		this.dniPropietario = dniPropietario;
	}

	@Override
	public String toString() {
		return "Vehiculo{" + "marca=" + marca + ", matricula=" + matricula + ", numKM=" + numKM + ", descripcion="
				+ descripcion + ", precio=" + precio;
	}

	public boolean equals(Vehiculo other) {
		return this.matricula.equals(other.matricula);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Vehiculo)) {
			return false;
		}
		Vehiculo other = (Vehiculo) obj;
		if (matricula == null) {
			if (other.matricula != null) {
				return false;
			}
		} else if (!matricula.equals(other.matricula)) {
			return false;
		}
		return true;
	}

	@Override
	public int compareTo(Vehiculo o) {
		int result = 0;
		result = this.matricula.substring(4).compareTo(o.matricula.substring(4));
		if (result == 0) {
			result = this.matricula.substring(0, 4).compareTo(o.matricula.substring(0, 4));
		}
		return result;
	}

}
