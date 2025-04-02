package unidad06.coleccion;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Coleccion {
	private List<Producto> lista;
	
	public Coleccion() {
		// Inicializa la lista de Productos a vacía
		this.lista = new ArrayList<Producto>();
    }

	public int tamanio() {
		// Devuelve el tamaño de la lista
		return this.lista.size();
	}

	public void aniadir(Producto e) {
		// Añade un elemento tipo Producto en la lista
		this.lista.add(e);
	}

	public void eliminar(int pos) {
		// Borra un elemento indicando la posición
		this.lista.remove(pos);
	}

	public Producto obtener(int pos) {
		// Devuelve el elemento de una posición
		return this.lista.get(pos);
	}

	public Producto buscar(int cod) {
		// Recorre la lista y busca si el código del producto
		// si coincide con cod devuelve el producto
		// y si no está el la lista devuelve null
		Iterator<Producto> itProd = this.lista.iterator();
		boolean encontrado = false;
		Producto prod = null;
		while (itProd.hasNext() && !encontrado) {
			prod = itProd.next();
			if (null != prod && cod == prod.getCodigo()) {
				encontrado = true;
			}
		}
		return prod;
	}
	 public void mostrarTodo() {
		 // Muestra todos los elementos de la lista en pantalla
		 for (Producto p : this.lista) {
             System.out.println(p);
         }
	 }
	public void aumentoPrecio(double porcentaje) {
		double cambio = porcentaje/100;
		for (Producto p : this.lista) {
			double precioActual = p.getPrecio();
			double nuevoPrecio = precioActual * (1 + cambio);
            p.setPrecio(nuevoPrecio);
        }
	}
}
