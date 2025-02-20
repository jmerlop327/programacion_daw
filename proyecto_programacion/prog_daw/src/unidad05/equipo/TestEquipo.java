package unidad05.equipo;

import java.time.LocalDate;

import unidad05.util.Utilidades;
import unidad05.util.UtilidadesParametroTipoIncorrectoException;

public class TestEquipo {

	public static void main(String[] args) throws UtilidadesParametroTipoIncorrectoException,
			EquipoCategoriaNoValidaException, EquipoCifNoValidoException {
		final byte NUM_EQUIPOS = 20;
		Equipo[] equipos = new Equipo[NUM_EQUIPOS];
		Equipo tigres = new Equipo("Tigres FC", "A12345678", LocalDate.of(1995, 3, 15), true, 'A');
		Equipo leones = new Equipo("Leones Rojos", "B98765432", LocalDate.of(1982, 7, 10), false, 'J');
		Equipo aguilas = new Equipo("Águilas Doradas", "C87654321", LocalDate.of(2005, 5, 22), true, 'I');
		Equipo dragones = new Equipo("Dragones Azules", "D23456789", LocalDate.of(1978, 11, 3), false, 'A');
		Equipo lobos = new Equipo("Lobos Negros", "E34567890", LocalDate.of(1999, 8, 30), true, 'J');
		Equipo pumas = new Equipo("Pumas Salvajes", "F45678901", LocalDate.of(2010, 2, 14), false, 'I');
		Equipo halcones = new Equipo("Halcones Verdes", "G56789012", LocalDate.of(1965, 6, 18), true, 'A');
		Equipo toros = new Equipo("Toros Bravos", "H67890123", LocalDate.of(2003, 12, 5), false, 'J');
		Equipo osos = new Equipo("Osos Polares", "I78901234", LocalDate.of(1988, 9, 9), true, 'I');
		Equipo caimanes = new Equipo("Caimanes del Sur", "J89012345", LocalDate.of(2015, 4, 25), false, 'A');
		equipos[0] = tigres;
		equipos[1] = leones;
		equipos[2] = aguilas;
		equipos[3] = dragones;
		equipos[4] = lobos;
		equipos[5] = pumas;
		equipos[6] = halcones;
		equipos[7] = toros;
		equipos[8] = osos;
		equipos[9] = caimanes;
		boolean salir = false;
		do {
			System.out.println("""
					Elige la opción deseada:
					1. Añadir equipo
					2. Modificar equipo
					3. Eliminar equipo
					4. Mostrar equipos
					5. Salir
					Opción:""");
			int opcion = Utilidades.dameEntero();
			switch (opcion) {
			case 1:
				boolean anadido = false;
				int i = 0;
				while (!anadido) {
					if (null == equipos[i]) {
						System.out.println("Vamos a crear un equipo:");
						equipos[i] = dameEquipo();
						anadido = true;
					}
					i++;
				}
				// Controlar si hay huecos disponibles para equipos
				if (!anadido) {
					System.err.println("No se pueden añadir equipos porque no hay plazas disponibles");
				}
				break;
			case 2:

				break;
			case 3:
				System.out.println("Vamos a eliminar un equipo");
				Equipo eqComp = dameEquipoComparacion();
				boolean eliminado = false;
				int index = 0;
				while (!eliminado && index < equipos.length) {
					Equipo equipoActual = equipos[index];
					if (null != equipoActual && equipoActual.equals(eqComp)) {
						equipos[index] = null;
						eliminado = true;
					}
					index++;
				}
				if (eliminado) {
					System.out.println("El equipo " + eqComp + " ha sido eliminado correctamente");
				} else {
					System.err.println("No se puede borrar el equipo " + eqComp
							+ " porque no se encuentra en la lista de equipos");
				}
				break;
			case 4:
				System.out.println("Listado de equipos");
				for (Equipo eq : equipos) {
					if (null != eq) {
						System.out.println(eq);
					}
				}
				break;
			case 5:
				System.out.println("Hasta la próxima!");
				salir = true;
				break;

			default:
				break;
			}
		} while (!salir);

	}

	private static Equipo dameEquipo() throws UtilidadesParametroTipoIncorrectoException,
			EquipoCategoriaNoValidaException, EquipoCifNoValidoException {
		System.out.println("Introduce el nombre del equipo");
		String nombre = Utilidades.dameCadena();
		System.out.println("Introduce el CIF del equipo");// B2367483B
		String cif = Utilidades.dameCadena();
		System.out.println("Introduce la fecha de fundación en formato dd/MM/yyyy");
		LocalDate fechaFund = Utilidades.dameFecha();
		System.out.println("Tiene el equipo más de 100 abonados (Sí/No)");
		boolean masCien = Utilidades.dameSiNo();
		System.out.println("Introduce la categoría en la que juega el equipo Infantil/Juvenil/Adulto (I/J/A)");
		char cat = Utilidades.dameChar();
		Equipo eq = new Equipo(nombre, cif, fechaFund, masCien, cat);
		return eq;
	}

	private static Equipo dameEquipoComparacion() throws UtilidadesParametroTipoIncorrectoException,
			EquipoCategoriaNoValidaException, EquipoCifNoValidoException {
		System.out.println("Introduce el nombre del equipo");
		String nombre = Utilidades.dameCadena();
		System.out.println("Introduce la categoría en la que juega el equipo Infantil/Juvenil/Adulto (I/J/A)");
		char cat = Utilidades.dameChar();
		LocalDate fecha = LocalDate.now();
		Equipo eq = new Equipo(nombre, "", fecha, true, cat);
		return eq;
	}

}
