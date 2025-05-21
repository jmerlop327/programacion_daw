package unidad08;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TestConnectionPersona {

	public static void main(String[] args) {
		// test agregar persona a la bd
		Persona maria = new Persona("María", "González", "00000000T");
		Persona jose = new Persona("José", "Moreno", "00000001W");
		//List<Persona> lista = obtenerPersonas();
		List<Persona> listaPorDni = obtenerPersonasPorDni("00000001P");
		System.out.println(listaPorDni);
	}

	private static List<Persona> obtenerPersonasPorDni(String dniInput) {
		List<Persona> personas = new ArrayList<Persona>();
		try {
			Connection conn = DatabaseManager.getConnection();
			String consulta = "select nombre,apellidos from persona where dni=?";
			PreparedStatement query = conn.prepareStatement(consulta);
			query.setString(1, dniInput);
			ResultSet resultado = query.executeQuery();
			while (resultado.next()) {
				String nombre = resultado.getString("nombre");
				String apellidos = resultado.getString("apellidos");
				Persona p = new Persona(nombre, apellidos, dniInput);
				personas.add(p);
			}
			conn.close();
			if (personas.size()<=0) {
				System.out.println("No se encontraron personas con el dni " + dniInput);
			}
			return personas;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	private static List<Persona> obtenerPersonas() {
		List<Persona> personas = new ArrayList<Persona>();
		try {
			Connection conn = DatabaseManager.getConnection();
			String consulta = "select nombre,apellidos,dni from persona";
			PreparedStatement query = conn.prepareStatement(consulta);
			ResultSet resultado = query.executeQuery();
			while (resultado.next()) {
				String nombre = resultado.getString("nombre");
				String apellidos = resultado.getString("apellidos");
				String dni = resultado.getString("dni");
				Persona p = new Persona(nombre, apellidos, dni);
				personas.add(p);
			}
			conn.close();
			return personas;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	private static void agregarPersona(Persona persona) {
		Connection conn = DatabaseManager.getConnection();
		String consulta = "insert into persona (nombre, apellidos, dni) values (?, ?, ?)";
		try {
			PreparedStatement query = conn.prepareStatement(consulta);
			query.setString(1, persona.getNombre());
			query.setString(2, persona.getApellidos());
			query.setString(3, persona.getDni());
			if (query.execute()) {
				System.out.println("query ejecutada correctamente");
			}
			query.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
