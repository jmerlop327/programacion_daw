package unidad06;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TecladoRoto144List {

	static Scanner in;

	public static boolean casoDePrueba() {

		if (!in.hasNext())
			return false;
		else {
			String entrada = in.nextLine();
			List<Character> listaSalida = new ArrayList<Character>();
			int cursor = 0;
			for (int i = 0; i < entrada.length(); i++) {
				char caracterAct = entrada.charAt(i);
				switch (caracterAct) {
				case '3':
					// suprimir
                    if (cursor < listaSalida.size()) {
                        listaSalida.remove(cursor);
                    }
					break;
				case '+':
					// fin
					cursor = listaSalida.size();
					break;
				case '-':
					// inicio
					cursor = 0;
					break;
				case '*':
					// mueve cursor hacia la derecha
					if (cursor < listaSalida.size()) {
						cursor++;
					}
					break;
				default:
					listaSalida.add(cursor, caracterAct);
					cursor++;
					break;
				}
			}
			String salida = "";
			for (Character character : listaSalida) {
				salida += character;
			}
			System.out.println(salida);
			return true;
		}

	} // casoDePrueba

	public static void main(String[] args) {

		in = new java.util.Scanner(System.in);

		while (casoDePrueba())
			;

	} // main
}
