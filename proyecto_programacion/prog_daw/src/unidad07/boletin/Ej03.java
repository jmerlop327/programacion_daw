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
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduce el primer fichero del que quieres leer");
		final String rutaEntrada1 = "ficheros/" + scan.nextLine();
		System.out.println("Introduce el segundo fichero del que quieres leer");
		final String rutaEntrada2 = "ficheros/" + scan.nextLine();
		System.out.println("Introduce la ruta de salida");
		String rutaSalida = "ficheros/" + scan.nextLine() + "/";
		// Compruebo si los archivos tienen la misma extensión
		String nombreSalida = "";
		int posPunto1 = StringUtils.lastIndexOf(rutaEntrada1, ".");
		int posPunto2 = StringUtils.lastIndexOf(rutaEntrada2, ".");
		int posBarra1 = StringUtils.lastIndexOf(rutaEntrada1, "/");
		int posBarra2 = StringUtils.lastIndexOf(rutaEntrada2, "/");
		String ext1 = StringUtils.substring(rutaEntrada1, posPunto1);
		String ext2 = StringUtils.substring(rutaEntrada2, posPunto2);
		if (StringUtils.equalsIgnoreCase(ext1, ext2)) {
			// son iguales
			// System.out.println(StringUtils.substring(rutaEntrada1, posBarra1 +1,
			// posPunto1));
			String file1 = StringUtils.substring(rutaEntrada1, posBarra1 + 1, posPunto1);
			// System.out.println(StringUtils.substring(rutaEntrada2, posBarra2 +1,
			// posPunto2));
			String file2 = StringUtils.substring(rutaEntrada2, posBarra2 + 1, posPunto2);
			nombreSalida = file1 + "-" + file2 + "_copia" + ext1;
			rutaSalida += nombreSalida; 
			// System.out.println("nombre salida: " + nombreSalida);
			try {
				FileReader fr1 = new FileReader(rutaEntrada1);
				FileReader fr2 = new FileReader(rutaEntrada2);
				FileWriter fw = new FileWriter(rutaSalida);
				// leo el fichero 1 con el fr1 hasta el final y voy escribiendo en fw
				int caracterValue = fr1.read();
				while (caracterValue != -1) {
					fw.write(caracterValue);
					caracterValue = fr1.read();
				}
				// leo el fichero 2 con el fr2 hasta el final y voy escribiendo en fw
				caracterValue = fr2.read();
				while (caracterValue != -1) {
					fw.write(caracterValue);
					caracterValue = fr2.read();
				}
				//cierro los ficheros para persistencia
				fr1.close();
				fr2.close();
				fw.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.err.println("Los ficheros no son compatibles");
		}

	}

}
