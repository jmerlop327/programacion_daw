package unidad02.boletin02;

import java.util.Scanner;

/*
 * Escribe un programa que dada una hora determinada (horas y minutos), 
 * calcule los segundos que faltan para llegar a la medianoche
 */
public class ParaMedianoche {

	public static void main(String[] args) {
		// Declaración del objeto Scanner
		Scanner scan = new Scanner(System.in);
		// Con enteros
//		System.out.print("Introduce la hora actual:");
//		int hora = scan.nextInt();
//		System.out.print("\nIntroduce los minutos actuales:");
//		int minutos = scan.nextInt();
		// Con manejo de cadenas
		System.out.println("Introduce la hora actual con formato HH:mm");
		String horaString = scan.nextLine();
		//22:13
		int hora = Integer.parseInt(horaString.substring(0, 2));
		int minutos = Integer.parseInt(horaString.substring(3, 5));
		//TODO: controlar los datos erróneos
		int horasParaMedianoche = (23 - hora);
		int minutosParaMedianoche = (60 - minutos);
		int segParaMedianoche = horasParaMedianoche * 3600 + minutosParaMedianoche * 60;
		System.out.println("\nQuedan " + segParaMedianoche + " segundos para medianoche.");
		scan.close();
	}

}
