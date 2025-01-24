package unidad04.examen;

import java.util.Arrays;
import java.util.Scanner;

public class Ciudades {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduce las ciudades separadas por coma");
		String input = scan.nextLine();
		String[] ciudades = input.split(",");
		String[] ciudades10 = new String[10];

		int numeroCiudades = (ciudades.length > 10) ? 10 : ciudades.length;
		for (int i = 0; i < 10; i++) {
			if (i < numeroCiudades) {
				ciudades10[i] = ciudades[i].trim();
			} else {
				ciudades10[i] = "";
			}
		}
		mostrarMismasVocales(ciudades10);
	}

	/**
	 * Devuelve las vocales existentes en la cadena de entrada
	 * 
	 * @param ciudad
	 * @return vocalesCiudad
	 */
	private static String obtenerVocales(String ciudad) {
		final String VOCALES = "aeiou";
		String vocalesCiudad = "";
		for (char c : VOCALES.toCharArray()) {
			String caracterCadena = Character.toString(c);
			if (ciudad.contains(caracterCadena)) {
				vocalesCiudad += caracterCadena;
			}
		}
		return vocalesCiudad;
	}

	/**
	 * Devuelve la cadena pasada por parámetro sin espacion ni tildes
	 * 
	 * @param cadena
	 * @return cadenaPlana
	 */
	private static String aplanaCadena(String cadena) {
		// Se pone en minúscula y sin espacios al principio y final
		String cadenaPlana = cadena.toLowerCase().trim();
		// Se quitan los caracteres con tildes
		cadenaPlana = cadenaPlana.replace('á', 'a');
		cadenaPlana = cadenaPlana.replace('é', 'e');
		cadenaPlana = cadenaPlana.replace('í', 'i');
		cadenaPlana = cadenaPlana.replace('ó', 'o');
		cadenaPlana = cadenaPlana.replace('ú', 'u');
		cadenaPlana = cadenaPlana.replace('ü', 'u');
		// quitamos los espacios intermedios para casos como "Buenos Aires"
		cadenaPlana = cadenaPlana.replace(" ", "");
		return cadenaPlana;
	}

	/**
	 * Devuelve la posición de la cadena si existe entre las contenidas en el array.
	 * Devuelve -1 en caso de que no esté
	 * 
	 * @param ciudad
	 * @param ciudadesAplanadas
	 * @return indice
	 */
	private static int existeCiudad(String ciudad, String[] ciudadesAplanadas) {
		int indice = -1;
		String ciudadAplanada = aplanaCadena(ciudad);
		int i = 0;
		boolean encontrado = false;
		while (!encontrado && i < ciudadesAplanadas.length) {
			if (ciudadesAplanadas[i].equals(ciudadAplanada)) {
				encontrado = true;
				indice = i;
			}
		}
		return indice;
	}

	/**
	 * Devuelve true si existen ciudades repetidas y false en caso contrario
	 * 
	 * @param ciudades
	 * @return repetidas
	 */
	private static boolean ciudadesRepetidas(String[] ciudades) {
		boolean repetidas = false;
		int i = 0, j = 0;
		while (!repetidas && i < ciudades.length) {
			while (!repetidas && j < ciudades.length) {
				if (ciudades[i].equals(ciudades[j]) && i != j) {
					repetidas = true;
				}
				j++;
			}
			i++;
		}
		return repetidas;
	}

	/**
	 * Devuelve true si las cadenas del array están ordenadas alfabeticamente por la
	 * primera letra
	 * 
	 * @param ciudades
	 * @return
	 */
	private static boolean ciudadesOrdenadas(String[] ciudades) {
		boolean ordenado = true;
		int i = 1;
		while (ordenado && i < ciudades.length) {
			if (!ordenCorrecto(ciudades[i - 1], ciudades[i])) {
				ordenado = false;
			}
			i++;
		}
		return ordenado;
	}

	/**
	 * POR SIMPLIFICAR solo se hace el orden teniendo en cuenta la primera letra de
	 * cada palabra
	 * 
	 * @param string
	 * @param string2
	 * @return
	 */
	private static boolean ordenCorrecto(String string, String string2) {
		return string.charAt(0) <= string2.charAt(0);
	}

	/**
	 * Muestra las ciudades en las que coinciden las mismas vocales
	 * 
	 * @param ciudades
	 */
	private static void mostrarMismasVocales(String[] ciudades) {
		String[] ciudadesPlanas10 = new String[10];
		String[] vocalesCiudades = new String[10];
		String[] ciudadesConVocalesRepetidas = new String[10];
		for (int i = 0; i < ciudades.length; i++) {
			ciudadesPlanas10[i] = aplanaCadena(ciudades[i]);
			vocalesCiudades[i] = obtenerVocales(ciudadesPlanas10[i]);
		}
		String[] procesadas = new String[10];
		for (int i = 0; i < ciudades.length; i++) {
			boolean repe = false;
			int k = 0;
			String ciudad = ciudades[i];
			Arrays.fill(ciudadesConVocalesRepetidas, "");
			if (!"".equals(vocalesCiudades[i]) && !contiene(procesadas, vocalesCiudades[i])) {
				ciudadesConVocalesRepetidas[k++] = ciudades[i];
				for (int j = i + 1; j < ciudades.length; j++) {
					if (vocalesCiudades[i].equals(vocalesCiudades[j])) {
						ciudadesConVocalesRepetidas[k++] = ciudades[j];
						procesadas[i] = vocalesCiudades[i];
						repe = true;
					}
				}
			}
			while (k >= 0 && repe) {
				System.out.print(ciudadesConVocalesRepetidas[k--] + " ");
			}
			if (repe) {
				System.out.print("\n");
			}
		}
	}

	/**
	 * Devuelve true si la cadena está en el array
	 * 
	 * @param procesadas
	 * @param cadena
	 * @return encontrado
	 */
	private static boolean contiene(String[] procesadas, String cadena) {
		int i = 0;
		boolean encontrado = false;
		while (i < procesadas.length && !encontrado) {
			if (cadena.equals(procesadas[i])) {
				encontrado = true;
			}
			i++;
		}
		return encontrado;
	}
}
