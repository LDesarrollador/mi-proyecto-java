package Persistencia;

import java.sql.CallableStatement;
import java.sql.Connection;

import Model.DetalleVenta;
import Model.Venta;
import Service.VentaInterfaz;


public class VentaDao implements VentaInterfaz {

	public boolean ingresoVentaDao(Venta venta) throws Exception {
		// Declaracion de Variables
		boolean resultado = false;
		Connection con = null;
		CallableStatement csmt = null;
		try {
			con = Conexion.getConnection();
			String sql = "CALL pa_ingresoventa(?,?,?,?);";
			csmt = con.prepareCall(sql);
		    csmt.setInt(1, venta.getIdventa());
		    csmt.setString(2, venta.getFechaventa());
		    csmt.setInt(3, venta.getDnicliente());
		    csmt.setInt(4, venta.getDniusuario());
			
			// Ejecutamos consulta
			int i = csmt.executeUpdate();
			if (i == 1) {
				resultado = true;
			} else {
				resultado = false;
			}
			System.out.println("Exito ingresoVentaDao");
		} catch (Exception e) {
			System.out.println("Error ingresoVentaDao" + e.getMessage());
			e.printStackTrace();
		} finally {
			csmt.close();
			con.close();
		}
		// El metodo devuelve el resultado del ingreso
		return resultado;
	}

	public boolean ingresoDetalleVentaDao(DetalleVenta detalleventa) throws Exception {
		// Declaracion de Variables
		boolean resultado = false;
		Connection con = null;
		CallableStatement csmt = null;
		try {
			con = Conexion.getConnection();
			String sql = "CALL pa_ingresodetalleventa(?,?,?,?);";
			csmt = con.prepareCall(sql);
		    csmt.setInt(1, detalleventa.getVenta().getIdventa());
            csmt.setInt(2, detalleventa.getProducto().getIdProducto());
			csmt.setDouble(3, detalleventa.getPrecio());
			csmt.setInt(4, detalleventa.getCantidad());
			
			// Ejecutamos consulta
			int i = csmt.executeUpdate();
			if (i == 1) {
				resultado = true;
			} else {
				resultado = false;
			}
			System.out.println("Exito ingresoDetaaleVentaDao");
		} catch (Exception e) {
			System.out.println("Error ingresoDetaaleVentaDao" + e.getMessage());
			e.printStackTrace();
		} finally {
			csmt.close();
			con.close();
		}
		// El metodo devuelve el resultado del ingreso
		return resultado;
	}



}
