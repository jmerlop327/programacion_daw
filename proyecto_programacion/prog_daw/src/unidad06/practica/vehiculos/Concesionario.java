package unidad06.practica.vehiculos;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Concesionario {
 
    private Set<Vehiculo> vehiculos;
    private int numVehiculos;
    
    public Concesionario(){
        this.numVehiculos = 0;
        this.vehiculos = new TreeSet<Vehiculo>();
    }
    
	public Vehiculo buscaVehiculo(String matricula) {
		Iterator<Vehiculo> itVehiculo = this.vehiculos.iterator();
		boolean encontrado = false;
		while (itVehiculo.hasNext() && !encontrado) {
			Vehiculo v = itVehiculo.next();
			if (v.getMatricula().equals(matricula)) {
				return v;
			}
		}
		return null;
	}
    
    public int insertarVehiculo(Vehiculo v){
        
        if(this.vehiculos.contains(v)){
            return -2;
        }else{
            if (this.vehiculos.add(v)) {            	
            	this.numVehiculos++;
            }
            return 0;
        }
        
        
    }
    
    public void listarVehiculos(){
        for (Vehiculo v : this.vehiculos) {
            System.out.println(v.toString());
        }
    }
    
    public boolean actualizaKms(String matricula, int kms){
            
        for (Vehiculo v : this.vehiculos) {            
            if(v.getMatricula().equals(matricula)){
                v.setNumKM(kms);
                return true;
            }
        }
        return false;
        
    }
    
}
