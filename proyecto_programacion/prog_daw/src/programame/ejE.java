package programame;

import java.util.Scanner;

public class ejE {
	static Scanner in;

	public static void main(String[] args) {
		in = new Scanner(System.in);
		while(casoDePrueba());
	}

	public static boolean casoDePrueba() {
		int helio = in.nextInt();
		int globos = in.nextInt();
		int minAcum = 0;
		int maxAcum = 0;
		if(helio == 0 && globos == 0) {
			return false;
		}
		for (int i=0;i<globos;i++) {
			int min = in.nextInt();
			int max = in.nextInt();
			minAcum+=min;
			maxAcum+=max;
		}
		if(helio >= minAcum && helio<=maxAcum) {
			System.out.println("SI");
		}else {
			System.out.println("NO");
			
		}
		return true;
	}
}
