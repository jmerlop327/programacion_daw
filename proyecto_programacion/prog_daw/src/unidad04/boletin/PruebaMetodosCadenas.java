package unidad04.boletin;

import java.util.Date;

public class PruebaMetodosCadenas {

	public static void main(String[] args) {
		String cadena = " Hola    me       llamo John     ";
		System.out.println(FuncionesCadenas.contarPalabras(cadena));
		System.out.println("33"+FuncionesCadenas.eliminarEspaciosDuplicados(cadena)+"33");
		System.out.println(FuncionesCadenas.invertirCadena(cadena));
		System.out.println(FuncionesCadenas.esPalindromo("narran"));
		System.out.println(FuncionesCadenas.conteoVocales("reconocer"));
		// String patronFechaDia = "[0][1-9]|[1-9]|[12]\\d|[3][01]";
		FuncionesCadenas.checkEjemploRegex("29", "[0][1-9]|[1-9]|[12]\\d|[3][01]");

	}

	private static void cambiaFecha(Date fecha) {
		fecha.setTime(fecha.getTime() + 1000l*60*60);
		
	}

}
