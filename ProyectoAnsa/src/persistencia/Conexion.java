package Persistencia;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
	// metodo que permite la conexion a la BD, devuelve la conexion a la misma
	public static Connection getConnection() throws Exception {
		Connection con = null;
		try {
			String url = "jdbc:mysql://localhost:3306/proyectoansa";
			String user = "root";
			String clave = "mysql";
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, user, clave);
			System.out.println("Exito conexion BD");
		} catch (Exception e) {
			System.out.println("Error conexion BD " + e.getMessage());
			e.printStackTrace();
		}
		return con;
	}

}
