package unidad04.boletin;

public class PruebaMetodosCadenas {

	public static void main(String[] args) {
		System.out.println(FuncionesCadenas.esPalindromo("narran"));
		System.out.println(FuncionesCadenas.conteoVocales("reconocer"));
		//String patronFechaDia = "[0][1-9]|[1-9]|[12]\\d|[3][01]";
		FuncionesCadenas.checkEjemploRegex("29", "[0][1-9]|[1-9]|[12]\\d|[3][01]");

	}

}
