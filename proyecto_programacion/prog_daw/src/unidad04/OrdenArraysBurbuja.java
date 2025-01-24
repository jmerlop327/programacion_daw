package unidad04;

public class OrdenArraysBurbuja {

	public static void main(String[] args) {
		Integer[] array = { 1, 7, 23, -100, 80, -30, 15 };
		System.out.println("antes de orden");
		UtilidadesArray.mostrarArray(array);
		int contadorAccesos = 0;
		int contadorCambios = 0;
		// Método de ordenación de la burbuja
		boolean intercambio = true;
		int elementosPorRecorrer = array.length-1;
		while (intercambio) {
			intercambio = false;
			for (int i = 0;i<elementosPorRecorrer;i++) {
				contadorAccesos++;
				if (array[i] > array[i+1]) {
					// si están desordenados intercambiamos los elementos adyacentes
					int aux = array[i];
					array[i] = array[i+1];
					array[i+1] = aux;
					intercambio = true;
					contadorCambios++;
				}
			}
			elementosPorRecorrer--;
		}
		System.out.println("después de orden");
		System.out.println("accesos " + contadorAccesos);
		System.out.println("cambios " + contadorCambios);
		UtilidadesArray.mostrarArray(array);
	}

}

//
//package unidad04;
//
//public class OrdenArrays {
//
//	public static void main(String[] args) {
//		//Integer[] array = { 1, 7, 23, -100, 80, -30, 15 };
//		Integer[] array = { -100, 1, -30, 7, 15, 23, 80 };
//		System.out.println("antes de orden");
//		UtilidadesArray.mostrarArray(array);
//		int contadorAccesos = 0;
//		int contadorCambios = 0;
//		int ultimoCambio = array.length - 1;
//		// Método de ordenación de la burbuja
//		boolean intercambio = true;
//		int elementosPorRecorrer = array.length - 1;
//		while (intercambio) {
//			intercambio = false;
//			for (int i = 0; i < elementosPorRecorrer; i++) {
//				contadorAccesos++;
//				if (array[i] > array[i + 1]) {
//					// si están desordenados intercambiamos los elementos adyacentes
//					int aux = array[i];
//					array[i] = array[i + 1];
//					array[i + 1] = aux;
//					intercambio = true;
//					ultimoCambio = i + 1;
//					contadorCambios++;
//				}
//			}
//			elementosPorRecorrer = ultimoCambio;
//		}
//		System.out.println("después de orden");
//		System.out.println("accesos " + contadorAccesos);
//		System.out.println("cambios " + contadorCambios);
//		UtilidadesArray.mostrarArray(array);
//	}
//
//}
