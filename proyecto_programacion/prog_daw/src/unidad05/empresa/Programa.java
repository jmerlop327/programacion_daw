package unidad05.empresa;

public class Programa {

	public static void main(String[] args) {
		try {
			Empleado emp = new Empleado("Carmen", "Martínez García", "44072328G", 1800f);
			System.out.println(emp);
		} catch (EmpleadoInvalidoException e) {
			e.printStackTrace();
		}

	}

}
