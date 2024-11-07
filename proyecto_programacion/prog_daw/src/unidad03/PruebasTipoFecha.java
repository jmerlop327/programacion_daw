package unidad03;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class PruebasTipoFecha {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		// PRUEBAS CON EL TIPO Calendar
		Calendar cal = Calendar.getInstance();
		Date fechaAct = new Date();
		Date fechaActCal = cal.getTime();
		System.out.println(fechaAct);
		System.out.println(fechaActCal);
		//dia de la semana con date, tengo que usar simpledateformat
		SimpleDateFormat sdf0 = new SimpleDateFormat("EEEEEEEEE");
		System.out.println(sdf0.format(fechaAct));
		// dia de la semana con calendar
		System.out.println(cal.get(Calendar.DAY_OF_WEEK));
		System.out.println(cal.get(Calendar.MONTH));
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		// PRUEBAS CON EL TIPO Date
		Date fechaActual = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdf2 = new SimpleDateFormat("'Hoy es' EEEEEEEEE dd 'de' MMMMM 'de' yyyy");
		// 05/11/2024
		String fechaString = scan.nextLine();
		try {
			Date fechaUsuario = convierteCadenaAFecha(fechaString, "dd/MM/yyyy");
			
			System.out.println(fechaUsuario);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		System.out.println("fecha con toString por defecto: " + fechaActual);
		System.out.println("fecha con simpledateformat: " + sdf.format(fechaActual));
		System.out.println("fecha con simpledateformat2: " + sdf2.format(fechaActual));
		
		long milisegFechaAct = fechaActual.getTime();
		System.out.println("milisec: " + milisegFechaAct);
		long anio = 1000l * 60 * 60 * 24 * 365;
		System.out.println(anio);
		long anios = milisegFechaAct / anio;
		System.out.println("años: " + anios);
		
		long diezAnios = 10l * anio;
		Date fecha1970 = new Date(1l);
		
		fecha1970.setTime(fecha1970.getTime() + diezAnios);
		System.out.println(fecha1970);
		
		
		if (fechaActual.equals(fecha1970)) {
			System.out.println("las fechas son iguales");
		} else {
			System.out.println("las fechas son diferentes");
		}

	}
	
	public static Date convierteCadenaAFecha(String cadenaFecha, String formato) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(formato);
		Date fechaOut = null;
		try {
			fechaOut = sdf.parse(cadenaFecha);
		} catch (ParseException e) {
			System.err.println("El formato de la fecha es incorrecto");
			throw new ParseException("El formato de la fecha es incorrecto",1);
		}
		return fechaOut;
	}

}
