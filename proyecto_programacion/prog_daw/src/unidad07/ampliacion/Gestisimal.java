package unidad07.ampliacion;

import java.io.File;
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
			// obtener opcion
			int opc = Integer.parseInt(scan.nextLine());
			switch (opc) {
			case 1:
				// mostrar listado de productos
				break;
			case 2:
				// Dar de baja un producto por su codigo
				break;
			case 3:
				// Búsqueda de productos
				break;
			case 4:
				// Modificar pvp por su codigo
				break;
			case 5:
				// Actualización del almacen por fichero
				System.out.println("Introduce la ruta del fichero:");
				String ruta = scan.nextLine();
				File fichero = new File("ficheros/gestisimal/" + ruta);
				if (!fichero.exists()) {
					System.err.printf("El fichero %s no se encuentra en el sistema\n", ruta);
				} else {
					alm.actualizarAlmacen(fichero);
				}
				break;
			case 6:
				// Guardar estado actual en un fichero YYYYMMDD_gestisimal.csv
				String rutaEscritura = "ficheros20250414_gestisimal.csv";
				alm.guardarDatosAlmacen(new File(rutaEscritura));
				salir = true;
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
