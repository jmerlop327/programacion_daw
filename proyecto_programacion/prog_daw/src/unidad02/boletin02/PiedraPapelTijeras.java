package unidad02.boletin02;

import java.util.Scanner;
/**
 * Juego de Piedra, papel o tijeras
 */
public class PiedraPapelTijeras {

	public static void main(String[] args) {
		// opción 0
		final String PIEDRA = "PIEDRA";
		// opción 1
		final String PAPEL = "PAPEL";
		// opción 2
		final String TIJERAS = "TIJERAS";
		Scanner scan = new Scanner(System.in);
		boolean empate = false;
		boolean entradaCorrecta = true;
		String salida = "";
		System.out.println("Bienvenido al juego Piedra, papel o tijeras.");
		do {
			// la CPU tiene las opciones 0 1 y 2
			int jugadaCpu = (int)(Math.random()*3);
			empate = false;
			System.out.println("Elige tu opción. Escribe \"Piedra\", \"papel\" o \"tijeras\"");
			String jugadaPlayerCadena = scan.nextLine();
			jugadaPlayerCadena = jugadaPlayerCadena.toUpperCase();
			int jugadaPlayer = -1;
			
			switch (jugadaPlayerCadena) {
			case PIEDRA:
				jugadaPlayer = 0;
				if (jugadaPlayer == jugadaCpu) {
					empate = true;
				} else {
					if (jugadaCpu == 2) {
						salida = "Has ganado! Tu elección fue " + PIEDRA + " y la de la CPU fue " + TIJERAS + ".";
					} else {
						salida = "Has perdido! Tu elección fue " + PIEDRA + " y la de la CPU fue " + PAPEL + ".";
					}
				}
				break;
			case PAPEL:
				jugadaPlayer = 1;
				if (jugadaPlayer == jugadaCpu) {
					empate = true;
				} else {
					if (jugadaCpu == 0) {
						salida = "Has ganado! Tu elección fue " + PAPEL + " y la de la CPU fue " + PIEDRA + ".";
					} else {
						salida = "Has perdido! Tu elección fue " + PAPEL + " y la de la CPU fue " + TIJERAS + ".";
					}
				}
				break;
			case TIJERAS:
				jugadaPlayer = 2;
				if (jugadaPlayer == jugadaCpu) {
					empate = true;
				} else {
					if (jugadaCpu == 1) {
						salida = "Has ganado! Tu elección fue " + TIJERAS + " y la de la CPU fue " + PAPEL + ".";
					} else {
						salida = "Has perdido! Tu elección fue " + TIJERAS + " y la de la CPU fue " + PIEDRA + ".";
					}
				}
				break;
			default:
				//El usuario no ha introducido una opción correcta
				entradaCorrecta = false;
				System.out.println("Has introducido una opción incorrecta. Vuelve a probar");
				break;
			}
			if (empate) {
				System.out.println("Empate! La CPU y tú elegisteis " + jugadaPlayerCadena);
			}
		} while (empate || !entradaCorrecta);
		scan.close();
		System.out.println(salida);		
	}
}
