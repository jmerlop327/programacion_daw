package unidad07.ampliacion;

import java.util.HashSet;
import java.util.Set;

public class Almacen {
	private Set<Producto> productos;

	/**
	 * @return the productos
	 */
	public Set<Producto> getProductos() {
		return productos;
	}

	/**
	 * @param productos the productos to set
	 */
	public void setProductos(Set<Producto> productos) {
		this.productos = productos;
	}

	public Almacen() {
		this.productos = new HashSet<Producto>();
	}
	
}
