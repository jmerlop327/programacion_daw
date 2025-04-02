package unidad06.coleccion;

import java.util.Scanner;

public class TestLista {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Coleccion coleccion = new Coleccion();

		//// INICIALIZACIÓN DE LA LISTA DE PRODUCTOS POR TECLADO///
		boolean seguir = true;
		System.out.println("Introduce los productos de la colección.");
		System.out.println("Formato: codigo nombreProd tipoProd precio(00.0) existencias");
		System.out.println("Introducir 0 para terminar");
		while (seguir) {
			int codigo = Integer.parseInt(scan.next());
			if (codigo != 0) {
				String nombre = scan.next();
				String tipo = scan.next();
				double precio = Double.parseDouble(scan.next());
				int existencias = Integer.parseInt(scan.next());
				;
				Producto prod = new Producto(codigo, nombre, tipo, precio, existencias);
				coleccion.aniadir(prod);
			} else {
				seguir = false;
			}
		}
		//// FIN INICIALIZACIÓN DE LA LISTA DE PRODUCTOS POR TECLADO///
		System.out.println("Mostrando la lista de productos");
		coleccion.mostrarTodo();
		coleccion.aumentoPrecio(20d);
		System.out.println("Mostrando la lista de productos");
		coleccion.mostrarTodo();
	}

}
