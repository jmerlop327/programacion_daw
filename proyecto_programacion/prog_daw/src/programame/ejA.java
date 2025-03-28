package programame;

import java.util.Scanner;

public class ejA {
	static Scanner in;

	public static void main(String[] args) {
		in = new Scanner(System.in);
		int numCasos = in.nextInt();
		for (int i = 0; i < numCasos; i++) {
			casoDePrueba();
		}
	}

	public static boolean casoDePrueba() {
		int num = in.nextInt();
		int min = num;
		int max = num;
		while (true) {
			if (esHarshad(num)) {
				if (esHarshad(min)) {
					min--;
				}
				if (esHarshad(max)) {
					max++;
				}
				if (!esHarshad(min) && !esHarshad(max)) {
					break;
				}
			} else {
				if (!esHarshad(min)) {
					min--;
				}
				if (!esHarshad(max)) {
					max++;
				}
				if (esHarshad(min) && esHarshad(max)) {
					break;
				}
			}
		}
		min++;
		max--;
		System.out.println(min + " " + max);
		return true;
	}

	private static boolean esHarshad(int num) {
		if (num == 0) {
			return false;
		}
		String numStr = "" + num;
		long suma = 0;
		for (char cifra : numStr.toCharArray()) {
			int cifraInt = Integer.parseInt("" + cifra);
			suma += cifraInt;
		}
		if (num % suma == 0) {
			return true;
		}
		return false;
	}
}
