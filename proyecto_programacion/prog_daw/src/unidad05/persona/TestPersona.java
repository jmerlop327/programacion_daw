package unidad05.persona;

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

	}

}
