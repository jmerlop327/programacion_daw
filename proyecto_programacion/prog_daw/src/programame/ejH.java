package programame;

import java.util.Arrays;
import java.util.Scanner;

public class ejH {
	static Scanner in;

	public static void main(String[] args) {
		in = new Scanner(System.in);
		while (casoDePrueba())
			;
	}

	public static boolean casoDePrueba() {
		int numLuces = in.nextInt();
		int config = in.nextInt();
		String[] luces = new String[numLuces];
		if (numLuces == 0 && config == 0) {
			return false;
		}
		if (numLuces == config) {
			Arrays.fill(luces, ".");
			for (int i = 0; i < numLuces; i++) {
				luces[i] = "O";
			}
			for (int i = 0; i < numLuces; i++) {
				System.out.print(luces[i]);
			}
			System.out.println();
			return true;
		}
		int empieza = 0;
		int contador = 0;
		for (int i = 1; i < config; i++) {
			contador++;
			if (contador == numLuces) {
				empieza++;
				contador = empieza;
			} else if (contador == numLuces && empieza==numLuces) {
				empieza=0;
			}
		}
		if(empieza==numLuces) {
			empieza = 0;
		}

		int lucesEncendidas = 0;
		int lim = numLuces;
		int conta = 0;
		boolean tope = false;
		for (int i = 1; i <= config; i++) {
			tope=false;
			conta++;
			lucesEncendidas++;
			if (lim < lucesEncendidas || tope) {
				lucesEncendidas = 0;
				tope = false;
			}
			if (conta % numLuces == 0) {
				lim--;
				conta = numLuces - lim;
				if (lim == 0) {
					lim = numLuces;
					tope = true;
				}
			}
		}
		Arrays.fill(luces, ".");
		for (int i = empieza; i < empieza + lucesEncendidas; i++) {
			luces[i] = "O";
		}
		for (int i = 0; i < numLuces; i++) {
			System.out.print(luces[i]);
		}
		System.out.println();

		return true;
	}
}
