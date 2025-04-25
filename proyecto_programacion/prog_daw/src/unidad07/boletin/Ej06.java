package unidad07.boletin;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import unidad03.boletin.FuncionesMatematicas;

//6. Escribe un programa que guarde en un fichero con nombre primos.dat
// los números primos que hay entre 1 y 500. Con DataOutputStream
public class Ej06 {

	public static void main(String[] args) {
		File f = new File("ficheros/primos.dat");
		// try-with-resources
		try (FileOutputStream fos = new FileOutputStream(f)) {
			DataOutputStream dos = new DataOutputStream(fos);
			long indice = 0;
			boolean fin = false;
			while (!fin) {
				// Devuelve el siguiente número primo al número pasado por párametro
				long primo = FuncionesMatematicas.siguientePrimo(indice);
				if (primo < 500) {					
					dos.writeLong(primo);
					fin = true;
				}
				indice = primo;
			}
			System.out.println("Operación terminada!");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
