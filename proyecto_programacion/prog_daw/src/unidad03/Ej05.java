package unidad03;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Ej05 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce tu fecha de nacimiento con formato \"dd-mm-aaaa\"");
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		
		String input = sc.nextLine();
		if (input.length() != 10) {
			System.err.println("El formato introducido no es correcto, debes introducir la fecha con formato \"dd-mm-aaaa\"");
		} else {
			try {
				Date fechaNacDate = sdf.parse(input);
				Calendar fechaAct = Calendar.getInstance();
				
				Calendar fechaNac = Calendar.getInstance();
				fechaNac.setTime(fechaNacDate);
				
				// Establecemos el año actual a la fecha de nacimiento
				Calendar fechaCumple = Calendar.getInstance();
				fechaCumple.setTimeInMillis(fechaNac.getTimeInMillis());;
				fechaCumple.set(Calendar.YEAR, fechaAct.get(Calendar.YEAR));
				if (fechaCumple.before(fechaAct)) {
					//el cumple de este año ya pasó
					fechaCumple.add(Calendar.YEAR, 1);
				}
				
				long milis = fechaCumple.getTimeInMillis() - fechaAct.getTimeInMillis();
				int dias = (int) (1 + milis / (1000l * 60 * 60 * 24));
				System.out.printf("Quedan %d días para tu próximo cumpleaños.", dias);
				String diaCumple = sdf.format(fechaCumple.getTime());
				String diaNac = sdf.format(fechaNac.getTime());
				System.out.printf("Tu próximo cumpleaños es el día %s", diaCumple );
				System.out.printf("\nNaciste el día %s", diaNac );
				
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
