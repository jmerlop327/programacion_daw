package programame2025;

import java.util.Scanner;

public class Ninots {


	  static Scanner in;

	  public static boolean casoDePrueba() {

	    // LEER CASO DE PRUEBA
	    int numCasos = Integer.parseInt(in.next());

	    if (numCasos == 0) {
	      return false;
	    } else {
	      // CÓDIGO PRINCIPAL AQUÍ
	      // Procesa un único caso leyendo con
	      // in.next*()
	    	for (int i = 0; i < numCasos; i++) {
				String ninot = in.next();
				
			}
	      return true;
	    }

	  } // casoDePrueba

	  public static void main(String[] args) {

	    in = new java.util.Scanner(System.in);

	    while(casoDePrueba())
	      ;

	  } // main
}
