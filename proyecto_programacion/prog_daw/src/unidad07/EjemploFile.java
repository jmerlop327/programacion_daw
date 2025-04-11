package unidad07;

import java.io.File;
import java.io.IOException;

public class EjemploFile {

	public static void main(String[] args) throws IOException {
		String archivo = "archivoRutaPorDefecto.txt";
		File f = new File(archivo);
		System.out.println("getPath -> " + f.getPath());
		System.out.println("getAbsolutePath -> " + f.getAbsolutePath());
		System.out.println("getCanonicalPath -> " + f.getCanonicalPath());
		File archivoVacio = new File("files/ejemplos/archivoVacio.txt");
		System.out.println("Borramos el archivo " + archivoVacio.getName());
		if (archivoVacio.delete()) {
			System.out.println("Archivo borrado correctamente");
		} else {
			System.out.println("ERROR. El archivo no se ha podido borrar.");
		}
		File ficheros = new File("ficheros");
		String[] ficherosArray = ficheros.list();
		for (int i = 0; i < ficherosArray.length; i++) {
			System.out.println(ficherosArray[i]);
		}
		
			
	}

}
