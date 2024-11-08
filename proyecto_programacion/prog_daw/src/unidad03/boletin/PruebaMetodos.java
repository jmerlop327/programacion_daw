package unidad03.boletin;

import java.util.Date;
import java.util.Scanner;

public class PruebaMetodos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		long dni = 56321122l;
		System.out.println(FuncionesMatematicas.letraNif(dni));
		Date fecha = new Date();
		fecha.setTime(1000788777887774401l);
		System.out.println(FuncionesFechas.formateaFecha(fecha, "'Hoy es la fecha: 'dd/MMMMMMMMM/yyyy"));
		System.out.println("Introduce un número y te daré el siguiente primo:");
		long numero = scan.nextLong();
		// long sigPrimo = FuncionesMatematicas.siguientePrimo(numero);
		// System.out.printf("El siguiente primo a %d es %d", numero, sigPrimo);
		System.out.printf("El número %d tiene %d dígitos.\n", numero, FuncionesMatematicas.digitos(numero));
		if (FuncionesMatematicas.esCapicua(numero)) {
			System.out.printf("El número %d es capicua.", numero);
		} else {
			System.out.printf("El número %d no es capicua.", numero);
		}
		
		Date ahora = new Date();
		System.out.printf("Hoy es %s", FuncionesFechas.obtenerDiaSemana(ahora));
	}

}
