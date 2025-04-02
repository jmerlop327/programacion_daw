package unidad06.equipo;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import unidad05.util.Utilidades;
import unidad05.util.UtilidadesParametroTipoIncorrectoException;

public class TestEquipo {
	static final byte NUM_EQUIPOS = 20;
	static Set<Equipo> equipos = new HashSet<Equipo>();

	public static void main(String[] args) throws EquipoCategoriaNoValidaException, EquipoCifNoValidoException {
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
		equipos.add(tigres);
		equipos.add(leones);
		equipos.add(leones);
		equipos.add(aguilas);
		equipos.add(dragones);
		equipos.add(lobos);
		equipos.add(pumas);
		equipos.add(halcones);
		equipos.add(toros);
		equipos.add(osos);
		equipos.add(caimanes);
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
			int opcion = -1;
			boolean opcionNoNumerica = false;
			String msgError = "";
			try {
				opcion = Utilidades.dameEntero();
			} catch (UtilidadesParametroTipoIncorrectoException e) {
				opcionNoNumerica = true;
				msgError = e.getMessage();
			}
			switch (opcion) {
			case 1:
				int i = Equipo.getNumeroEquipos();
				if (equipos.size() > i) {
					System.out.println("Vamos a crear un equipo:");
					Equipo eq = dameEquipo();
					if (null != eq) {
						equipos.add(eq);
					} else {
						System.err.println("No se puede añadir el equipo porque los datos no son correctos.");
					}
				} else {
					System.err.println("No se pueden añadir equipos porque no hay plazas disponibles");
				}
				break;
			case 2:
				try {
					modificarEquipo();
				} catch (UtilidadesParametroTipoIncorrectoException e) {
					System.out.println("Los datos introcidos no son correctos");
				} catch (EquipoCategoriaNoValidaException e) {
					System.out.println("La categoría introcida no es correcta");
				} catch (EquipoCifNoValidoException e) {
					System.out.println("El CIF introcido no es correcto");
				}
				break;
			case 3:
				try {
					eliminarEquipo();
				} catch (UtilidadesParametroTipoIncorrectoException e) {
					System.out.println("Los datos introcidos no son correctos");
				}
				break;
			case 4:
				mostrarEquipos();
				break;
			case 5:
				System.out.println("Hasta la próxima!");
				salir = true;
				break;
			default:
				if (opcionNoNumerica) {
					System.err.println(msgError + ". Elija una opción del menú");
				} else {
					System.err.println("La opción elegida no es correcta. Elija una opción del menú");
				}
				break;
			}
		} while (!salir);

	}

	/**
	 * @param equipos
	 */
	private static void mostrarEquipos() {
		System.out.println("Listado de equipos");
		int indice = 1;
		for (Equipo eq : equipos) {
			if (null != eq) {
				System.out.println("\t" + indice++ + ". " + eq + "\n");
			}
		}
	}

	/**
	 * @param equipos
	 * @throws UtilidadesParametroTipoIncorrectoException
	 * @throws EquipoCategoriaNoValidaException
	 * @throws EquipoCifNoValidoException
	 */
	private static void eliminarEquipo()
			throws UtilidadesParametroTipoIncorrectoException {
		System.out.println("Vamos a eliminar un equipo");
		Equipo eqComp = dameEquipoComparacion();
		Equipo eqBorrar = obtenerEquipo(eqComp);
		System.out.println("Está seguro? (Sí/No");
		if(null != eqBorrar && Utilidades.dameSiNo()) {
			equipos.remove(eqBorrar);
			Equipo.decrementarEquipos();
			System.out.println("El equipo se ha eliminado correctamente");
		} else {
			//No borramos
			System.out.println("Se ha cancelado la eliminación del equipo o el equipo no existe");
		}
	}

	/**
	 * @param equipos
	 * @throws UtilidadesParametroTipoIncorrectoException
	 * @throws EquipoCategoriaNoValidaException
	 */
	private static Equipo obtenerEquipo(Equipo eq) {
		Iterator<Equipo> itEquipo = equipos.iterator();
		Equipo equipo = null;
		boolean encontrado = false;
		while (!encontrado && itEquipo.hasNext()) {
			Equipo equipoActual = itEquipo.next();
			if (eq.getNombre().equalsIgnoreCase(equipoActual.getNombre())) {
				encontrado = true;
			}
		}
		
		return equipo;
	}

	private static Equipo dameEquipo() {
		Equipo eq = null;
		try {
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
			eq = new Equipo(nombre, cif, fechaFund, masCien, cat);
		} catch (UtilidadesParametroTipoIncorrectoException e) {
			System.out.println("Los datos no son correctos");
		} catch (EquipoCategoriaNoValidaException e) {
			System.out.println("La categoría no es válida");
		} catch (EquipoCifNoValidoException e) {
			System.out.println("El CIF del equipo no es válid0");
		}
		return eq;

	}

	private static Equipo dameEquipoComparacion() throws UtilidadesParametroTipoIncorrectoException {
		System.out.println("Introduce el nombre del equipo");
		String nombre = Utilidades.dameCadena();
		Equipo eq = new Equipo();
		eq.setNombre(nombre);
		return eq;
	}

	private static void modificarEquipo() throws UtilidadesParametroTipoIncorrectoException,
			EquipoCategoriaNoValidaException, EquipoCifNoValidoException {
		System.out.println("Vamos a modificar un equipo");
		Equipo eqComp = dameEquipoComparacion();
		Equipo eq = obtenerEquipo(eqComp);
		System.out.println("""
				Elige la opción deseada:
				1. Modificar nombre
				2. Modificar cif
				3. Modificar fecha de fundación
				4. Modificar número de abonados
				5. Modificar categoría
				6. Cancelar
				Opción:""");
		int opcion = -1;
		boolean opcionNoNumerica = false;
		String msgError = "";
		try {
			opcion = Utilidades.dameEntero();
		} catch (UtilidadesParametroTipoIncorrectoException e) {
			opcionNoNumerica = true;
			msgError = e.getMessage();
		}
		switch (opcion) {
		case 1:
			System.out.println("Dame el nuevo nombre:");
			String nombre = Utilidades.dameCadena();
			eq.setNombre(nombre);
			System.out.println("Nombre cambiado con éxito");
			break;
		case 2:
			System.out.println("Dame el nuevo cif:");
			String cif = Utilidades.dameCadena();
			eq.setCif(cif);
			System.out.println("CIF cambiado con éxito");
			break;
		// TODO: completar menu
		default:
			if (opcionNoNumerica) {
				System.err.println(msgError + ". Elija una opción del menú");
			} else {
				System.err.println("La opción elegida no es correcta. Elija una opción del menú");
			}
			break;
		}
	}
}
