package unidad06;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import unidad05.persona.Persona;

public class EjemploIterator {

	public static void main(String[] args) {
		Persona p1 = new Persona("amparo", "casal");
		Persona p2 = new Persona("lucía", "jiménez");
		Persona p3 = new Persona("antonio", "marín");
		List<Persona> listaPersona = new ArrayList<Persona>();
		listaPersona.add(p1);
		listaPersona.add(p2);
		listaPersona.add(p3);
		System.out.println("lista inicial\n------------------");
		for (Persona persona : listaPersona) {
			persona.mostrarInfo();
		}
		
		// Con foreach
		/*
		for (Persona persona : listaPersona) {
			if ("amparo".equals(persona.getNombre())) {
				listaPersona.remove(persona);
			}
		}
		*/
		// Con iterator
		Iterator<Persona> itPersona = listaPersona.iterator();
		while (itPersona.hasNext()) {
			Persona persona = itPersona.next();
			if (persona.getNombre().equals("amparo")) {
				itPersona.remove();
				System.out.println("Persona borrada\n------------------");
		 		persona.mostrarInfo();
			}
		}
		// Mostrar lista de elementos
		System.out.println("lista final\n------------------");
		for (Persona persona : listaPersona) {
			persona.mostrarInfo();
		}
	}

}
