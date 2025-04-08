package unidad06;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Inventario578Set {
	static Scanner in;

	public static boolean casoDePrueba() {

		// LEER CASO DE PRUEBA
		int casos = in.nextInt();
		in.nextLine();
		Set<String> productos = new HashSet<String>();
		if (casos == 0)
			return false;
		else {
			// CÓDIGO PRINCIPAL AQUÍ
			// Procesa un único caso leyendo con
			// in.next*()
			for (int i = 0; i < casos; i++) {
				String producto = in.nextLine().toLowerCase();
				productos.add(producto);
			}
			System.out.println(productos.size());
			return true;
		}

	} // casoDePrueba

	public static void main(String[] args) {

		in = new java.util.Scanner(System.in);

		while (casoDePrueba())
			;

	} // main
}
