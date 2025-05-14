package unidad07.ampliacion;

import java.util.Scanner;
import java.util.Set;

public class Gestisimal {
	static Almacen alm = new Almacen();
	static Set<Producto> productos = alm.getProductos(); 
	public static void main(String[] args) {
		boolean salir = false;
		do {
			mostrarMenu();
			Scanner scan = new Scanner(System.in);
			//obtener opcion
			int opc = Integer.parseInt(scan .nextLine());
			switch (opc) {
			case 1:
				//mostrar listado de productos
				break;
			case 2:
				//Dar de baja un producto por su codigo
				break;
			case 3:
				//Búsqueda de productos
				break;
			case 4:
				//Modificar pvp por su codigo
				break;
			case 5:
				// Actualización del almacen por fichero
				break;
			case 6:
				salir = true;
				// Guardar estado actual en un fichero YYYYMMDD_gestisimal.csv
				break;

			default:
				System.err.println("Opción incorrecta!");
				break;
			}
		} while (!salir);
	}
	private static void mostrarMenu() {
		// TODO Auto-generated method stub
	}

}
