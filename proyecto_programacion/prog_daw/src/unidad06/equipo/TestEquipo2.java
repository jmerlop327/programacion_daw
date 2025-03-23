package unidad06.equipo;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import unidad05.util.Utilidades;
import unidad05.util.UtilidadesParametroTipoIncorrectoException;

public class TestEquipo2 {

	static Set<Equipo> equipos = new HashSet<Equipo>();

	public static void main(String[] args) throws EquipoCategoriaNoValidaException, EquipoCifNoValidoException {
		Equipo tigres = new Equipo("Tigres FC", "A12345678", LocalDate.of(1995, 3, 15), true, 'A');
		Equipo tigres2 = new Equipo("Tigres FC", "A12345678", LocalDate.of(1995, 3, 15), true, 'A');
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
		equipos.add(tigres2);
		equipos.add(toros);
		equipos.add(tigres);
		//equipos.remove(tigres);
		System.out.println(tigres.equals(tigres2));
		for (Equipo equipo : equipos) {
			System.out.println(equipo);
		}
	}
}
