package unidad07.practica;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SuperEcoMercado {
	static Map<String, Float> productos = new HashMap<String, Float>();
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		boolean salir = false;
		while (!salir) {
			System.out.print("INPUT:");
			String input = scanner.nextLine();
			if ("EXIT".equalsIgnoreCase(input)) {
				salir = true;
				// Escribir el fichero de salida
				guardarDatosSupermercado();
			} else if (null != input && input.startsWith("UPDATE")) {
				// Leer el fichero de entrada y actualizar los prod
				String ruta = input.split(" ")[1];
				actualizarProductos("ficheros/supermercado/" + ruta);
				System.out.print("\n");
			} else {
				// Estamos en una compra. Podemos recibir un num o un prod
				realizarCompra(input);
			}
		}
	}

	private static void realizarCompra(String input) {
		Map<String, Integer> cesta = new HashMap<String, Integer>();
		while (!"0".equals(input)) {
			Integer num = esNumero(input);
			String prod = input;
			if (null != num) {
				// input es un número
				System.out.print("\nINPUT:");
				prod = scanner.nextLine();
			} else {
				// input es un producto
				num = 1;
			}
			// obtenemos el valor para el producto actual
			Integer cantidadPrevia = cesta.get(prod);
			if (null != cantidadPrevia) {
				// si no es nulo es que ese prod existe en la cesta
				cesta.put(prod, num + cantidadPrevia);
			} else {
				// si es nulo, se introduce por primera vez
				cesta.put(prod, num);
			}
			System.out.print("\nINPUT:");
			input = scanner.nextLine();
		}
		imprimirFactura(cesta);
	}

	private static void imprimirFactura(Map<String, Integer> cesta) {
		Float total = 0f;
		System.out.println("Producto\t\tPrecio\t\tCantidad\t\tSubtotal");
		System.out.println("----------------------------------------------------------------------");
		for (String prod : cesta.keySet()) {
			Integer cantidad = cesta.get(prod);
			Float precioUnidad = productos.get(prod);
			Float subtotal = cantidad * precioUnidad;
			total += subtotal;
			String subtotalStr = String.format("%.2f", subtotal);
			System.out.println(prod + "\t\t" + precioUnidad + "\t\t" + cantidad + "\t\t" + subtotalStr );
		}
		System.out.println("----------------------------------------------------------------------");
		System.out.println("Total: "+ String.format("%.2f", total));
	}

	private static Integer esNumero(String input) {
		try {
			return Integer.parseInt(input);
		} catch (NumberFormatException e) {
			return null;
		}
	}

	private static void actualizarProductos(String rutaFichero) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(rutaFichero));
			String linea = br.readLine();
			linea = br.readLine();
			while (null != linea) {
				String[] datos = linea.split(";");
				String prod = datos[0];
				Float precio = Float.parseFloat(datos[1]);
				if (precio <= 0) {
					productos.remove(prod);
				} else {
					productos.put(prod, precio);
				}
				linea = br.readLine();
			}
			br.close();
		} catch (FileNotFoundException e) {
			System.err.println("El archivo de actualización no existe.");
		} catch (IOException e) {
			System.err.println("Error de lectura.");
		}

	}

	private static void guardarDatosSupermercado() {
		Date hoy = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMdd");
		String rutaSalida = "ficheros/supermercado/cierre_" + sdf.format(hoy) + ".csv";
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(rutaSalida));
			bw.write("Producto;Precio");
			for (String producto : productos.keySet()) {
				Float precio = productos.get(producto);
				String linea = producto + ";" + precio;
				bw.write("\n" + linea);
			}
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
