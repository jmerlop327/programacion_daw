package unidad05.util;

public class Utilidades {
	public static final String LETRAS = "TRWAGMYFPDXBNJZSQVHLCKE";

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
	 * 
	 * @param cif
	 * @return
	 */
	public static boolean checkCif(String cif) {
		//TODO: implementar checkCif
		return true;
	}
}
