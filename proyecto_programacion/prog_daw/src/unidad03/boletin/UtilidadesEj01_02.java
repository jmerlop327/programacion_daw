package unidad03.boletin;

public class UtilidadesEj01_02 {
	/**
	 * si el método se ejecuta sin errores devuelve el mismo número que se le pasa
	 * por parámetro
	 */
	public static int aniadir(int input) {
		System.out.println("Has añadido un elemento!");
		return input;
	}

	/**
	 * si el método se ejecuta sin errores devuelve un 0
	 */
	public static int aniadir() {
		System.out.println("Has añadido un elemento!");
		return 0;
	}

	public static void mostrarMenu() {
		System.out.println("""
				----------------| MENÚ |--------------
				1.- Añadir
				2.- Borrar
				3.- Modificar
				4.- Mostrar por pantalla
				5.- Finalizar
				6.- Añadir saltos de línea
				---------------------------------------
									""");
	}

	/**
	 * método adicional en el ejercicio anterior que sea capaz de insertar 10 saltos
	 * de línea en la salida estándar. Utilízalo cuando creas que es necesario en la
	 * aplicación. EXTRA: crear tantos saltos como se indique en el parámetro
	 */
	public static void saltos(int saltos) {
		for (int i = 0; i < saltos; i++) {
			System.out.print("\n");
		}
	}
}
