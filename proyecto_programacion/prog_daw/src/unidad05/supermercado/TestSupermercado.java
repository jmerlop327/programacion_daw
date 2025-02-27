package unidad05.supermercado;

import java.util.Scanner;

public class TestSupermercado {

	public static void main(String[] args) {
		System.out.print("Introduce el nombre del cliente:");
		Scanner scanner = new Scanner(System.in);
		String cliente = scanner.nextLine();
		ProductoUnitario pu1 = new ProductoUnitario("Leche", "Productos Lácteos y huevos", 6, 0.8d);
		ProductoUnitario pu2 = new ProductoUnitario("Docena de Huevos", "Productos Lácteos y huevos", 1, 1.25d);
		ProductoUnitario[] products = new ProductoUnitario[2];
		products[0] = pu1;
		products[1] = pu2;
		double importeTotal = 0d;
		System.out.println("\nTICKET DE LA COMPRA \t Cliente: " + cliente);
		for (ProductoUnitario productoUnitario : products) {
			importeTotal += productoUnitario.getImporteTotal();
			productoUnitario.imprimir();
		}
		System.out.printf("\nIMPORTE TOTAL \t\t\t\t %.2f", importeTotal);
	}

}
