package unidad06.edificio;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Edificio {
	private Set<Persona> acessoVip;
	private Map<String, Date> ins;
	private Map<String, Date> insVip;

	public Edificio() {
		this.acessoVip = new TreeSet<Persona>();
		this.ins = new TreeMap<String, Date>();
		this.insVip = new TreeMap<String, Date>();
	}

	// getters and setters...
	/**
	 * @return the acessoVip
	 */
	public Set<Persona> getAcessoVip() {
		return acessoVip;
	}

	/**
	 * @return the ins
	 */
	public Map<String, Date> getIns() {
		return ins;
	}

	/**
	 * @return the insVip
	 */
	public Map<String, Date> getInsVip() {
		return insVip;
	}

	public void acessoEdificio(String persDni) {
		if (null != persDni && !ins.containsKey(persDni)) {
			ins.put(persDni, new Date());
		} else {
			System.err.println("Persona con dni " + persDni + " ya se encuentra en el edificio");
		}
	}

	public void salidaEdificio(String persDni) {
		if (null != persDni && ins.containsKey(persDni)) {
			ins.remove(persDni);
		} else {
			System.err.println("Persona con dni " + persDni + " no se encuentra en el edificio");
		}
	}

	public void acessoZonaVip(String persDni) {

		if (null != persDni && insVip.containsKey(persDni)) {
			Iterator<Persona> itPers = this.acessoVip.iterator();
			boolean esVip = false;
			while (!esVip && itPers.hasNext()) {
				Persona personaAct = itPers.next();
				if (persDni.equalsIgnoreCase(personaAct.getDni())) {
					esVip = true;
				}
			}
			if (esVip) {
				insVip.put(persDni, new Date());
			} else {
				System.err.println("Persona con dni " + persDni + " no tiene permisos de acceso a la zona privada");
			}
		} else {
			System.err.println("Persona con dni " + persDni + " ya se encuentra en la zona privada");
		}
	}

	public void salidaZonaVip(String persDni) {

		if (null != persDni && !insVip.containsKey(persDni)) {

			insVip.remove(persDni);
		} else {
			System.err.println("Persona con dni " + persDni + " no se encuentra en la zona privada");
		}

	}
}
