package unidad05.practica;

import java.util.Random;

import unidad05.persona.Persona;

public abstract class CuentaBancaria implements Imprimible {
	private Persona titular;
	private String iban;
	private float saldo;

	public CuentaBancaria(Persona titular, float saldo) {
		this.titular = titular;
		this.iban = getRandomIban();
		this.saldo = saldo;
	}

	private String getRandomIban() {
		String iban = "ES";
		Random random = new Random();
		for (int i = 0; i < 22; i++) {
            iban += random.nextInt(10);
        }
		return iban;
	}

	public Persona getTitular() {
		return titular;
	}

	public void setTitular(Persona titular) {
		this.titular = titular;
	}

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	
	public void ingresar(float cantidad) {
        this.saldo += cantidad;
    }
	public void retirar(float cantidad) {
		this.saldo -= cantidad;
	}

	public void mostrarInfo() {
		StringBuilder sb = new StringBuilder();
		sb.append("---------\n");
		sb.append("Cuenta Bancaria\n");
		sb.append("IBAN: ").append(this.iban).append("\n");
		System.out.println(sb);
		this.titular.mostrarInfo();
		sb = new StringBuilder();
		sb.append("Saldo: ").append(this.saldo);
		System.out.println(sb);
	}
}
