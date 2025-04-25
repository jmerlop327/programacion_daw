package unidad07.boletin;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ej02 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduce el fichero del que quieres leer");
		final String rutaEntrada = "ficheros/" + scan.nextLine();// entrada.txt
		System.out.println("Introduce el fichero en el que quieres escribir");
		final String rutaSalida = "ficheros/" + scan.nextLine();// salida.txt
		File fileIn = new File(rutaEntrada);
		File fileOut = new File(rutaSalida);
		try {
			FileReader fr = new FileReader(fileIn);
			FileWriter fw = new FileWriter(fileOut);
			int caracterValue = fr.read();
			while (caracterValue != -1) {
				Character character = Character.valueOf((char) caracterValue);
				if (Character.isUpperCase(character)) {
					character = Character.toLowerCase(character);
				} else {
					// lo contrario
					character = Character.toUpperCase(character);
				}

				// Escribo en el fichero de salida el caracter que corresponde al código ascii
				// pasado por parámetro
				fw.write((int) character);
				// otra opción para cambiar de may a min
				// if caracterValue está entre 65 y 90 sumo 32
				// if caracterValue está entre 97 y 122 resto 32
				// Problema. No controlo las letras distintas del rango A-Z a-z
				caracterValue = fr.read();
			}
			fr.close();
			fw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
