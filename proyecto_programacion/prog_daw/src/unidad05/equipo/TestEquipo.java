package unidad05.equipo;

import java.time.LocalDate;

import unidad05.util.Utilidades;
import unidad05.util.UtilidadesParametroTipoIncorrectoException;

public class TestEquipo {

	public static void main(String[] args) throws UtilidadesParametroTipoIncorrectoException, EquipoCategoriaNoValidaException, EquipoCifNoValidoException {
		final byte NUM_EQUIPOS = 20;
		Equipo[] equipos = new Equipo[NUM_EQUIPOS];
		boolean salir = false;
		do {
			int opcion = Utilidades.dameEntero();
			switch (opcion) {
			case 1:
				boolean anadido = false;
				int i = 0;
				while (!anadido) {
					if (null == equipos[i]) {
						equipos[i] = dameEquipo();
						anadido = true;
					}
				}
				//TODO: controlar equipos disponibles
				break;
			case 2:
				
				break;
			case 3:
				
				break;
			case 4:
				
				break;
			case 5:
				salir = true;
				break;

			default:
				break;
			}
		} while(!salir);
		System.out.println("Vamos a crer un equipo:");
		
		
		
	}
	
	private static Equipo dameEquipo() throws UtilidadesParametroTipoIncorrectoException, EquipoCategoriaNoValidaException, EquipoCifNoValidoException {
		System.out.println("Introduce el nombre del equipo");
		String nombre = Utilidades.dameCadena();
		System.out.println("Introduce el CIF del equipo");//B2367483B
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

}
