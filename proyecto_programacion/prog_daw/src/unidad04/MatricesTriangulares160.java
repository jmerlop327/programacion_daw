package unidad04;

import java.util.Scanner;

//https://aceptaelreto.com/problem/statement.php?id=160
public class MatricesTriangulares160 {

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
	      boolean trianguloSup = true;
	      boolean trianguloInf = true;
	      int i = 0;
	      while (i < dim && (trianguloInf || trianguloSup)) {
	    	  int j = 0;
	    	  while (j < dim && (trianguloInf || trianguloSup)) {
	    		  int elemento = matriz[i][j];
		    	  if (j > i && elemento != 0) {
		    		  trianguloSup = false;
		    	  }
		    	  if (i > j && elemento != 0) {
		    		  trianguloInf = false;
		    	  }
		    	  j++;
		      }
	    	  i++;
	      }
	      if (trianguloInf || trianguloSup) {
	    	  System.out.println("SI");
	      } else {
	    	  System.out.println("NO");
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
