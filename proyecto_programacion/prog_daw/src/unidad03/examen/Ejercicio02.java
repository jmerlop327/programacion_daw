package unidad03.examen;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio02 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Ingresar datos:");
		float consumoMedio = 0f;
		float combustibleDisp = 0f;
		try {
			System.out.println("Consumo medio (litros/100 km): ");
			consumoMedio = input.nextFloat();
			System.out.println("Combustible disponible (litros): ");
			combustibleDisp = input.nextFloat();
			comprobarDatos(consumoMedio, combustibleDisp);
			System.out.println("Cálculos:");
			System.out.printf("Consumo por kilómetro: %.2f l/km\n", UtilidadesExamen.consumoPorKm(consumoMedio));

			float rangoEstimado = UtilidadesExamen.rangoEstimado(consumoMedio, combustibleDisp);
			System.out.printf("Rango estimado de viaje: %.2f km\n", rangoEstimado);
			if (rangoEstimado < 100) {
				System.out.println("El rango es muy limitado, es recomendable repostar.");
			} else if (rangoEstimado >= 100 && rangoEstimado < 500) {
				System.out.println("El rango es adecuado para viajes cortos.");
			} else {
				System.out.println("El rango es suficiente para viajes largos.");
			}
			if (UtilidadesExamen.esEficiente(consumoMedio)) {
				System.out.println("El consumo es eficiente.");
			} else {
				System.out.println("El consumo no es eficiente. Debería estar entre 5 y 8 litros/100 km.");
			}

			input.close();
		} catch (InputMismatchException ime) {
			System.err.println("Los datos introducidos no son numéricos");
		} catch (IllegalArgumentException iae) {
			System.err.println("Los datos de consumo y combustible deben ser mayores a 0");
		}

	}

	private static void comprobarDatos(float consumo, float combustible) throws IllegalArgumentException {
		if (consumo < 0 || combustible < 0) {
			throw new IllegalArgumentException();
		}
	}
}
