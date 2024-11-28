package unidad04.boletin;

public class Ej03 {

	/**
	 * Define tres arrays de 20 números enteros cada una, con nombres numero,
	 * cuadrado y cubo. Carga el array numero con valores aleatorios entre 0 y 100.
	 * En el array cuadrado se deben almacenar los cuadrados de los valores que hay
	 * en el array numero. En el array cubo se deben almacenar los cubos de los
	 * valores que hay en numero. A continuación, muestra el contenido de los tres
	 * arrays dispuesto en tres columnas.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int[] numero = new int[20];
		int[] cuadrado = new int[20];
		int[] cubo = new int[20];
		for (int i = 0; i < numero.length; i++) {
			int numAleatorio = (int) (Math.random() * 101);
			numero[i] = numAleatorio;
			cuadrado[i] = numAleatorio * numAleatorio;
			cubo[i] = (int) Math.pow(numAleatorio, 3);
		}
		for (int i = 0; i < numero.length; i++) {
			System.out.printf("%d\t%d\t%d\t\n", numero[i], cuadrado[i], cubo[i]);
		}
		

	}

}
