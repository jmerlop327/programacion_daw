package unidad04.boletin;

public class PruebasRegex {

	public static void main(String[] args) {
		//String patronFechaDia = "[0][1-9]|[1-9]|[12]\\d|[3][01]";
		String cadena = args[0];
		String patron = args[1];
		checkEjemploRegex(cadena, patron);

	}

	private static void checkEjemploRegex(String cadena, String patron) {
		if (cadena.matches(patron)) {
			System.out.println("formato correcto");
		} else {
			System.out.println("formato INcorrecto");
		}
		
	}
}
