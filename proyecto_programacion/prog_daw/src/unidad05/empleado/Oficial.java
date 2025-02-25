package unidad05.empleado;

public class Oficial extends Operario {

	private String licencia;
	public Oficial() {
		super();
	}
	public Oficial(String nombre, String tipoMaquinaria, String licencia) {
		super(nombre, tipoMaquinaria);
		this.setLicencia(licencia);
	}
	public String getLicencia() {
		return licencia;
	}
	public void setLicencia(String licencia) {
		this.licencia = licencia;
	}
	public String toString() {
		return "Oficial con licencia de " + this.licencia +". " + super.toString();
	}
	@Override
	public void realizaTarea() {
		this.anadeTareaTerminada();
	}
}
