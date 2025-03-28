package programame;

import java.util.Arrays;
import java.util.Scanner;

public class ejC {
	static Scanner in;

	public static void main(String[] args) {
		in = new Scanner(System.in);
		while (casoDePrueba())
			;
	}

	public static boolean casoDePrueba() {
		int autocares = in.nextInt();
		if (autocares == 0) {
			return false;
		}
		int[] gente = new int[autocares];
		for (int i = 0; i < autocares; i++) {
			gente[i] = in.nextInt();
		}
		int consultas = in.nextInt();
		for (int i = 0; i < consultas; i++) {
			int inicio = in.nextInt()-1;
			int fin = in.nextInt()-1;
			int numGente = 0;
			for (int j = inicio; j <= fin; j++) {
				numGente += gente[j];
			}
			System.out.println(numGente);
		}
		System.out.println("---");
		return true;
	}
}
