package Persistencia;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Model.Categoria;
import Model.Producto;
import Model.cliente;
import Service.ClienteInterfaz;

public class ClienteDao implements ClienteInterfaz {


	public List listadoClienteDao() throws Exception{
		List listadoclienteRS =  new ArrayList();
		Connection con=null;
		CallableStatement cstm = null;
		ResultSet rs = null;
		try{
			con = Conexion.getConnection();
		    String sql = "CALL pa_listaclientes()";
		    cstm = con.prepareCall(sql);
		    rs = cstm.executeQuery();
		    while (rs.next()) {
				cliente cliente = new cliente();
				cliente.setDnicliente(rs.getInt(1));
				cliente.setNombre(rs.getString(2));
				cliente.setApellido(rs.getString(3));
				cliente.setTelefono(rs.getInt(4));
				
				listadoclienteRS.add(cliente);
			}
		    System.out.println("Èxito en la cosulta listadoclienteRS");
		    
		}catch(Exception e){
			System.out.println("Error en la consulta listadoClienteDao()");
			e.printStackTrace();
		}finally {
			rs.close();
			cstm.close();
			con.close();
		}
		return listadoclienteRS;
	}
		

	public List busquedaClienteDaoDni(int dni) throws Exception {
		List listadoclientedni = new ArrayList();
		Connection con = null;
		CallableStatement csmt = null;
		ResultSet rs = null;
		try {
			con = Conexion.getConnection();
			String sql = "CALL pa_busquedaclientedni(?)";
			csmt = con.prepareCall(sql);
			csmt.setInt(1, dni);
			rs = csmt.executeQuery();
			while (rs.next()) {
				cliente client = new cliente();
				client.setDnicliente(rs.getInt(1));
				client.setNombre(rs.getString(2));
				client.setApellido(rs.getString(3));
				client.setTelefono(rs.getInt(4));

				listadoclientedni.add(client);
			}
			System.out.println("Exito busquedaclienteDaodni");
		} catch (Exception e) {
			System.out.println("Error busquedaclienteDaodni" + e.getMessage());
			e.printStackTrace();
			// TODO: handle exception
		} finally {
			rs.close();
			csmt.close();
			con.close();
		}
		return listadoclientedni;
	}
	public boolean ingresoClienteDao(cliente client) throws Exception {
		// Declaracion de Variables
		boolean resultado = false;
		Connection con = null;
		CallableStatement csmt = null;
		try {
			con = Conexion.getConnection();
			String sql = "CALL pa_ingresocliente(?,?,?,?);";
			csmt = con.prepareCall(sql);
			// LLenamos el Objeto
			csmt.setInt(1, client.getDnicliente());
			csmt.setString(2, client.getNombre());
			csmt.setString(3, client.getApellido());
			csmt.setInt(4, client.getTelefono());
			// Ejecutamos consulta
			int i = csmt.executeUpdate();
			if (i == 1) {
				resultado = true;
			} else {
				resultado = false;
			}
			System.out.println("Exito ingresoClienteDao");
		} catch (Exception e) {
			System.out.println("Error ingresoClienteDao" + e.getMessage());
			e.printStackTrace();
		} finally {
			csmt.close();
			con.close();
		}
		// El metodo devuelve el resultado del ingreso
		return resultado;
	}

	public List busquedaClienteNombresDao(String nom) throws Exception {
		List listadoClienteNombres = new ArrayList();
		Connection con = null;
		CallableStatement csmt = null;
		ResultSet rs = null;
		try {
			con = Conexion.getConnection();
			String sql = "CALL pa_busquedaclientenombre(?)";
			csmt = con.prepareCall(sql);
			csmt.setString(1, nom);
			rs = csmt.executeQuery();
			while (rs.next()) {
				// Objeto cliente
				cliente clientes = new cliente();
				clientes.setDnicliente(rs.getInt(1));
				
				clientes.setNombre(rs.getString(3));
				clientes.setApellido(rs.getString(4));
				clientes.setTelefono(rs.getInt(5));

				// Se almacena el objeto encontrado en la lista
				listadoClienteNombres.add(clientes);
			}
			System.out.println("Exito busquedaClienteoNombresDao");
		} catch (Exception e) {
			System.out.println("Error busquedaClienteoNombresDao" + e.getMessage());
			e.printStackTrace();
			// TODO: handle exception
		} finally {
			rs.close();
			csmt.close();
			con.close();
		}
		return listadoClienteNombres;
	}

	@Override
	public cliente busquedaClienteObjIdDao(int dni) throws Exception {
		// Inicializacion de variables
		Connection con = null;
		CallableStatement csmt = null;
		ResultSet rs = null;
		// Instancio Objeto empleado
		cliente clien = new cliente();
		try {
			con = Conexion.getConnection();
			String sql = "CALL pa_buscaclienteobjetoid(?)";
			csmt = con.prepareCall(sql);
			// inserto el parametro de busqueda
			csmt.setInt(1, dni);
			// Ejecuto la consulta y recibo el objeto en el ResultSet
			rs = csmt.executeQuery();
			while (rs.next()) {
				clien.setDnicliente(rs.getInt(1));
			
				clien.setNombre(rs.getString(2));
				clien.setApellido(rs.getString(3));
				clien.setTelefono(rs.getInt(4));
			}
			System.out.println("Exito busquedaClienteObjIdDao");
		} catch (Exception e) {
			System.out.println("Error busquedaClienteObjIdDao " + e.getMessage());
			e.printStackTrace();
		} finally {
			rs.close();
			csmt.close();
			con.close();
		}
		
		return clien;
	}

	@Override
	public boolean actualizaClienteDao(cliente clien) throws Exception {
		boolean resultado = false;
		Connection con = null;
		CallableStatement csmt = null;
		try {
			con = Conexion.getConnection();
			String sql = "CALL pa_actualizacliente(?,?,?,?);";
			csmt = con.prepareCall(sql);
			// Llenamos el objeto
			csmt.setInt(1, clien.getDnicliente());
			
			csmt.setString(3, clien.getNombre());
			csmt.setString(4, clien.getApellido());
			csmt.setInt(5, clien.getTelefono());
			// Ejecutamos consulta
			int i = csmt.executeUpdate();
			if (i == 1) {
				resultado = true;
			} else {
				resultado = false;
			}

			System.out.println("Exito actualizaClienteDao");
		} catch (Exception e) {
			System.out.println("Error actualizaClienteDao" + e.getMessage());
			e.printStackTrace();
		} finally {
			csmt.close();
			con.close();
		}
		return resultado;
	}

}
