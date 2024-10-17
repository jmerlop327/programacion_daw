package unidad02.practica;

import java.util.Scanner;

public class Ej03 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Introducirás números positivos. Cuando quieras parar introduce 0.");
		int mayor = Integer.MIN_VALUE;
		int menor = Integer.MAX_VALUE;
		float media = 0;
		int suma = 0;
		int contador = 0;
		int numeroAct = 0;
		do {
			System.out.print("\nIntroduce un número:");
			numeroAct = scan.nextInt();
			if (numeroAct > 0) {				
				contador++;
				if (numeroAct > mayor) {
					mayor = numeroAct;
				}
				if (numeroAct < menor) {
					menor = numeroAct;
				}
				suma += numeroAct;
				media = (float)suma / contador;
			} else if (numeroAct < 0) {
				System.out.println("Solo se permiten números enteros positivos.");
			}
		} while (numeroAct != 0);
		scan.close();
		System.out.println("mayor: " + mayor);
		System.out.println("menor: " + menor);
		System.out.println("suma: " + suma);
		System.out.println("media: " + media);
	}

}
