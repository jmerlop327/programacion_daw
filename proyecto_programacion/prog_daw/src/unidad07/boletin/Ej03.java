package unidad07.boletin;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;

public class Ej03 {

	public static void main(String[] args) {
		//Scanner scan = new Scanner(System.in);
		//System.out.println("Introduce el fichero del que quieres leer");
		final String rutaEntrada1 = "ficheros/" + "A.txt";
		//System.out.println("Introduce el fichero del que quieres leer");
		final String rutaEntrada2 = "ficheros/" + "1.txt";
		//Compruebo si los archivos tienen la misma extensión
		String nombreSalida;
		int posPunto1 = StringUtils.lastIndexOf(rutaEntrada1, ".");
		int posPunto2 = StringUtils.lastIndexOf(rutaEntrada2, ".");
		int posBarra1 = StringUtils.lastIndexOf(rutaEntrada1, "/");
		int posBarra2 = StringUtils.lastIndexOf(rutaEntrada2, "/");
		String ext1 = StringUtils.substring(rutaEntrada1, posPunto1);
		String ext2 = StringUtils.substring(rutaEntrada2, posPunto2);
		if (StringUtils.equalsIgnoreCase(ext1, ext2)) {
			System.out.println("son iguales");
			System.out.println(StringUtils.substring(rutaEntrada1, posBarra1 +1, posPunto1));
			System.out.println(StringUtils.substring(rutaEntrada2, posBarra2 +1, posPunto2));
		}
		
		
	}

}
