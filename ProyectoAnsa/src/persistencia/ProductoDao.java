package Persistencia;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Model.Producto;
import Service.Productointerfaz;
import Model.Categoria;


public class ProductoDao implements Productointerfaz {
	@Override
	public boolean ingresoProductoDao(Producto producto) throws Exception {
		// Declaracion de Variables
		boolean resultado = false;
		Connection con = null;
		CallableStatement csmt = null;
		try {
			con = Conexion.getConnection();
			String sql = "CALL pa_ingresoproducto(?,?,?,?);";
			csmt = con.prepareCall(sql);
			// LLenamos el Objeto
            csmt.setInt(1, producto.getCategoria().getIdCategoria());
			csmt.setString(2, producto.getDescripcion());
			csmt.setDouble(3, producto.getPrecio());
			csmt.setInt(4, producto.getStock());
			// Ejecutamos consulta
			int i = csmt.executeUpdate();
			if (i == 1) {
				resultado = true;
			} else {
				resultado = false;
			}
			System.out.println("Exito ingresoProductoDao");
		} catch (Exception e) {
			System.out.println("Error ingresoProductoDao" + e.getMessage());
			e.printStackTrace();
		} finally {
			csmt.close();
			con.close();
		}
		// El metodo devuelve el resultado del ingreso
		return resultado;
	}
	@Override
public List listadoProductoDao() throws Exception{
	List listadoProductoRS =  new ArrayList();
	Connection con=null;
	CallableStatement cstm = null;
	ResultSet rs = null;
	try{
		con = Conexion.getConnection();
	    String sql = "CALL pa_listadoproducto()";
	    cstm = con.prepareCall(sql);
	    rs = cstm.executeQuery();
	    while (rs.next()) {
			Producto producto = new Producto();
			producto.setIdProducto(rs.getInt(1));
			Categoria cat = new Categoria();
			cat.setDescripcion(rs.getString(2));
			producto.setCategoria(cat);
			producto.setDescripcion(rs.getString(3));
			producto.setPrecio(rs.getDouble(4));
			producto.setStock(rs.getInt(5));
			
			listadoProductoRS.add(producto);
		}
	    System.out.println("Èxito en la consulta listadoProductoDao");
	    
	}catch(Exception e){
		System.out.println("Error en la consulta listadoProductoDao()");
		e.printStackTrace();
	}finally {
		rs.close();
		cstm.close();
		con.close();
	}
	return listadoProductoRS;
}
	
	@Override
	public List busquedaProductoNombresDao(String nom) throws Exception {
		List listadoProductoNombres = new ArrayList();
		Connection con = null;
		CallableStatement csmt = null;
		ResultSet rs = null;
		try {
			con = Conexion.getConnection();
			String sql = "CALL pa_busquedaproductonombre(?)";
			csmt = con.prepareCall(sql);
			csmt.setString(1, nom);
			rs = csmt.executeQuery();
			while (rs.next()) {
				// Objeto Empleado
				Producto producto = new Producto();
				producto.setIdProducto(rs.getInt(1));
				// Asociacion de Objetos
				Categoria cate = new Categoria();
				cate.setDescripcion(rs.getString(2));
				// agregamos tipo al atributo de Empleado
				producto.setCategoria(cate);
				producto.setDescripcion(rs.getString(3));
				producto.setPrecio(rs.getDouble(4));
				producto.setStock(rs.getInt(5));

				// Se almacena el objeto encontrado en la lista
				listadoProductoNombres.add(producto);
			}
			System.out.println("Exito busquedaProductoNombresDao");
		} catch (Exception e) {
			System.out.println("Error busquedaEmpleadoNombresDao" + e.getMessage());
			e.printStackTrace();
			// TODO: handle exception
		} finally {
			rs.close();
			csmt.close();
			con.close();
		}
		return listadoProductoNombres;
	}
}
