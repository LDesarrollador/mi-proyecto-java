package Persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class login   {

	public int loguear(String usu, String contra){
		Connection con = null; 
		PreparedStatement pst = null;
		ResultSet rs= null;
		String cont="";
		int tipo=0;
		String sql="select idtipo from usuario where  usuario='"+ usu +"'and contraseña ='"+ contra+"'";
		try {
			con = Conexion.getConnection();
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			
			while(rs.next()){
				tipo = rs.getInt(1);
				
				
			}
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO: handle exception
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tipo;
	}
	
}
