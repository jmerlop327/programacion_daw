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
			//read() lee un caracter del fichero y devuelve su código ascii
			int caracterValue = reader.read();
			// char -1 es el EOF end of file. Fin de fichero
			// 10 13 saltos de linea
			String linea = "";
			while (caracterValue != -1) {
				if (caracterValue != 10 && caracterValue != 13 && caracterValue != 32) {
					linea += (char) caracterValue;
				} else if (!"".equals(linea) && caracterValue != 32) {
					System.out.println(linea);
					linea = "";
				}
				caracterValue = reader.read();
			}
			System.out.println(linea);
			reader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
