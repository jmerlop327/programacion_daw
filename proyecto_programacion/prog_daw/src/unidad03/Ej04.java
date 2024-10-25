package unidad03;

public class Ej04 {

	public static void main(String[] args) {
		int p = 0, n = 0;
		try {
			imprimePositivo(p);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		p = 5;
		try {
			imprimePositivo(p);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		p = -10;
		try {
			imprimePositivo(p);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			imprimeNegativo(n);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		n = 5;
		try {
			imprimeNegativo(n);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		n = -10;
		try {
			imprimeNegativo(n);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	private static void imprimePositivo(int p) throws Exception {
		if (p < 0) {
			throw new Exception("imprimePositivo solo puede imprimir números positivos");
		}
		System.out.println(p);
	}

	private static void imprimeNegativo(int n) throws Exception {
		if (n >= 0) {
			throw new Exception("imprimeNegativo solo puede imprimir números negativos");
		}
		System.out.println(n);
	}

}
