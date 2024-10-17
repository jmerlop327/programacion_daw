package unidad02.practica;

import java.util.Scanner;

public class Ej02 {

	public static void main(String[] args) {
		int opcion = 0;
		do {
			Scanner sc = new Scanner(System.in);
			System.out.println("~~~~~~~~~~~~~~| CALCULADORA |~~~~~~~~~~~~~~\r\n"
					+ "1 - Suma\r\n"
					+ "2 - Resta\r\n"
					+ "3 - Multiplicación\r\n"
					+ "4 – División\r\n"
					+ "5 - Raíz cuadrada\r\n"
					+ "6 – Potencia\r\n"
					+ "0 - Salir del programa\r\n"
					+ "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.print("Elige una opción:");
			opcion = sc.nextInt();
			switch (opcion) {
			case 1:
				System.out.println("Introduce el primer sumando:");
				int  sumando1 = sc.nextInt();
				System.out.println("Introduce el segundo sumando:");
				int  sumando2 = sc.nextInt();
				System.out.println(sumando1 + " + " + sumando2 + " = " + (sumando1 + sumando2));
				break;
			case 2:
				System.out.println("Introduce el minuendo:");
				int  minuendo = sc.nextInt();
				System.out.println("Introduce el sustraendo:");
				int  sustraendo = sc.nextInt();
				System.out.println(minuendo + " - " + sustraendo + " = " + (minuendo - sustraendo));
				break;
			case 3:
				//TODO:multi
				break;
			case 4:
				//TODO:division
				break;
			case 5:
				System.out.println("Introduce el número para calcular su raíz cuadrada:");
				int num = sc.nextInt();
				System.out.println("Raíz cuadrada de " + num + " = " + Math.sqrt(num));
				break;
			case 6:
				System.out.println("Introduce la base:");
				int base = sc.nextInt();
				System.out.println("Introduce el exponente:");
				int exp = sc.nextInt();
				System.out.println(base + "^" + exp + " = " + Math.pow(base, exp));
				break;
			case 0:
				sc.close();
				System.out.println("Gracias. Hasta pronto!");
				break;
			default:
				System.out.println("Opción incorrecta.");
				break;
			}
		} while (opcion != 0);
	}

}
