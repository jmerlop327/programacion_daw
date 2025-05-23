package unidad08.gestisimal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {
	private static final String URL = "jdbc:mysql://localhost:3306/gestisimal";
	private static final String USER = "admin";
	private static final String PASS = "admin";

	// método para obtener la conexión
	public static Connection getConnection() {
		try {
			// Carga el driver de MySql
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(URL, USER, PASS);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	// método para cerrar la conexión
	public static void closeConnection(Connection connection) {
		if (null != connection) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
