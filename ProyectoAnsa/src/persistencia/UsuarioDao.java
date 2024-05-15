package persistencia;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.TipoUsuario;
import model.Usuario;
import model.cliente;
import service.UsuarioInterfaz;

public class UsuarioDao implements UsuarioInterfaz {

	@Override
	public Usuario validaUsuarioDao(String usu, String contra) throws Exception {
		
			Connection con=null;
			CallableStatement csmt=null;
			ResultSet rs=null;
			Usuario usuario=new Usuario();
			try {
				con=Conexion.getConnection();
				String sql="CALL pa_validaUsuario(?,?)";
				csmt=con.prepareCall(sql);
				//Se insertan los parametros en la consulta
				csmt.setString(1,usu);
				csmt.setString(2,contra);
				//Se ejecuta la consulta y se almacena el resultado
				rs=csmt.executeQuery();
				//recorro y guardo el objeto
				while(rs.next()){
					
					usuario.setDniusuario(rs.getInt(1));
					TipoUsuario tipo=new TipoUsuario();
					tipo.setDescripcion(rs.getString(2));
					usuario.setTipo(tipo);
					usuario.setUsuario(rs.getString(3));
					usuario.setContraseña(rs.getString(4));
					usuario.setEstado(rs.getString(5));
					usuario.setNombre(rs.getString(6));
				}
				System.out.println("Exito validaUsuarioDao");
			} catch (Exception e) {
				System.out.println("Error validaUsuarioDao"+e.getMessage());
				e.printStackTrace();
			}finally{
				rs.close();
				csmt.close();
				con.close();
			}
			return usuario;
		}

	public List busquedaUsuarioDaoDni(int dni) throws Exception {
		List listadousuariodni = new ArrayList();
		Connection con = null;
		CallableStatement csmt = null;
		ResultSet rs = null;
		try {
			con = Conexion.getConnection();
			String sql = "CALL pa_busquedausuariodni(?)";
			csmt = con.prepareCall(sql);
			csmt.setInt(1, dni);
			rs = csmt.executeQuery();
			while (rs.next()) {
				Usuario usuario = new Usuario();
				TipoUsuario tipo = new TipoUsuario();
				usuario.setDniusuario(rs.getInt(1));
				tipo.setIdtipo(rs.getInt(2));
				usuario.setTipo(tipo);
				usuario.setUsuario(rs.getString(3));
				usuario.setContraseña(rs.getString(4));
				usuario.setEstado(rs.getString(5));
				usuario.setNombre(rs.getString(6));

				listadousuariodni.add(usuario);
			}
			System.out.println("Exito busquedausuarioDaodni");
		} catch (Exception e) {
			System.out.println("Error busquedausuarioDaodni" + e.getMessage());
			e.printStackTrace();
			// TODO: handle exception
		} finally {
			rs.close();
			csmt.close();
			con.close();
		}
		return listadousuariodni;
	}
	
}
