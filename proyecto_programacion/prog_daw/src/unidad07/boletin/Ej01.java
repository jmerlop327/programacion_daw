package unidad07.boletin;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ej01 {

	public static void main(String[] args) {
		final String rutaEntrada = "ficheros/entrada.txt";
		File fileIn = new File(rutaEntrada);
		try {
			FileReader reader = new FileReader(fileIn);
			int caracterValue = reader.read();
			// char -1 es el EOF end of file. Fin de fichero
			// 10 13 saltos de linea
			String linea = "";
			while (caracterValue != -1) {
				if ((caracterValue == 10 || caracterValue == 13) && linea.length() > 0) {
					System.out.println(linea);
					linea = "";
				} else if (caracterValue != 10 || caracterValue != 13) {
					linea += (char) caracterValue;
				}
				caracterValue = reader.read();
			}
			if (linea.length() > 0) {
				System.out.println(linea);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
