package unidad05.practica;

public class Banco {
	private static final String REGEX_IBAN = "ES[0-9]{22}";
	private static final String REGEX_DNI = "[0-9]{8}[A-Z]";
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
				} else if (cuentaBancaria instanceof CuentaCorrientePersonal) {
					CuentaCorrientePersonal cuentaCorrPers = (CuentaCorrientePersonal) cuentaBancaria;
					cuentaCorrPers.mostrarInfo();
				} else if (cuentaBancaria instanceof CuentaCorrienteEmpresa) {
					CuentaCorrienteEmpresa cuentaCorrEmp = (CuentaCorrienteEmpresa) cuentaBancaria;
					cuentaCorrEmp.mostrarInfo();
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

	public void ingresarCuenta(String dniOrIban, float cantidad) {
		CuentaBancaria cb = buscarCuentaPorDniIban(dniOrIban);
		if (null != cb) {
			cb.ingresar(cantidad);
			System.out.println("Ingreso de efectivo ejecutado correctamente.");
		} else {
			System.out.println("No se ha introducido un DNI o un IBAN correcto");
		}

	}

	public void retirarCuenta(String dniOrIban, float cantidad) {
		CuentaBancaria cb = buscarCuentaPorDniIban(dniOrIban);
		if (null != cb) {
			cb.retirar(cantidad);
			System.out.println("Retirada de efectivo ejecutada correctamente.");
		} else {
			System.out.println("No se ha introducido un DNI o un IBAN correcto");
		}

	}

	private CuentaBancaria buscarCuentaPorDniIban(String dniOrIban) {
		CuentaBancaria cuenta = null;
		boolean encontrada = false;
		int i = 0;
		while (!encontrada && i < this.cuentas.length) {
			CuentaBancaria cuentaBancariaActual = this.cuentas[i];
			if (null != cuentaBancariaActual && dniOrIban.matches(REGEX_DNI)) {
				if (dniOrIban.equalsIgnoreCase(cuentaBancariaActual.getTitular().getDni())) {
					cuenta = cuentaBancariaActual;
					encontrada = true;
				}
			} else if (null != cuentaBancariaActual && dniOrIban.matches(REGEX_IBAN)) {
				if (dniOrIban.equalsIgnoreCase(cuentaBancariaActual.getIban())) {
					cuenta = cuentaBancariaActual;
					encontrada = true;
				}
			}

			i++;
		}
		if (!encontrada) {
			System.out.println("No se ha encontrado la cuenta asociada al dni o iban " + dniOrIban);
		}
		return cuenta;
	}

	public Float obtenerSaldo(String dniOrIban) {
		CuentaBancaria cb = buscarCuentaPorDniIban(dniOrIban);
		Float saldo = null;
		if (null != cb) {
			saldo = cb.getSaldo();
		}
		return saldo;
	}

}
