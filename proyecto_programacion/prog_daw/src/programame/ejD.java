package programame;

import java.util.Scanner;

public class ejD {
	static Scanner in;

	public static void main(String[] args) {
		in = new Scanner(System.in);
		while(casoDePrueba());
	}

	public static boolean casoDePrueba() {
		int datos = in.nextInt();
		for (int i=0;i<datos;i++) {
			in.nextInt();
		}
		return true;
	}
}
