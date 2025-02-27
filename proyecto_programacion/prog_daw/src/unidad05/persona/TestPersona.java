package unidad05.persona;

import java.util.Arrays;

import unidad05.util.Utilidades;

public class TestPersona {

	public static void main(String[] args) {
		Persona persona1 = new Persona();
		System.out.println(persona1);
		System.out.println("\n\ndni: " + persona1.getDni() + " es correcto? " + Utilidades.checkDni(persona1.getDni()));
		Persona juan = new Persona("Juan", 20, 'H');
		juan.setAltura(1.75f);
		juan.setPeso(59.8f);
		System.out.println(juan);
		System.out.println("\n\ndni: " + juan.getDni() + " es correcto? " + Utilidades.checkDni(juan.getDni()));
		Persona alicia = new Persona("Alicia", 45, 'M', 57f, 1.60f);
		System.out.println(alicia);
		System.out.println("\n\ndni: " + alicia.getDni() + " es correcto? " + Utilidades.checkDni(alicia.getDni()));

		String dni = "44071221S";
		System.out.println("\n\ndni: " + dni + " es correcto? " + Utilidades.checkDni(dni));
		// TODO:
		/*
		 * - Pide por teclado el nombre, la edad, sexo, peso y altura.
		 * - Crea 3 objetos de la clase anterior
		 *  el primer objeto obtendrá las anteriores variables pedidas por teclado
		 *  el segundo objeto obtendrá todos los anteriores menos el peso y la altura
		 *  el último por defecto, para este último utiliza los métodos set para darle
		 * a los atributos un valor.
		 * - Para cada objeto, deberá comprobar si está en su peso ideal, tiene
		 * sobrepeso o por debajo de su peso ideal con un mensaje.
		 * - Indicar para cada objeto si es mayor de edad.
		 * - Por último, mostrar la información de cada objeto.
		 */
		
		
		Persona[] personas = new Persona[15];
		personas [0] = new Persona("Ana García", 25, 'F', 55.5f, 1.65f);
        personas[1] = new Persona("Luis Pérez", 30, 'M', 75.0f, 1.80f);
        personas[2] = new Persona("María López", 22, 'F', 60.0f, 1.70f);
        personas[3] = new Persona("Carlos Ruiz", 35, 'M', 80.5f, 1.75f);
        personas[4] = new Persona("Sofía Díaz", 28, 'F', 58.0f, 1.68f);
        personas[5] = new Persona("Javier Gómez", 40, 'M', 85.0f, 1.82f);
        personas[6] = new Persona("Laura Sánchez", 27, 'F', 62.5f, 1.72f);
        personas[7] = new Persona("Pedro Martínez", 33, 'M', 78.0f, 1.79f);
        personas[8] = new Persona("Elena Fernández", 24, 'F', 56.0f, 1.66f);
        personas[9] = new Persona("Miguel Torres", 29, 'M', 73.5f, 1.77f);
        personas[10] = new Persona("Clara Rodríguez", 26, 'F', 59.0f, 1.69f);
        personas[11] = new Persona("Antonio Hernández", 38, 'M', 82.0f, 1.81f);
        personas[12] = new Persona("Lucía Morales", 23, 'F', 57.5f, 1.67f);
        personas[13] = new Persona("José Castillo", 31, 'M', 76.0f, 1.78f);
        personas[14] = new Persona("Isabel Vargas", 32, 'F', 61.0f, 1.71f);
        
        System.out.println("antes");
        for (Persona persona : personas) {
			System.out.println(persona.getEdad() + " " +persona.getNombre());
		}
        Arrays.sort(personas);
        System.out.println("después");
        for (Persona persona : personas) {
			System.out.println(persona.getEdad() + " " +persona.getNombre());
		}
        
        personas[0].compareTo(personas[7]);
        
	}

}
