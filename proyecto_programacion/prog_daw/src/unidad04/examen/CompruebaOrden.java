package unidad04.examen;

import java.util.Scanner;

public class CompruebaOrden {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		System.out.println("Introduzce un número indeterminado de números entre 1 y 99 separados por espacios");
		String texto = teclado.nextLine();
		if (compruebaOrden(texto)) {
			System.out.println("Los números están ordenados");
		} else {
			System.out.println("Los números NO están ordenados");
		}

	}

	private static boolean compruebaEntrada(String texto) {
		String[] numeros = texto.split(" ");
		boolean entradaCorrecta = true;
		try {
			for (String num : numeros) {
				Integer entero = Integer.parseInt(num);
				if (entero < 1 || entero > 99) {
					throw new NumberFormatException();
				}
			}

		} catch (NumberFormatException e) {
			System.out.println("Solo se permiten numeros del 1 al 99 separados por espacios");
			entradaCorrecta = false;
		}
		return entradaCorrecta;
	}

	private static boolean compruebaOrden(String texto) {
		String[] numeros = texto.split(" ");
		boolean ordenado = compruebaEntrada(texto);
		int anterior = 0;
		int index = 0;
		while (ordenado && index < numeros.length) {
			Integer entero = Integer.parseInt(numeros[index]);
			if (entero >= anterior) {
				anterior = entero;
			} else {
				ordenado = false;
			}
			index++;
		}
		
		return ordenado;
	}

}
