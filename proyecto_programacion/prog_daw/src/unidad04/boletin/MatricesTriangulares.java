package unidad04.boletin;

import java.util.Scanner;

//https://aceptaelreto.com/problem/statement.php?id=160
public class MatricesTriangulares {

	// Esquema de la entrada: caso de prueba que marca el final

	static Scanner in;

	public static boolean casoDePrueba() {

	    // LEER CASO DE PRUEBA
	    int dim = in.nextInt();

	    if (dim == 0) {
	      return false;
	    } else {
	      // CÓDIGO PRINCIPAL AQUÍ
	      int[][] matriz = new int[dim][dim];
	      for (int i = 0; i < dim; i++) {
	    	  for (int j = 0; j < dim; j++) {
		    	  matriz[i][j] = in.nextInt();
		      }
	      }
	      return true;
	    }

	  } // casoDePrueba

	public static void main(String[] args) {

		in = new Scanner(System.in);

		while (casoDePrueba())
			;

	} // main

}
