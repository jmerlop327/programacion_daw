package unidad06.vehiculos.base;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		boolean salir = false;
		boolean correcto = false;
		int opcion;

		Concesionario concesionario = new Concesionario();
//		LocalDate ld = LocalDate.now();
//		Vehiculo test = new Vehiculo("Seat", "0567FGR", 2000, 2017, "Seat Ibiza", 10000d, "00000000T");
//		concesionario.insertarVehiculo(test);
//		concesionario.listarVehiculos();
//		concesionario.eliminarVehiculo(test.getMatricula());
//		concesionario.listarVehiculos();
//		
//		
//		
		Vehiculo v;
		String marca, matricula, descripcion, DNIProp;
		int kms = 0, anio = 0;
		float precio = 0;

		while (!salir) {
			System.out.println("1. Nuevo vehículo");
			System.out.println("2. Listar vehículos");
			System.out.println("3. Buscar vehículo");
			System.out.println("4. Modificar kms vehículo");
			System.out.println("5. Eliminar vehículo");
			System.out.println("6. Salir");
			System.out.println("Elige una opcion");
			opcion = scan.nextInt();

			switch (opcion) {
			case 1:

				System.out.println("Introduce la marca");
				// CAMBIO-002 limpio el buffer del scanner para obtener nextLine
				scan.nextLine();
				marca = scan.nextLine();

				do {
					System.out.println("Introduce la matricula");
					// CAMBIO-003 Obtengo la matrícula con nextLine
					matricula = scan.nextLine();
				} while (!Validacion.validarMatricula(matricula));

				do {
					correcto = true;

					try {
						System.out.println("Introduce el numero de km");
						kms = scan.nextInt();
					} catch (InputMismatchException e) {
						correcto = false;
						scan.next();
					}

				} while (!correcto);

				do {
					correcto = true;

					try {
						System.out.println("Introduce el año de la fecha de matriculacion");
						anio = scan.nextInt();

					} catch (InputMismatchException e) {
						correcto = false;
						scan.next();
					}

				} while (!correcto);

				System.out.println("Introduce la descripcion");
				scan.nextLine();
				descripcion = scan.nextLine();

				do {
					System.out.println("Introduce el dni del propietario");
					DNIProp = scan.nextLine();
				} while (!Validacion.validarDNI(DNIProp));

				do {
					correcto = true;

					try {
						System.out.println("Introduce el precio");
						precio = scan.nextFloat();
					} catch (InputMismatchException e) {
						correcto = false;
						scan.next();
					}

				} while (!correcto);

				v = new Vehiculo(marca, matricula, kms, anio, descripcion, precio, DNIProp);

				switch (concesionario.insertarVehiculo(v)) {
				case -2:
					System.out.println("El vehiculo existe");
					break;
				case -1:
					System.out.println("El concesionario esta lleno");
					break;
				case 0:
					System.out.println("Vehiculo insertado correctamente");
					break;
				}

				break;
			case 2:
				concesionario.listarVehiculos();
				break;
			case 3:

				System.out.println("Inserta la matricula");
				scan.nextLine();
				matricula = scan.nextLine();

				v = concesionario.buscaVehiculo(matricula);

				if (v != null) {
					System.out.println(v.getMarca());
					System.out.println(v.getMatricula());
					System.out.println(v.getPrecio());
				} else {
					System.out.println("No existe el vehiculo con la matricula introducida");
				}

				break;
			case 4:
				System.out.println("Inserta la matricula");
				// CAMBIO-004 Obtengo la matrícula con nextLine y valido la entrada correcta de
				// los kms
				scan.nextLine();
				matricula = scan.nextLine();
				correcto = false;
				while (!correcto) {

					try {
						System.out.println("Inserta los nuevos kms");
						kms = scan.nextInt();
					} catch (InputMismatchException e) {
						correcto = false;
						scan.next();
					}
				}

				if (concesionario.actualizaKms(matricula, kms)) {
					System.out.println("Los kms se ha actualizado correctamente");
				} else {
					System.out.println("No existe el vehiculo con la matricula introducida");
				}

				break;
			case 5:
				// CAMBIO-005 añado una opción del menú para eliminar vehículo
				System.out.println("Inserta la matricula");
				scan.nextLine();
				matricula = scan.nextLine();
				concesionario.eliminarVehiculo(matricula);
				break;
			case 6:
				salir = true;
				break;
			}

		}
		scan.close();
	}

}
