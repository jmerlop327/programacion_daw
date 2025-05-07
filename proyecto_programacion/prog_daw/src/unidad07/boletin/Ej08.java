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

public class Ej08 {

	public static void main(String[] args) {
		// Linea de comandos
		// preparar la ruta para ficheros/Ej08
		// java Ej08.java origen1.txt origen2.txt destino.txt

		String rutaOrigen1 = "ficheros/Ej08/" + args[0];// origen1.txt
		String rutaOrigen2 = "ficheros/Ej08/" + args[1];// origen2.txt
		String rutaDestino = "ficheros/Ej08/" + args[2];// destino.txt

		// Prueba rutas
		File fileIn = new File(rutaOrigen1);
		System.out.println("ruta fichero origen" + fileIn.getAbsolutePath());

		try {
			BufferedReader br1 = new BufferedReader(new FileReader(rutaOrigen1));
			BufferedReader br2 = new BufferedReader(new FileReader(rutaOrigen2));
			BufferedWriter bw = new BufferedWriter(new FileWriter(rutaDestino));
			String linea1 = br1.readLine();
			String linea2 = br2.readLine();
			boolean sigue1 = null != linea1 ? true : false;
			//simulando operador ternario
//			boolean sigue2 = false;
//			if (null != linea2) {
//				sigue2 =true;
//			}
			boolean sigue2 = null != linea2 ? true : false;
			while (sigue1 || sigue2) {
				if (sigue1) {
					bw.write(linea1);
					bw.write("\n");
					linea1 = br1.readLine();
					if (null == linea1) {
						sigue1 = false;
						br1.close();
					}
				}
				if (sigue2) {
					bw.write(linea2);
					bw.write("\n");
					linea2 = br2.readLine();
					if (null == linea2) {
						sigue2 = false;
						br2.close();
					}
				}
			}
			bw.close();
		} catch (FileNotFoundException e) {
			System.err.println("No se encuentra alguno de los archivos");
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}

	}

}
