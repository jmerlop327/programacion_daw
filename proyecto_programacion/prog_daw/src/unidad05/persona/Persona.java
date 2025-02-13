package unidad05.persona;

import java.util.Random;

import unidad05.util.Utilidades;

public class Persona {
	// Atributos
	private String nombre;
	private String dni;
	private int edad;
	private char sexo;
	private float peso;
	private float altura;

	// Constructores
	/**
	 * Un constructor por defecto
	 */
	public Persona() {
		this.nombre = "";
		this.dni = this.generaDni();
		this.edad = 0;
		this.sexo = 'N';
		this.peso = 0f;
		this.altura = 0f;
	}

	/**
	 * Un constructor con el nombre, edad y sexo.
	 */
	public Persona(String nombre, int edad, char sexo) {
		this();
		this.nombre = nombre;
		this.edad = edad;
		this.sexo = comprobarSexo(sexo);
	}

	/**
	 * Un constructor con todos los atributos como parámetro
	 */
	public Persona(String nombre, int edad, char sexo, float peso, float altura) {
		this(nombre, edad, sexo);
		this.peso = peso;
		this.altura = altura;
	}
	// getters y setters

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the edad
	 */
	public int getEdad() {
		return edad;
	}

	/**
	 * @param edad the edad to set
	 */
	public void setEdad(int edad) {
		this.edad = edad;
	}

	/**
	 * @return the sexo
	 */
	public char getSexo() {
		return sexo;
	}

	/**
	 * @param sexo the sexo to set
	 */
	public void setSexo(char sexo) {
		this.sexo = comprobarSexo(sexo);
	}

	/**
	 * @return the peso
	 */
	public float getPeso() {
		return peso;
	}

	/**
	 * @param peso the peso to set
	 */
	public void setPeso(float peso) {
		this.peso = peso;
	}

	/**
	 * @return the altura
	 */
	public float getAltura() {
		return altura;
	}

	/**
	 * @param altura the altura to set
	 */
	public void setAltura(float altura) {
		this.altura = altura;
	}

	/**
	 * @return the dni
	 */
	public String getDni() {
		return dni;
	}

	// métodos de instancia
	/**
	 * Devuelve el sexo H o M si es correcto o N en cualquier otro caso
	 * 
	 * @param sexo
	 * @return sexoFinal
	 */
	private char comprobarSexo(char sexo) {
		char sexoFinal = 'N';
		sexo = Character.toUpperCase(sexo);
		if (sexo == 'H' || sexo == 'M') {
			sexoFinal = sexo;
		}
		return sexoFinal;
	}

	/**
	 * Devuelve un dni aleatoriamente
	 * 
	 * @return dni
	 */
	private String generaDni() {
		// 8 numeros y una letra
		Random random = new Random();
		int numero = random.nextInt(99999999) + 1;
		char letra = Utilidades.LETRAS.charAt(numero % 23);
		String dni = numero + String.valueOf(letra);
		while (dni.length() < 9) {
			dni = "0" + dni;
		}
		return dni;
	}

	

	/**
	 * Devuelve true si la persona tiene 18 años o más
	 * 
	 * @return
	 */
	public boolean esMayorDeEdad() {
		return this.edad >= 18;
	}

	public int calcularImc() {
		float imc = this.peso / (this.altura * this.altura);
		int pesoIdeal = 0;
		if (imc < 20) {
			pesoIdeal = -1;
		} else if (imc > 25) {
			pesoIdeal = 1;
		}
		return pesoIdeal;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Persona:\n");
		if (nombre != null && !nombre.isBlank()) {
			builder.append(nombre);
			builder.append(", ");
		}
		if (dni != null) {
			builder.append("D.N.I.: ");
			builder.append(dni);
			builder.append(". ");
		}
		builder.append(edad);
		builder.append(" años");
		builder.append(". Sexo: ");
		if (sexo == 'H') {
			builder.append("hombre");
		} else if (sexo == 'M') {
			builder.append("mujer");
		} else {
			builder.append("no especificado");
		}
		builder.append(". Peso: ");
		builder.append(peso);
		builder.append(" kg., altura: ");
		builder.append(altura * 100);
		builder.append(" cm.\n");
		if (peso > 0 && altura > 0) {
			switch (this.calcularImc()) {
			case -1:
				builder.append("Su IMC es menor a 20, tiene infrapeso.");
				break;
			case 0:
				builder.append("Su IMC está entre 20 y 25, tiene peso ideal.");
				break;
			case 1:
				builder.append("Su IMC es mayor a 25, tiene sobrepeso.");
				break;
			}
		}
		return builder.toString();
	}

}
