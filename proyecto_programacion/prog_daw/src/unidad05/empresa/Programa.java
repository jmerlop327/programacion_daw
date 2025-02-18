package unidad05.empresa;

public class Programa {

	public static void main(String[] args) {

		try {
			Empresa empresaIesT = new Empresa("IES Trafalgar", "B2367483B");
			Empleado empCarmen = new Empleado("Carmen", "Martínez García", "44072328G", 1800f);
			Empleado empManuel = new Empleado("Manuel", "Moreno Luján", "19964529T", 1625f);
			empresaIesT.anadirEmpleado(empManuel);
			empresaIesT.anadirEmpleado(empCarmen);
			empresaIesT.mostrarInfoEmpleados();
			System.out.println("Total de sueldos brutos: " + empresaIesT.sumaSueldoBrutoEmpleados());
			System.out.println("Total de sueldos netos: " + empresaIesT.sumaSueldoNetoEmpleados());
		} catch (EmpresaCompletaException e) {
			e.printStackTrace();
		} catch (EmpresaEmpleadoExistenteException e) {
			e.printStackTrace();
		} catch (EmpleadoInvalidoException e) {
			e.printStackTrace();
		} catch (EmpresaNoValidaException e) {
			e.printStackTrace();
		}

	}

}
