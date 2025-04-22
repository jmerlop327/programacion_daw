package unidad06.practica.diccionario;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Diccionario1 {
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
		System.out.println("Dime una palabra en español: ");
		String palabraEspaniol = scan.nextLine();
		String palabraIngles = traducirPalabra(palabraEspaniol);
		System.out.println(palabraEspaniol + " se dice: " + palabraIngles + " en inglés.");
	}

	private static String traducirPalabra(String palabraEspaniol) {
		String result = "PALABRA NO ENCONTRADA EN EL DICCIONARIO";
		if (diccionario.containsKey(palabraEspaniol)) {
			result = diccionario.get(palabraEspaniol);
		}
		return result;
	}
}
