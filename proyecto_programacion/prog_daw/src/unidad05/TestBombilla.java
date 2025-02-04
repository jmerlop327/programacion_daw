package unidad05;

import java.util.Iterator;
import java.util.Scanner;

import unidad05.exceptions.BombillaDatosIncorrectosException;

public class TestBombilla {

	public static void main(String[] args) throws BombillaDatosIncorrectosException {
		Scanner scanner = new Scanner(System.in);
		Bombilla bombillaOsram = new Bombilla("Osram", 60f, 4.75f);
		System.out.println(bombillaOsram);
		bombillaOsram.encender();
		System.out.println(bombillaOsram);

		Bombilla bombillaPorDefecto = new Bombilla();
		bombillaPorDefecto.setMarca("Osram");

		bombillaPorDefecto.setPrecio(5f);
		bombillaPorDefecto.setPotencia(60f);

		System.out.println(bombillaPorDefecto);

		Bombilla bombillaEncendida = new Bombilla("Phillips", 15.5f, 5f, "encendida");
		System.out.println(bombillaEncendida);

		if (bombillaOsram.equals(bombillaPorDefecto)) {
			System.out.println("Son iguales");
		} else {
			System.out.println("Son distintas");
		}
		// tienda. quiero incrementar el 10% el precio de todas las bombillas osram
		Bombilla[] bombillas = new Bombilla[3];
		bombillas[0] = bombillaOsram;
		bombillas[1] = bombillaPorDefecto;
		bombillas[2] = bombillaEncendida;
		for (Bombilla bombilla : bombillas) {
			if (bombilla.getMarca().equalsIgnoreCase("osram")) {				
				float precioMas10PorCiento = bombilla.getPrecio() * 1.1f;
				bombilla.setPrecio(precioMas10PorCiento);
			}
			//System.out.println(bombilla);
		}
		
		System.out.println(bombillaPorDefecto);
		
		

	}

}
