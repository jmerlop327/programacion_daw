package unidad04.boletin;

import java.util.Scanner;

public class Ej07 {
	/**
	 * Realiza un programa que pida la temperatura media que ha hecho en cada mes de
	 * un determinado año y que muestre a continuación un diagrama de barras
	 * horizontales con esos datos. Las barras del diagrama se pueden dibujar a base
	 * de asteriscos o cualquier otro carácter.
	 */
	public static void main(String[] args) {
		float[] temperaturas = new float[12];
		String[] meses = { "enero", "febrero", "marzo", "abril", "mayo", "junio", "julio", "agosto", "septiembre",
				"octubre", "noviembre", "diciembre" };
		Scanner scanner = new Scanner(System.in);
		for (int i = 0; i <meses.length; i++) {
			System.out.printf("Introduce la temperatura media en el mes de %s\n", meses[i]);
			temperaturas[i] = scanner.nextFloat();
		}
		scanner.close();
		for (int i = 0; i <meses.length; i++) {
			String mes = meses[i];
			if (mes.length()>7) {
				System.out.print(mes+"\t");
			}else {
				System.out.print(mes + "\t\t");
			}
			for (int j = 0; j < temperaturas[i];j++) {
				System.out.print("@");
			}
			System.out.print("\n");
		}
	}

}
