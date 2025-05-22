package unidad08.gestisimal;

import java.io.File;
import java.util.Scanner;
import java.util.Set;

public class Gestisimal {
	static Almacen alm = new Almacen();

	public static void main(String[] args) {
		boolean salir = false;
		do {
			mostrarMenu();
			Scanner scan = new Scanner(System.in);
			// obtener opcion
			int opc = Integer.parseInt(scan.nextLine());
			switch (opc) {
			case 1:
				// mostrar listado de articulos
				alm.mostrarArticulos();
				break;
			case 2:
				// Dar de baja un articulo por su codigo
				break;
			case 3:
				// Búsqueda de articulos por cadena de texto de al menos 5 caracteres
				String cadenaBusqueda = scan.nextLine();
				if (null != cadenaBusqueda && cadenaBusqueda.length() >= 5) {
					boolean hayAlguno = false;
//					for (Articulo prod : articulos) {
//						if (null != prod && null != prod.getDesc()
//								&& prod.getDesc().toLowerCase().contains(cadenaBusqueda.toLowerCase())) {
//							System.out.println(prod);
//							hayAlguno = true;
//						}
//					}
					if (!hayAlguno) {
						System.out.println("No se encontró ningún articulo para los argumentos de la búsqueda");
					}
				} else {
					System.out.println("Los parámetros de la búsqueda no son correctos. Al menos 5 caracteres");
				}
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
				// Dejamos de implementar esta funcionalidad porque guardamos los datos en bd
				salir = true;
				break;

			default:
				System.err.println("Opción incorrecta!");
				break;
			}
		} while (!salir);
	}

	private static void mostrarMenu() {
		System.out.println("1. mostrar articulos");
		System.out.println("5. carga de articulos");
	}

}
