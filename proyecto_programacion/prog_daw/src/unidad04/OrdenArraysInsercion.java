package unidad04;

public class OrdenArraysInsercion {

	public static void main(String[] args) {
		Integer[] array = { 7, 3, 4, 10, 6 };
		UtilidadesArray.mostrarArray(array);
		ordenInsercion(array);
		UtilidadesArray.mostrarArray(array);
	}

	private static void ordenInsercion(Integer[] array) {
		for (int i = 1; i < array.length; i++) {
			int k = array[i];
			int j = i - 1;
			while (j >= 0 && array[j] > k) {
				array[j + 1] = array[j];
				j--;
			}
			array[j + 1] = k;
		}

	}

}