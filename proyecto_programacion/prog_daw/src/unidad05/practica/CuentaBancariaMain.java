package unidad05.practica;

import unidad05.persona.Persona;

public class CuentaBancariaMain {

	public static void main(String[] args) {
		Banco bbva = new Banco("BBVA");
		Persona juan = new Persona("Juan", "Pérez");
		Persona maria = new Persona("María", "Gómez");
		Persona amparo = new Persona("Amparo", "García");
		CuentaAhorro juanCuenta = new CuentaAhorro(juan, 1000f);
		CuentaCorrientePersonal mariaCuenta = new CuentaCorrientePersonal(maria, 1000f, "Netflix, Jazztel");
		CuentaCorrienteEmpresa amparoCuenta = new CuentaCorrienteEmpresa(amparo, 100000f, "Netflix, Jazztel", 50f, 3000f);
		bbva.anadirCuenta(juanCuenta);
		bbva.anadirCuenta(mariaCuenta);
		bbva.anadirCuenta(amparoCuenta);
		bbva.listadoCuentas();
		System.out.println("----------------");
//		bbva.mostrarDatosCuentaPorDni(juan.getDni());
//		bbva.ingresarCuenta(juan.getDni(), 300f);
//		bbva.ingresarCuenta(juanCuenta.getIban(), 200f);

	}

}
