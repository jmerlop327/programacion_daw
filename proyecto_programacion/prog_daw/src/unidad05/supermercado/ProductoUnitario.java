package unidad05.supermercado;

public class ProductoUnitario extends Producto implements IPrecio {
	private int cantidad;
	private double precio;

	public ProductoUnitario(String nombre, String categoria, int cantidad, double precio) {
		super(nombre, categoria);
		this.cantidad = cantidad;
		this.precio = precio;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public double getImporteTotal() {
		return cantidad * precio;
	}

	@Override
	public void imprimir() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.nombre).append(" (");
		sb.append(this.cantidad).append(" un.) ");
		sb.append(this.precio).append("\t\t\t\t");
		double importeTotal = this.getImporteTotal();
		System.out.printf(sb + "%.2f\n", importeTotal);		
	}

}
