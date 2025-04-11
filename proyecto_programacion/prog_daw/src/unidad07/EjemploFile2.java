package unidad07;

import java.io.File;
import java.io.IOException;

public class EjemploFile2 {

	public static void main(String[] args) {
		String ruta = "files/ejemplos";
		String archivo = "archivoVacio.txt";
		File f = new File(ruta + "/" + archivo);
		File fRuta = new File(ruta);
		if (f.exists()) {
			System.out.println("El archivo existe");
		} else {
			System.out.println("El archivo no existe, lo creamos");
			try {
				if (!fRuta.exists()) {
					fRuta.mkdirs();
				}
				f.createNewFile();
				System.out.println("Archivo creado correctamente");
			} catch (IOException e) {
				System.out.println("ERROR. El archivo no ha podido crearse.");
			}
		}
	}

}
