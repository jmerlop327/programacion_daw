package unidad08.gestisimal;

import java.io.File;
import java.util.Scanner;

public class Gestisimal {
	static Almacen alm = new Almacen();

	public static void main(String[] args) {
		boolean salir = false;
		Scanner scan = new Scanner(System.in);
		do {
			mostrarMenu();
			// obtener opcion
			int opc = Integer.parseInt(scan.nextLine());
			switch (opc) {
			case 1:
				// mostrar listado de articulos
				alm.mostrarArticulos();
				break;
			case 2:
				// Dar de baja un articulo por su codigo
				System.out.println("Introduce el código del artículo a eliminar");
				String codigo = scan.nextLine();
				if (alm.eliminarArtículo(codigo)) {
					System.out.println("Artículo eliminado");
				} else {
					System.out.println("Código no encontrado. No se eliminó ningún artículo");
				}

				break;
			case 3:
				// Búsqueda de articulos por cadena de texto de al menos 5 caracteres
				String cadenaBusqueda = scan.nextLine();
				if (null != cadenaBusqueda && cadenaBusqueda.length() >= 5) {
					alm.mostrarArticulos(cadenaBusqueda);
				} else {
					System.out.println("Los parámetros de la búsqueda no son correctos. Al menos 5 caracteres");
				}
				break;
			case 4:
				// Modificar pvp por su codigo
				System.out.println("Introduce el código del artículo para cambiar su precio de venta:");
				String cod = scan.nextLine();
				Articulo art = alm.obtenerArticulo(cod);
				if (null != art) {
					System.out.println(art);
					System.out.println("Introduce el nuevo PVP");
					String pvpStr = scan.nextLine();
					// TODO: control de errores
					Float pvp = Float.parseFloat(pvpStr);
					art.setPrecioVenta(pvp);
					alm.actualizarArticulo(art);
					System.out.println("Precio del artículo modificado");
				}
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
		scan.close();
	}

	private static void mostrarMenu() {
		System.out.println("1. mostrar articulos");
		System.out.println("3. buscar articulos por cadena de texto");
		System.out.println("5. carga de articulos");
	}

}
