package unidad04;

public class UtilidadesArray {
	// Método auxiliar para mostrar el contenido de un array
    public static <T> void mostrarArray(T[] array) {
        for (T elemento : array) {
            System.out.print(elemento.toString() + " ");
        }
        System.out.println();
    }
    // Método auxiliar para mostrar el contenido de un array bidimensional
    public static <T> void mostrarArray(T[][] array) {
        for (int i = 0;i<array.length;i++) {
        	for (int j = 0;j<array.length;j++) {
            System.out.print(array[i][j].toString() + " ");
        	}
        }
        System.out.println();
    }
}
