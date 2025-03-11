package unidad05.practica;

import unidad05.persona.Persona;

public class CuentaBancariaMain {

	public static void main(String[] args) {
		Banco bbva = new Banco("BBVA");
		Persona juan = new Persona("Juan", "Perez");
		CuentaAhorro juanCuenta = new CuentaAhorro(juan, 1000);
		bbva.anadirCuenta(juanCuenta);
		bbva.listadoCuentas();
		System.out.println("----------------");
		bbva.mostrarDatosCuentaPorDni(juan.getDni());
		bbva.ingresarCuenta(juan.getDni(), 300f);
		bbva.ingresarCuenta(juanCuenta.getIban(), 200f);

	}

}
