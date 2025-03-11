package unidad05.practica;

public class Banco {
	private CuentaBancaria[] cuentas;

	public CuentaBancaria[] getCuentas() {
		return cuentas;
	}

	// Constructor
	public Banco(String nombre) {
		this.nombre = nombre;
		this.cuentas = new CuentaBancaria[100];
	}

	// getters y setters
	public void setCuentas(CuentaBancaria[] cuentas) {
		this.cuentas = cuentas;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	private String nombre;

	public boolean anadirCuenta(CuentaBancaria cuenta) {
		boolean anadida = false;
		int i = 0;
		while (!anadida && i < this.cuentas.length) {
			if (null == this.cuentas[i]) {
				this.cuentas[i] = cuenta;
				anadida = true;
			}
			i++;
		}
		if (!anadida) {
			System.out.println("No se ha podido anadir la cuenta, no hay más espacio disponible en el banco");
		}
		return anadida;
	}

	public void listadoCuentas() {
		for (CuentaBancaria cuentaBancaria : this.cuentas) {
			if (null != cuentaBancaria) {
				if (cuentaBancaria instanceof CuentaAhorro) {
					CuentaAhorro cuentaAhorro = (CuentaAhorro) cuentaBancaria;
					cuentaAhorro.mostrarInfo();
				}
			}
		}

	}

	public void mostrarDatosCuentaPorDni(String dni) {
		boolean encontrada = false;
		int i = 0;
		while (!encontrada && i < this.cuentas.length) {
			if (null != this.cuentas[i] && dni.equalsIgnoreCase(this.cuentas[i].getTitular().getDni())) {
				mostrarDatosCuenta(this.cuentas[i]);
				encontrada = true;
			}
			i++;
		}
		if (!encontrada) {
			System.out.printf("No se ha podido encontrar la cuenta asociada al dni %s\n", dni);
		}

	}

	private void mostrarDatosCuenta(CuentaBancaria cuenta) {
		StringBuilder sb = new StringBuilder();
		sb.append("Cuenta Bancaria\n");
		sb.append("IBAN: ").append(cuenta.getIban()).append("\n");
		sb.append("Titular: ").append(cuenta.getTitular().getNombre()).append(" ")
				.append(cuenta.getTitular().getApellidos());
		sb.append("  Saldo: ").append(cuenta.getSaldo());
		System.out.println(sb);

	}

	public void ingresarCuenta(String dniOrIban, float f) {
		String regexIban = "ES[0-9]{22}";
		String regexDni = "[0-9]{8}[A-Z]";
		if (dniOrIban.matches(regexDni)) {
			buscarCuentaPorDni(dniOrIban);
		} else if (dniOrIban.matches(regexIban)) {
			buscarCuentaPorIban(dniOrIban);
		} else {
			System.out.println("No se ha introducido un DNI o un IBAN correcto");
		}

	}

}
