package persistencia;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.DetalleVenta;
import model.Producto;
import model.Venta;
import service.DetalleVentaInterfaz;

public class DetalleVentaDao implements DetalleVentaInterfaz {

	@Override
	public boolean ingresoDetalleVentaDao(Venta venta) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List listadoDetalleDao() throws Exception {
		// Variables
				List listadoDetalleRs = new ArrayList();
				Connection con = null;
				CallableStatement csmt = null;
				ResultSet rs = null;
				try {
					con = Conexion.getConnection();
				
					String sql = "call pa_listadodetalle()";
					
					csmt = con.prepareCall(sql);
				
					rs = csmt.executeQuery();
					while (rs.next()) {
						DetalleVenta detalle = new DetalleVenta();
					
						// Asociacion de Objetos
						Venta venta = new Venta();
						venta.setIdventa(rs.getInt(1));
						detalle.setVenta(venta);
						
						Producto producto = new Producto();
						producto.setDescripcion(rs.getString(2));
						detalle.setProducto(producto);
						
						detalle.setPrecio(rs.getDouble(3));
						detalle.setCantidad(rs.getInt(4));
						
						venta.setFechaventa(rs.getString(5));
						detalle.setVenta(venta);
						
						venta.setDnicliente(rs.getInt(6));
						detalle.setVenta(venta);
						
						venta.setDniusuario(rs.getInt(7));
						detalle.setVenta(venta);
						// Agregar cada objeto a la lista
						listadoDetalleRs.add(detalle);
					}
					System.out.println("Exito consulta listadodetalleDao");
				} catch (Exception e) {
					System.out.println("Error consulta listadodetalleDao" + e.getMessage());
					e.printStackTrace();
				} finally {
					rs.close();
					csmt.close();
					con.close();
				}
				// El metodo devuelve el listado
				return listadoDetalleRs;
	}

}
