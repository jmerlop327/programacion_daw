package programame;

import java.util.Arrays;
import java.util.Scanner;

public class ejDDD {
	static Scanner in;

	public static void main(String[] args) {
		in = new Scanner(System.in);
		while (casoDePrueba())
			;
	}

	public static boolean casoDePrueba() {
		int numPalabras = Integer.parseInt(in.next());
		if (numPalabras == 0) {
			return false;
		}
		
		String[] palabras = new String[numPalabras];
		for (int i = 0; i < numPalabras; i++) {
			StringBuilder sb = new StringBuilder();
			sb.append(in.next());
			palabras[i] = sb.reverse().toString();
		}
		Arrays.sort(palabras);
		for (int i = 0; i < numPalabras; i++) {
			StringBuilder sb = new StringBuilder();
			sb.append(palabras[i]);
			if(i<numPalabras-1) {
				
				System.out.print(sb.reverse().toString()+ " "); 
			} else {
				System.out.print(sb.reverse().toString()); 
				
			}
		
		}
		System.out.println();
		return true;
	}
}
