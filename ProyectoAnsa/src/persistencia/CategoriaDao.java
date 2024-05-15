package Persistencia;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Model.Categoria;
import Service.CategoriaInterfaz;


public class CategoriaDao implements CategoriaInterfaz {
	@Override
	public List listadoCategoria() throws Exception {
		
		List listadoCategoriaDao = new ArrayList<Categoria>();
		Connection con = null;
		CallableStatement csmt = null;
		ResultSet rs = null;
		try {
			con = Conexion.getConnection();
			String sql = "CALL pa_listadocategorias()";
			csmt = con.prepareCall(sql);
			rs = csmt.executeQuery();
			while (rs.next()) {
				Categoria cate = new Categoria();
				cate.setIdCategoria(rs.getInt(1));
				cate.setDescripcion(rs.getString(2));
				listadoCategoriaDao.add(cate);
			}
			System.out.println("Exito listadoCategoriaDao");
		} catch (Exception e) {
			System.out.println("Error listadoCategoriaDao" + e.getMessage());
			e.printStackTrace();
		} finally {
			rs.close();
			csmt.close();
			con.close();
		}
		return listadoCategoriaDao;
	}


}
