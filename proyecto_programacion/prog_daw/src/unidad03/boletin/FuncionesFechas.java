package unidad03.boletin;

import java.text.SimpleDateFormat;
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
	 * @param fecha
	 * @param formato
	 * @return fechaFormateada
	 */
	public static String formateaFecha(Calendar fecha, String formato) {
		return formateaFecha(fecha.getTime(), formato);
	}
}
