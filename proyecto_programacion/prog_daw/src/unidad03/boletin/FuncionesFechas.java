package unidad03.boletin;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class FuncionesFechas {

	/**
	 * Devuelve el día de la semana de una fecha dada
	 * 
	 * @param fecha
	 * @return dia
	 */
	public static String obtenerDiaSemana(Calendar fecha) {
		String dia = "";
		switch (fecha.get(Calendar.DAY_OF_WEEK)) {
		case 1:
			dia = "domingo";
			break;
		case 2:
			dia = "lunes";
			break;
		case 5:
			dia = "jueves";
			break;
		// TODO:Completar con el resto de los días de la semana
		default:
			break;
		}
		return dia;
	}

	/**
	 * Devuelve el día de la semana de una fecha dada
	 * 
	 * @param fecha
	 * @return dia
	 */
	public static String obtenerDiaSemana(Date fecha) {
		Calendar fechaCal = Calendar.getInstance();
		fechaCal.setTime(fecha);
		String dia = obtenerDiaSemana(fechaCal);
		return dia;
	}

	/**
	 * Devuelve true si la fecha del primer parámetro es anterior al segundo
	 * 
	 * @param fecha
	 * @param fechaReferencia
	 * @return
	 */
	public static boolean esFechaPasada(Date fecha, Date fechaReferencia) {
		return fecha.before(fechaReferencia);
	}

	/**
	 * Devuelve true si la fecha del primer parámetro es anterior al segundo
	 * 
	 * @param fecha
	 * @param fechaReferencia
	 * @return
	 */
	public static boolean esFechaPasada(Calendar fecha, Calendar fechaReferencia) {
		return fecha.before(fechaReferencia);
	}

	/**
	 * Devuelve true si el año introducido por parámetro es un año bisiesto
	 * 
	 * @param anio
	 * @return esBisiesto
	 */
	public static boolean esBisiesto(int anio) {
		boolean esBisiesto = false;
		if (anio % 400 == 0 || (anio % 4 == 0 && anio % 100 != 0)) {
			esBisiesto = true;
		}
		return esBisiesto;
	}

	/**
	 * Formatea la fecha introducida con el formato pasado por parámetro
	 * 
	 * @param fecha
	 * @param formato
	 * @return fechaFormateada
	 */
	public static String formateaFecha(Date fecha, String formato) {
		SimpleDateFormat sdf = new SimpleDateFormat(formato);
		String fechaFormateada = sdf.format(fecha);
		return fechaFormateada;
	}

	/**
	 * Formatea la fecha introducida con el formato pasado por parámetro
	 * 
	 * @param fecha
	 * @param formato
	 * @return fechaFormateada
	 */
	public static String formateaFecha(Calendar fecha, String formato) {
		return formateaFecha(fecha.getTime(), formato);
	}

	public static int calcularEdad(Date fechaNac) {
		int edad = 0;
		//La fecha del cumpleaños en el año actual
		Date fechaCumple = pasarFechaAnioActual(fechaNac);
		//La fecha del cumpleaños en el año actual en Calendar
		Calendar fechaCumpleCal = Calendar.getInstance();
		fechaCumpleCal.setTime(fechaCumple);
		//La fecha de nacimiento en calendar
		Calendar fechaNacCal = Calendar.getInstance();
		fechaNacCal.setTime(fechaNac);
		//Hoy en calendar
		Calendar fechaActualCal = Calendar.getInstance();
		//Comparamos hoy con la fecha del cumple
		if (fechaCumpleCal.before(fechaActualCal)) {
			edad = fechaActualCal.get(Calendar.YEAR) - fechaNacCal.get(Calendar.YEAR);
		} else {
			edad = fechaActualCal.get(Calendar.YEAR) - fechaNacCal.get(Calendar.YEAR) - 1;
		}
		return edad;
	}

	private static Date pasarFechaAnioActual(Date fecha) {
		Calendar fechaCal = Calendar.getInstance();
		int anioActual = fechaCal.get(Calendar.YEAR);
		fechaCal.setTimeInMillis(fecha.getTime());
		fechaCal.set(Calendar.YEAR, anioActual);
		Date fechaAnioActual = new Date();
		fechaAnioActual.setTime(fechaCal.getTimeInMillis());
		return fechaAnioActual;
	}

	/**
	 * Parsea la fecha pasada con el formato indicado en un objeto de tipo Date
	 * 
	 * @param fecha
	 * @param formato
	 * @return
	 * @throws ParseException
	 */
	public static Date parsearFechaDate(String fecha, String formato) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(formato);
		return sdf.parse(fecha);
	}

	/**
	 * Parsea la fecha pasada con el formato indicado en un objeto de tipo Calendar
	 * 
	 * @param fecha
	 * @param formato
	 * @return
	 * @throws ParseException
	 */
	public static Calendar parsearFechaCalendar(String fecha, String formato) throws ParseException {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(parsearFechaDate(fecha, formato));
		return calendar;
	}

	/**
	 * Parsea la fecha pasada con el formato indicado en un objeto de tipo LocalDate
	 * 
	 * @param fecha
	 * @param formato
	 * @return
	 */
	public static LocalDate parsearFechaLocalDate(String fecha, String formato) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern(formato);
		LocalDate ld = LocalDate.parse(fecha, dtf);
		return ld;
	}

	/**
	 * Parsea la fecha pasada con el formato indicado en un objeto de tipo LocalTime
	 * 
	 * @param fecha
	 * @param formato
	 * @return
	 */
	public static LocalTime parsearFechaLocalTime(String fecha, String formato) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern(formato);
		return LocalTime.parse(fecha, dtf);
	}

	public static boolean compruebaFechaLenient(String fecha, String formato) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(formato);
			sdf.setLenient(false); // Configuración estricta para validar días y meses correctamente

			// Intenta analizar la fecha
			Date date = sdf.parse(fecha);
			return true; // La fecha es válida
		} catch (ParseException e) {
			return false; // La fecha no es válida
		}
	}

	//dd-MM-yyyy
	//dd/MM/yyyy
	public static boolean compruebaFecha(String fecha) {
		boolean fechaCorrecta = true;
		int dia = Integer.parseInt(fecha.substring(0, 2));
		int mes = Integer.parseInt(fecha.substring(3, 5));
		int anio = Integer.parseInt(fecha.substring(6, 10));
		if (mes < 1 || mes > 12) {
			fechaCorrecta = false;
		} else {
			int diasCorrectos = 30;
			if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) {
				diasCorrectos = 31;
			} else if (mes == 2) {
				// Comprobar si es un año bisiesto
				if (esBisiesto(anio)) {
					diasCorrectos = 29;
				} else {
					diasCorrectos = 28;
				}
			}
			fechaCorrecta = dia >0 && dia <= diasCorrectos;
		}
		return fechaCorrecta;
	}
}
