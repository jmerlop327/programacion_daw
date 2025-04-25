package unidad07.boletin;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

// lee el fichero binario del ejercicio Ej06
public class Ej06b {

	public static void main(String[] args) {
		// DataInputStream.read() lanza EOFException cuando llega al final
		File f = new File("ficheros/primos.dat");
		// try-with-resources
		try (FileInputStream fos = new FileInputStream(f)) {
			DataInputStream dos = new DataInputStream(fos);
			while (true) {
				System.out.println(dos.readLong());
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EOFException e) {
			System.out.println("Fin del fichero");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
