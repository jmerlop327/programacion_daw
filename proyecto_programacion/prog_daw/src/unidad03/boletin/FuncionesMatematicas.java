package unidad03.boletin;

public class FuncionesMatematicas {

	/**
	 * Devuelve true si el número pasado por parámetro es primo
	 * 
	 * @param numero
	 * @return esPrimo
	 */
	public static boolean esPrimo(long numero) {
		boolean esPrimo = true;

		int divisor = 2;
		while (esPrimo && divisor < numero / 2) {
			if (numero % divisor == 0) {
				esPrimo = false;
			}
			divisor++;
		}
		return esPrimo;
	}

	/**
	 * Devuelve el siguiente número primo a partir del parámetro de entrada
	 * 
	 * @param numero
	 * @return siguientePrimo
	 */
	public static long siguientePrimo(long numero) {
		long siguientePrimo = numero + 1;
		boolean encontrado = false;
		while (!encontrado) {
			if (esPrimo(siguientePrimo)) {
				encontrado = true;
			} else {
				siguientePrimo++;
			}
		}
		return siguientePrimo;
	}

	/**
	 * Devuelve el número de dígitos que tiene el parámetro de entrada
	 * 
	 * @param numero
	 * @return numCifras
	 */
	public static int digitos(long numero) {
		int numCifras = 1;
		while (numero / 10 != 0) {
			numCifras++;
			numero = numero / 10;
		}
		return numCifras;
	}

	/**
	 * Devuelve true si el número es capicua y false en caso contrario
	 * 
	 * @param numero
	 * @return esCapicua
	 */
	public static boolean esCapicua(long numero) {
		boolean esCapicua = true;
		long numActual = numero;
		int numCifras = digitos(numActual);
		for (int i = 0; i < numCifras / 2; i++) {
			long numDiv = (long) Math.pow(10, numCifras - i - 1);
			long numMod = (long) Math.pow(10, i);
			double numDelante = (numero / numDiv) % 10;
			double numDetras = (numero / numMod) % 10;
			if (numDelante != numDetras) {
				esCapicua = false;
			}
		}
		return esCapicua;
	}

	/**
	 * Devuelve la letra correspondiente al número de dni
	 * 
	 * @param dni
	 * @return letra
	 */
	public static char letraNif(long dni) {
		String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
		int resto = (int) dni % 23;
		// 0: "T", 1: "R", 2: "W", 3: "A", 4: "G", 5: "M", 6: "Y", 7: "F",
		// 8: "P", 9:"D",10:"X", 11: "B", 12: "N",13: "J", 14: "Z",
		// 15: "S", 16: "Q", 17: "V", 18: "H", 19: "L", 20: "C", 21: "K",
		// 22: "E".
		// OPCIÓN 1: switch con el resto
//		switch (resto) {
//		case 0:
//			letra = 'T';
//			break;
//
//		default:
//			break;
//		}
		// OPCIÓN 2: Usando charAt de String
		char letra = letras.charAt(resto);
		return letra;
	}

	/**
	 * Devuelve true si el dni es correcto
	 * 
	 * @param dni
	 * @return correcto
	 */
	public static boolean compruebaDni(String dni) {
		if (dni.length() < 9) {
			int faltan = 9 - dni.length();
			for (int i = 0; i < faltan; i++) {
				dni = "0" + dni;
			}
		}
		char letra = dni.substring(8).charAt(0);
		long numero = Long.parseLong(dni.substring(0, 8));
		boolean correcto = letraNif(numero) == letra;
		return correcto;
	}

	/**
	 * Ejercicio de la práctica Da la posición de la primera ocurrencia de un dígito
	 * dentro de un número entero. Si no se encuentra, devuelve -1. Ejemplo:
	 * numero=5678 digito=7 posicion=2 Ejemplo: numero=5678 digito=3 posicion=-1
	 * 
	 * @param numero
	 * @param digito
	 * @return posicion
	 */
	public static Integer posicionDeDigito(Long numero, Integer digito) {
		int posicion = -1;
		boolean encontrado = false;
		int indice = 1;
		long numAux = numero;
		while (!encontrado && numAux > 0) {
			if (numAux % 10 == digito) {
				encontrado = true;
				posicion = indice;
			}
			// numAux = numAux/10;
			numAux /= 10;
			indice++;
		}
		return posicion;
	}

	/**
	 * Toma como parámetros las posiciones inicial y final dentro de un número y
	 * devuelve el trozo correspondiente. Ejemplo: numero=37209 posIni=2 posFin=3
	 * trozo=72
	 * 
	 * @param numero
	 * @param posIni
	 * @param posFin
	 * @return trozo
	 */
	public static long trozoDeNumero(long numero, int posIni, int posFin) {
		int digitos = digitos(numero);
		if ((posIni < 1 || posFin > digitos) || posIni > posFin) {
			throw new IllegalArgumentException("Los parámetros de entrada no son correctos");
		}
		long trozo = 0l;
		long numAux = numero;
		int exp = digitos - posFin;
		numAux = numAux / (long) Math.pow(10, exp);
		int multi = 1;
		for (int index = 0; index <= posFin - posIni; index++) {
			trozo += (numAux % 10) * multi;
			numAux /= 10;
			multi *= 10;
		}
		return trozo;
	}

	/**
	 * Pega dos números para formar uno.
	 * 
	 * @param numIzq
	 * @param numDer
	 * @return numero
	 */
	public static long juntaNumeros(long numIzq, long numDer) {
		long numero = numDer;
		numero += numIzq * Math.pow(10, digitos(numDer));
		return numero;
	}

	/**
	 * Calcula el factorial de un número
	 * 
	 * @param numero
	 * @return factorial
	 */
	public static long factorial(long numero) {
		long factorial = 1;
		if (numero >= 0) {
			for (long index = numero; index > 1; index--) {
				factorial *= index;
			}
		} else {
			throw new IllegalArgumentException("No existe factorial de un número negativo");
		}
		return factorial;
	}

	/**
	 * Calcula el factorial de un número de manera recursiva
	 * 
	 * @param numero
	 * @return factorial
	 */
	public static long factorialRec(long numero) {
		long factorial = 1;
		if (numero == 0 || numero == 1) {
			factorial = 1;
		} else if (numero < 0) {
			throw new IllegalArgumentException("No existe factorial de un número negativo");
		} else {
			factorial = numero * factorialRec(numero - 1);
		}
		return factorial;
	}

	/**
	 * t) cambioExacto. Realiza un método que dada una cantidad de euros que el
	 * usuario introduce por teclado mostrará los mínimos billetes y monedas de cada tipo
	 * que serán necesarios para alcanzar dicha cantidad (utilizando los billetes y
	 * monedas de euro).
	 */
	// Tiene un error de ejecución por aproximación de decimales
	public static void cambioExacto(double importe) {
		double restante = importe;
		while (restante > 0) {
			if (restante >= 500) {
				System.out.println("500: " + (int) restante / 500);
				restante = restante % 500;
			} else if (restante >= 200) {
				System.out.println("200: " + (int) restante / 200);
				restante = restante % 200;
			} else if (restante >= 100) {
				System.out.println("100: " + (int) restante / 100);
				restante = restante % 100;
			} else if (restante >= 50) {
				System.out.println("50: " + (int) restante / 50);
				restante = restante % 50;
			} else if (restante >= 20) {
				System.out.println("20: " + (int) restante / 20);
				restante = restante % 20;
			} else if (restante >= 10) {
				System.out.println("10: " + (int) restante / 10);
				restante = restante % 10;
			} else if (restante >= 5) {
				System.out.println("5: " + (int) restante / 5);
				restante = restante % 5;
			} else if (restante >= 2) {
				System.out.println("2: " + (int) restante / 2);
				restante = restante % 2;
			} else if (restante >= 1) {
				System.out.println("1: " + (int) restante / 1);
				restante = restante % 1;
			} else if (restante >= 0.5) {
				System.out.println("50 cts: " + (int)(restante / 0.5));
				restante = restante % 0.5;
			} else if (restante >= 0.2) {
				System.out.println("20 cts: " + (int) (restante / 0.2));
				restante = restante % 0.2;
			} else if (restante >= 0.1) {
				System.out.println("10 cts: " + (int) (restante / 0.1));
				restante = restante % 0.1;
			} else if (restante >= 0.05) {
				System.out.println("5 cts: " + (int) (restante / 0.05));
				restante = restante % 0.05;
			} else if (restante >= 0.02) {
				System.out.println("2 cts: " + (int) (restante / 0.02));
				restante = restante % 0.02;
			} else if (restante > 0.01) {
				System.out.println("1 ct: " + (int) (restante / 0.01));
				restante = restante % 0.009;
			}

		}
	}
}
