package unidad05.examen;

public class TestGranja {

	public static void main(String[] args) {
		// Crear la granja Trafalgar
		Granja trafalgar = new Granja("Granja Trafalgar");
		// Crear y contratar 3 ganaderos
		Ganadero g1 = new Ganadero("Juan", "Pérez", 100, 10); // 10 animales
		Ganadero g2 = new Ganadero("Ana", "Gómez", 150, 20); // 20 animales
		Ganadero g3 = new Ganadero("Luis", "Martínez", 200, 15); // 15 animales 
		trafalgar.contratarTrabajador(g1);
		trafalgar.contratarTrabajador(g2);
		trafalgar.contratarTrabajador(g3);
		// Crear y contratar 3 agricultores con cosecha recolectada
		Agricultor a1 = new Agricultor("María", "López", 100, 500); // 500 kg 
		Agricultor a2 = new Agricultor("Pedro", "Sánchez", 120, 1000); // 1000 kg 
		Agricultor a3 = new Agricultor("Sofía", "Ruiz", 130, 750); // 750 kg 
		trafalgar.contratarTrabajador(a1);
		trafalgar.contratarTrabajador(a2);
		trafalgar.contratarTrabajador(a3);
		// Pruebas de los métodos
		// 1. Obtener y mostrar los ganaderos
		System.out.println("\nLista de ganaderos:");
		Ganadero[] ganaderos = trafalgar.getGanaderos();
		for (Ganadero g : ganaderos) {
			if (null != g) {				
				g.mostrarDatos();
			}
		}
		// 2. Obtener y mostrar los agricultores
		System.out.println("\nLista de agricultores:");
		Agricultor[] agricultores = trafalgar.getAgricultores();
		for (Agricultor a : agricultores) {
			if (null != a) {				
				a.mostrarDatos();
			}
		}
		// 3. Calcular y mostrar la producción total
		System.out.println("\nProducción total de la granja " + trafalgar.getNombre() + ": "
				+ trafalgar.calcularProduccion() + " unidades");
		System.out.println("--------------------------------");
		// 4. Mostrar los datos generales de la granja
		trafalgar.mostrarDatos();

	}

}
