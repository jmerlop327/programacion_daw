package unidad06.edificio;

import java.util.Scanner;

public class TestEdificio {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Edificio edif = new Edificio();
		while (true) {
			System.out.println("""
					Elige la opción deseada:
					1. Persona accede al edificio
					2. Persona abandona el edificio
					3. Persona accede a zona privada
					4. Persona abandona zona privada
					5. Registro de persona con acceso a zona privada
					6. Mostrar personas en el edificio
					7. Mostrar personas en la zona privada
										""");
			int opcion = scanner.nextInt();
			scanner.next();
			String dni = "";
			switch (opcion) {
			case 1:
				dni = scanner.nextLine();
				edif.acessoEdificio(dni);
				break;
			case 2:
				dni = scanner.nextLine();
				edif.salidaEdificio(dni);
				break;
			case 3:
				dni = scanner.nextLine();
				edif.acessoZonaVip(dni);
				break;
			case 4:
				dni = scanner.nextLine();
				edif.salidaZonaVip(dni);
				break;

			default:
				break;
			}
		}

	}

}
