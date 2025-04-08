package unidad06;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class SupermercadoEcologico {

	public static void main(String[] args) {
		Map<String, Double> productos = new LinkedHashMap<String, Double>();
		productos.put("avena", 2.21d);
		productos.put("garbanzos", 2.39d);
		productos.put("tomate", 1.59d);
		productos.put("jengibre", 3.13d);
		productos.put("quinoa", 4.5d);
		productos.put("guisantes", 1.6d);
		mostrarProductos(productos);
		Map<String, Integer> productosComprados = efectuaCompra(productos);
		mostrarFactura(productos, productosComprados);
	}

	private static void mostrarFactura(Map<String, Double> productos, Map<String, Integer> productosComprados) {
		Double total = 0d;
		System.out.print("""
				FACTURA
				Producto Precio Cantidad Subtotal
				---------------------------------
								""");
		Set<String> nombresProducto = productosComprados.keySet();
		for (String nombreProducto : nombresProducto) {
			Double precio = productos.get(nombreProducto);
			Integer cantidad = productosComprados.get(nombreProducto);
			Double subtotal = precio * cantidad;
			total += subtotal;
			String subtotalStr = String.format("%.2f", subtotal);
			System.out.println(nombreProducto + " " + precio + " " + cantidad + " " + subtotalStr);
		}
		System.out.println("---------------------------------");
		System.out.printf("Total: %.2f", total);

	}

	private static Map<String, Integer> efectuaCompra(Map<String, Double> productos) {
		Scanner scanner = new Scanner(System.in);
		Map<String, Integer> productosComprados = new LinkedHashMap<String, Integer>();
		// bucle compras
		boolean fin = false;
		do {
			System.out.println("Producto (FIN para terminar):");
			String producto = scanner.nextLine();
			if (!"FIN".equalsIgnoreCase(producto)) {
				if (productos.containsKey(producto)) {
					System.out.println("Cantidad:");
					Integer cantidad = Integer.parseInt(scanner.nextLine());
					// Tengo la info de producto y cantidad
					// Devuelve el valor asociado y si no está, devuelve 0
					// productosComprados.getOrDefault(producto, 0);
					int cantidadAct = 0;
					if (productosComprados.containsKey(producto)) {
						cantidadAct = productosComprados.get(producto);
					}
					productosComprados.put(producto, cantidadAct + cantidad);
				} else {
					System.err.println("El producto " + producto + " no está disponible en el supermercado");
				}

			} else {
				fin = true;
			}

		} while (!fin);
		return productosComprados;
	}

	private static void mostrarProductos(Map<String, Double> productos) {
		for (String nombreProd : productos.keySet()) {
			Double precioProd = productos.get(nombreProd);
			System.out.println(nombreProd + " --> " + precioProd + " €");
		}

	}

}
