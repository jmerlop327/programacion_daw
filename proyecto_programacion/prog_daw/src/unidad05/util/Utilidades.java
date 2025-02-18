package unidad05.util;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;

public class Utilidades {
	public static final String LETRAS = "TRWAGMYFPDXBNJZSQVHLCKE";
	private static Scanner scan = new Scanner(System.in);

	/**
	 * Devuelve verdadero si el dni pasado por parámetro es un dni válido
	 * 
	 * @param dni
	 * @return dniCorrecto
	 */
	public static boolean checkDni(String dni) {
		boolean dniCorrecto = false;
		// 00000100F == 100F
		String dniPattern = "[0-9]{8}[" + LETRAS + LETRAS.toLowerCase() + "]";
		if (dni.matches(dniPattern)) {
			String numStr = dni.substring(0, 8);
			Integer num = Integer.parseInt(numStr);
			Character letraCorrecta = LETRAS.charAt(num % 23);
			Character letra = dni.toUpperCase().charAt(8);
			// otra opción -> Character letra = Character.toUpperCase(dni.charAt(8));
			if (letraCorrecta == letra) {
				dniCorrecto = true;
			}
		}
		return dniCorrecto;
	}

	/**
	 * Algoritmo de validación del CIF:
	 * - Primer carácter: Debe ser una letra válida (A, B, C, D, E, F, G, H, J, K,
	 * L, M, N, P, Q, R, S, U, V, W).
	 * - Dígitos centrales: 7 dígitos
	 * - Último dígito. Dígito de control: Puede ser un número o una letra (A, B, C,
	 * D, E, F, G, H, I, J)
	 * En realidad el dígito de control se calcula de una forma más compleja, pero
	 * así comprobamos formato
	 * 
	 * @param cif
	 * @return
	 */
	public static boolean checkCif(String cif) {
		final String PATRON_CIF = "[A-NP-SU-Wa-np-su-w][0-9]{7}[A-Ja-j0-9]";
		return cif.matches(PATRON_CIF);
	}

	/**
	 * Devuelve un número entero con el dato introducido por el usuario por consola
	 * 
	 * @return
	 * @throws UtilidadesParametroTipoIncorrectoException
	 */
	public static int dameEntero() throws UtilidadesParametroTipoIncorrectoException {
		try {
			return scan.nextInt();
		} catch (InputMismatchException e) {
			scan.nextLine();
			throw new UtilidadesParametroTipoIncorrectoException("Debe introducir un valor entero");
		}
	}

	/**
	 * Devuelve true si se introduce Si y false si se introduce no
	 * 
	 * @return
	 * @throws UtilidadesParametroTipoIncorrectoException
	 */
	public static boolean dameSiNo() throws UtilidadesParametroTipoIncorrectoException {
		try {
			String respuesta = scan.nextLine();
			if (StringUtils.equalsIgnoreCase(respuesta, "SÍ") || StringUtils.equalsIgnoreCase(respuesta, "SI")) {
				return true;
			} else if (StringUtils.equalsIgnoreCase(respuesta, "NO")) {
				return false;
			} else {
				throw new UtilidadesParametroTipoIncorrectoException("Debe introducir como respuesta Sí o No");
			}
		} catch (InputMismatchException e) {
			throw new UtilidadesParametroTipoIncorrectoException("Debe introducir como respuesta Sí o No");
		}
	}

	/**
	 * Devuelve un caracter
	 * 
	 * @return
	 * @throws UtilidadesParametroTipoIncorrectoException
	 */
	public static char dameChar() throws UtilidadesParametroTipoIncorrectoException {
		try {
			String respuesta = scan.nextLine();
			if (respuesta.length() == 1) {
				return respuesta.charAt(0);
			} else {
				throw new UtilidadesParametroTipoIncorrectoException("Debe introducir un único carácter");
			}
		} catch (InputMismatchException e) {
			throw new UtilidadesParametroTipoIncorrectoException("Debe introducir un único carácter");
		}
	}
	/**
	 * Devuelve una cadena de texto
	 * 
	 * @return cadena
	 * @throws UtilidadesParametroTipoIncorrectoException
	 */
	public static String dameCadena() throws UtilidadesParametroTipoIncorrectoException {
		final String PATTERN = "[a-zA-ZñÑáéíóúÁÉÍÓÚüÜ\s_0-9]+";
		try {
			String cadena = scan.nextLine().trim();
			if (!StringUtils.isBlank(cadena) && cadena.matches(PATTERN)) {
				return cadena;
			} else {
				throw new UtilidadesParametroTipoIncorrectoException("Debe introducir una cadena de texto válida");
			}
		} catch (InputMismatchException e) {
			throw new UtilidadesParametroTipoIncorrectoException("Debe introducir una cadena de texto válida");
		}
	}

	public static LocalDate dameFecha() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
