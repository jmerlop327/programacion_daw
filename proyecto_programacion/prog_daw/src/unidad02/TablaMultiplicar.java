package unidad02;

import java.util.Scanner;

/**
 * Obtiene un número entero por teclado e imprime la tabla de multiplicar
 * de dicho número del 0 al 10
 */
public class TablaMultiplicar {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Introduce un número para calcular la tabla de multiplicar:");
		int numero = scan.nextInt();
		scan.close();
		//for (declara e inicializa la variable;condicion que cumple la variable;incremento/decremento de variable) {
		//indice++ es lo mismo que indice = indice + 1
		for (int indice = 0;indice<=10;indice++) {
			System.out.println(numero + " x " + indice + " = " + indice*numero);
		}

	}

}
