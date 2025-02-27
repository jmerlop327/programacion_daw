package unidad05.empleado;

public class TestEmpleado {

	public static void main(String[] args) {
		Directivo jefe = new Directivo("Matilde Moreno", 3);
		jefe.realizaTarea();
		jefe.realizaTarea();
		Oficial ofi = new Oficial("Marcos Jiménez" , "mecánica", "manipulador industrial");
		ofi.realizaTarea();
		ofi.realizaTarea();
		ofi.realizaTarea();
		ofi.realizaTarea();
		ofi.realizaTarea();
		System.out.println(jefe);
		System.out.println(ofi);
		Empleado[] empleados = new Empleado[2];
		empleados[0] = jefe;
		empleados[1] = ofi;
		for (Empleado empleado : empleados) {

			if (empleado instanceof Directivo) {
				System.out.println("Es un directivo");
			} else if ("Oficial".equals(empleado.getClass().getSimpleName())) {
				System.out.println("Es un oficial");
			} else {
				System.out.println("Es un tipo de empleado desconocido");
			}
		}
	}

}
