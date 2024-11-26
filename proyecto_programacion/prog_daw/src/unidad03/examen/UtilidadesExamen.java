package unidad03.examen;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class UtilidadesExamen {

	public static String obtenerHoraActual(Date now) {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		String hora = sdf.format(now);
		return hora;
	}

	public static String obtenerDiaSemana(Date now) {
		Calendar nowCal = Calendar.getInstance();
		nowCal.setTime(now);
		String dia = "Lunes";
		switch (nowCal.get(Calendar.DAY_OF_WEEK)) {
		case 1:
			dia = "Domingo";
			break;
		case 2:
			dia = "Lunes";
			break;
		case 3:
			dia = "Martes";
			break;
		// TODO: resto de días
		default:
			break;
		}
		return dia;

	}

	public static int obtenerDiasHastaVacas(Date now) {
		Date diaVacas = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		try {
			diaVacas = sdf.parse("20-12-2024");
		} catch (ParseException e) {
			throw new IllegalArgumentException("Valor de fecha de vacas no correcto");
		}
		long milisHastaVacas = diaVacas.getTime() - now.getTime();
		int diasHastaVacas = (int) (milisHastaVacas / (1000l * 60 * 60 * 24));
		return diasHastaVacas;
	}

	public static float consumoPorKm(float consumoMedio) {
		return consumoMedio / 100;
	}

	public static float rangoEstimado(float consumoMedio, float combustibleDisp) {
		float rangoEstimado = (combustibleDisp / consumoMedio) * 100;
		return rangoEstimado;
	}

	public static boolean esEficiente(float consumoMedio) {
		return consumoMedio >= 5 && consumoMedio <= 8;
	}

}
