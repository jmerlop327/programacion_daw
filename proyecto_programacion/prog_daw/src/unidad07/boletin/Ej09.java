package unidad07.boletin;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ej09 {

	public static void main(String[] args) {
		String rutaIn = "ficheros/" + args[0];//palabras_in.txt
		//String rutaIn = "ficheros/palabras_in.txt";
		String rutaOut = "ficheros/" + args[1];//palabras_out.txt
		//String rutaOut = "ficheros/palabras_out.txt";
		File fileIn = new File(rutaIn);
		System.out.println("ruta" + fileIn.getAbsolutePath());
		List<String> listaPalabras = new ArrayList<String>();
		// try with resources
		try (BufferedReader br = new BufferedReader(new FileReader(rutaIn))) {
			String palabra = br.readLine();// devuelve string
			while (null != palabra) {
				// br.readLine() DEVUELVE NULL CUANDO LLEGAMOS AL FINAL DEL DOCUMENTOS
				listaPalabras.add(palabra);
				palabra = br.readLine();
			}
			br.close();
			// ordenar las palabras por orden natural. String implementa a Comparable
			Collections.sort(listaPalabras);
			// IMPORTANTE CERRAR LOS FICHEROS
			BufferedWriter bw = new BufferedWriter(new FileWriter(rutaOut));
			for (String string : listaPalabras) {
				// bw.write("cadena de texto")
				bw.write(string + "\n");
			}
			bw.close();
		} catch (FileNotFoundException e) {
			System.err.println("No se encuentra el archivo " + rutaIn);
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}

	}

}
