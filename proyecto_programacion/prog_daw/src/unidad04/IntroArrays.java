package unidad04;

public class IntroArrays {
	public static void main(String[] args) {
		// Introducción al manejo de arrays
		// Inicialización de un array con datos
		int[] arrayConDatos = { 1, 7, 23, -100 };
		// Inicializar un array vacío
		int[] arrayVacio = new int[4];
		arrayVacio[0] = 1;
		arrayVacio[1] = 7;
		arrayVacio[2] = 23;
		arrayVacio[3] = -100;
		System.out.println("La primera posición del array inicializado con datos es: " + arrayConDatos[0]);
		System.out.println("El array inicializado vacio tiene " + arrayVacio.length + " elementos.");

		// Recorriendo el array con un for
		System.out.println("Los elementos del array son (con for tradicional):");
		for (int index = 0; index < arrayVacio.length; index++) {
			System.out.println(arrayVacio[index]);
		}

		System.out.println("Los elementos del array son (con foreach):");
		// Recorriendo el array con un for extendido o foreach
		for (int i : arrayConDatos) {
			System.out.println(i);
		}
		
		System.out.println("La suma del primer elemento y el último del array es: "+ (arrayConDatos[0]+arrayConDatos[3]));

		char[] arrayChar = { 's', 'Ñ', '@', '?', 'm' };
		// Recorriendo el array de caracteres con un for
		System.out.println("Los elementos del array son (con for tradicional):");
		for (int index = 0; index < arrayChar.length; index++) {
			System.out.println(arrayChar[index]);
		}

		// Recorriendo el array con un for extendido o foreach
		System.out.println("Los elementos del array son (con foreach):");
		for (char caracter : arrayChar) {
			System.out.println(caracter);
		}
		
		
		
		
		String[] arrayString = new String[4];
		arrayString[1] = "HOLA";
		int indice = 0;
		for (String string : arrayString) {
			System.out.printf("La cadena en la posición %d es --%s--\n", indice++, string);
		}
		
		// Declarar los siguientes arrays inicializados
		// con los valores mostrados. Luego recorrerlos y
		// mostrar todos sus elementos. ¿Qué pasa con los
		// elementos vacíos?
		// Integer --> arrayEnteros[1,10,99, , , 7]
		// Character --> arrayCharacter['i', '0', , 'A']

		System.out.println("----------------");
		Integer[] arrayEnteros = new Integer[6];
		arrayEnteros[0] = 1;
		arrayEnteros[1] = 10;
		arrayEnteros[2] = 99;
		arrayEnteros[5] = 7;
		for (Integer integer : arrayEnteros) {
			System.out.println(integer);
		}
		
		System.out.println("----------------");
		Character[] arrayCharacter = new Character[4];
		arrayCharacter[0] = 'i';
		arrayCharacter[1] = '0';
		arrayCharacter[3] = 'A';
		for (Character character : arrayCharacter) {
			System.out.println(character);
		}
	}
}
