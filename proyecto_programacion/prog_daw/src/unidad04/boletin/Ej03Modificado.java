package unidad04.boletin;

public class Ej03Modificado {

	/**
	 * Define tres arrays de 20 números enteros cada una, con nombres numero,
	 * cuadrado y cubo. Carga el primer elemento del array numero con un valor
	 * aleatorio entre 0 y 100. En el array cuadrado se deben almacenar el número
	 * multiplicado por 10. En el array cubo se deben almacenar el número
	 * multiplicado por 100. El array número se seguirá rellenando con las potencias
	 * sucesivas del primer número calculado. A continuación, muestra el contenido
	 * de los tres arrays dispuesto en tres columnas.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int[] numero = new int[20];
		int[] cuadrado = new int[20];
		int[] cubo = new int[20];
		int numAleatorio = (int) (Math.random() * 101);
		for (int i = 0; i < numero.length; i++) {
			int num = (int) Math.pow(numAleatorio, i + 1);
			numero[i] = num;
			cuadrado[i] = num * 10;
			cubo[i] = num * 100;
		}
		for (int i = 0; i < numero.length; i++) {
			System.out.printf("%d\t%d\t%d\t\n", numero[i], cuadrado[i], cubo[i]);
		}

	}

}
