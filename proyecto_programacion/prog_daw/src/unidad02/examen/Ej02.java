package unidad02.examen;

public class Ej02 {

	public static void main(String[] args) {
		System.out.print("100");
		int impar = 0;
		for (int i = 99; i > 0; i--) {
			if (impar == 2 && i % 2 == 0) {
				System.out.print(", " +i);
				impar = 0;
			} else if (i % 2 != 0) {
				System.out.print(", " +i);
				impar++;
			}
		}

	}

}
