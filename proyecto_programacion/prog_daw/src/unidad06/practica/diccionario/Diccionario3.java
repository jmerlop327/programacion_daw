package unidad06.practica.diccionario;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Diccionario3 {
	static Map<String, String> diccionario = new TreeMap<String, String>();
	public static void main(String[] args) {
		diccionario.put("perro", "dog");
		diccionario.put("gato", "cat");
		diccionario.put("casa", "house");
		diccionario.put("árbol", "tree");
		diccionario.put("sol", "sun");
		diccionario.put("luna", "moon");
		diccionario.put("agua", "water");
		diccionario.put("fuego", "fire");
		diccionario.put("cielo", "sky");
		diccionario.put("flor", "flower");
		diccionario.put("pájaro", "bird");
		diccionario.put("libro", "book");
		diccionario.put("mesa", "table");
		diccionario.put("silla", "chair");
		diccionario.put("puerta", "door");
		diccionario.put("ventana", "window");
		diccionario.put("coche", "car");
		diccionario.put("manzana", "apple");
		diccionario.put("pan", "bread");
		diccionario.put("leche", "milk");
		Scanner scan = new Scanner(System.in);
		List<String> palabras = new ArrayList<String>();
		palabras.addAll(diccionario.keySet());
		Collections.shuffle(palabras);
		Iterator<String> itPalabras = palabras.iterator();
		int numPalabras = 0;
		int correctas = 0;
		int incorrectas = 0;
		while (itPalabras.hasNext() && numPalabras  < 5) {
			String palabra = itPalabras.next();
			System.out.println("Cómo se dice: " + palabra + " en inglés?");
			String palabraIngles = scan.nextLine();
			if (null != palabraIngles && palabraIngles.equalsIgnoreCase(traducirPalabra(palabra))) {
				System.out.println("CORRECTO!");
				correctas ++;
			} else {
				System.out.println("INCORRECTO!");
				incorrectas++;
			}
			numPalabras++;
		}
		System.out.printf("Has acertado %d palabras y has fallado %d palabras.\n", correctas, incorrectas);
	}

	private static String traducirPalabra(String palabraEspaniol) {
		String result = "PALABRA NO ENCONTRADA EN EL DICCIONARIO";
		if (diccionario.containsKey(palabraEspaniol)) {
			result = diccionario.get(palabraEspaniol);
		}
		return result;
	}
	
	/**
	 * Modifica la traducción de una palabra en el diccionario
	 * @param palabraSpa
	 * @param nuevaTraduccionEng
	 */
	private static void corregirPalabra(String palabraSpa, String nuevaTraduccionEng) {
		if (diccionario.containsKey(palabraSpa)) {
			diccionario.put(palabraSpa, nuevaTraduccionEng);
			System.out.println("Traducción de la palabra " + palabraSpa + " modificada con éxito.");
		} else {
			System.err.println("PALABRA NO ENCONTRADA EN EL DICCIONARIO");
		}
	}
	
	/**
	 * Elimina la palabra pasada como parámetro del diccionario
	 * @param palabra
	 */
	private static void eliminarPalabra(String palabra) {
		if (diccionario.containsKey(palabra)) {
			diccionario.remove(palabra);
			System.out.println("La traducción de la palabra " + palabra + " se ha eliminado del diccionario.");
		} else {
			System.err.println("PALABRA NO ENCONTRADA EN EL DICCIONARIO");
		}
	}
}
