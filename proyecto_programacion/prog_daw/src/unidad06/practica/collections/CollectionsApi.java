package unidad06.practica.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CollectionsApi {
	public static void main(String[] args) {
		Set<String> cadenas = new HashSet<String>();
		List<Integer> numeros = new ArrayList<Integer>();
		Map<Integer, String> valores = new HashMap<Integer, String>();
		
		//Aplicable a una lista. La ordena por su orden natural. Comparable.
		Collections.sort(numeros);
		//Aplicable a una lista. Invierte el orden de los elementos
		Collections.reverse(numeros);
		//Aplicable a una lista. Mezcla aleatoriamente el orden de los elementos
		Collections.shuffle(numeros);
		//Aplicable a Collection con objetos que implementan a Comparable. Devuelve el elemento máximo
		Collections.max(cadenas);
		Collections.min(cadenas);
		//Aplicable a Collection pero la utilidad es más idónea para listas. Cuenta las veces que aparece un objeto
		Collections.frequency(numeros, 7);
		
	}

}
