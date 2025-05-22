package unidad06.vehiculos.base;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Concesionario {

	private Set<Vehiculo> vehiculos;
	private int numVehiculos;//Eliminar para obtener el num de vehiculos con un count a BD
	private final int CAPACIDAD_MAX = 500;//Eliminar capacidad máxima

	public Concesionario() {
		this.numVehiculos = 0;
		this.vehiculos = new TreeSet<Vehiculo>();
	}

	/**
	 * Busca el vehiculo del concesionario que tiene la matrícula que se pasa por
	 * parámetro.
	 * En caso de que no se encuentre un vehículo con dicha matrícula, devuelve
	 * null.
	 * 
	 * @param matricula
	 * @return vehiculo
	 */
	public Vehiculo buscaVehiculo(String matricula) {
		Vehiculo vehiculo = null;
		boolean encontrado = false;
		Iterator<Vehiculo> it = vehiculos.iterator();
		while (!encontrado && it.hasNext()) {
			Vehiculo v = it.next();
			if (null != matricula && matricula.equals(v.getMatricula())) {
				vehiculo = v;
				encontrado = true;
			}
		}
		return vehiculo;
	}

	/**
	 * Inserta un nuevo vehículo al concesionario.
	 * Devuelve 0 si el vehículo se añade correctamente
	 * Devuelve -1 si el vehículo no puede añadirse por falta de capacidad en el
	 * concesionario
	 * Devuelve -2 si el vehículo con esa matrícula ya existe en el concesionario
	 * 
	 * @param v
	 * @return codReturn
	 */
	public int insertarVehiculo(Vehiculo v) {
		int codReturn = -2;
		if (numVehiculos >= CAPACIDAD_MAX) {
			codReturn = -1;
		} else if (vehiculos.add(v)) {
			numVehiculos++;
			codReturn = 0;
		}
		return codReturn;
	}

	public void listarVehiculos() {
		if (this.vehiculos.size()>0) {
			
			System.out.println("El concesionario tiene los siguientes vehículos:");
			for (Vehiculo v : this.vehiculos) {
				System.out.println(v);
			}
			System.out.println("___________________________");
		} else {
			
			System.out.println("El concesionario está vacío");
			System.out.println("___________________________");
		}
	}

	/**
	 * Actualiza los kilómetros del vehículo con la matrícula pasada por parámetro.
	 * Devuelve true si se ha actualizado correctamente y false si el vehículo con
	 * dicha matrícula no se encuentra en el concesionario.
	 * 
	 * @param matricula
	 * @param kms
	 * @return kmsActualizado
	 */
	public boolean actualizaKms(String matricula, int kms) {
		boolean kmsActualizado = false;
		Vehiculo v = this.buscaVehiculo(matricula);
		if (null != v && null != matricula && matricula.equals(v.getMatricula())) {
			v.setNumKM(kms);
			kmsActualizado = true;
		}
		return kmsActualizado;

	}

	/**
	 * Elimina el vehículo del conjunto de vehículos del concesionario que coincide
	 * con la matrícula pasada como parámetro.
	 * Devuelve true en caso de que haya eliminado correctamente el vehículo y false
	 * en caso contrario. Si el vehículo con la matrícula pasada por parámetro no se
	 * encuentra en el concesionario, también devolverá false.
	 * 
	 * @param matricula
	 * @return eliminado
	 */
	public boolean eliminarVehiculo(String matricula) {
		boolean eliminado = false;
		Vehiculo v = this.buscaVehiculo(matricula);
		if (v != null) {			
			eliminado = this.vehiculos.remove(v);
		}
		return eliminado;
	}
}
