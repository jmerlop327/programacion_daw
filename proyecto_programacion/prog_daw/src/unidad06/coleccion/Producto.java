package unidad06.coleccion;

public class Producto {
	private int codigo;
	private String nombre;
	private String tipo;
	private double precio;
	private int existencias;
	
	@Override
	public String toString() {
		String precioStr = String.format("%.2f", this.precio) + " €";
		String stock = this.existencias > 0 ? "": " >>Sin stock<<";
		return "" + this.codigo + " - " + this.nombre + ". Sección " + tipo + ". PVP -> " + precioStr + stock;
	}

	public Producto(int codigo, String nombre, String tipo, double precio, int existencias) {
		this.codigo=codigo;
		this.nombre=nombre;
		this.tipo=tipo;
		this.precio=precio;
		this.existencias=existencias;
	}

	/**
	 * @return the codigo
	 */
	public int getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(int codigo) {
		this.codigo = codigo;
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
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/**
	 * @return the precio
	 */
	public double getPrecio() {
		return precio;
	}

	/**
	 * @param precio the precio to set
	 */
	public void setPrecio(double precio) {
		this.precio = precio;
	}

	/**
	 * @return the existencias
	 */
	public int getExistencias() {
		return existencias;
	}

	/**
	 * @param existencias the existencias to set
	 */
	public void setExistencias(int existencias) {
		this.existencias = existencias;
	}

}
