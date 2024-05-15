package action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import model.DetalleVenta;
import model.Producto;
import model.Venta;
import persistencia.DetalleVentaDao;
import persistencia.ProductoDao;
import persistencia.VentaDao;

public class DetalleAction extends ActionSupport{
	
		private List<Venta> listadoVentaAction = null;
   
		private List<DetalleVenta> listadoDetalleVentaAction = null;
		
		private List<Producto> listadoProductoAction = null;

		int param;
		DetalleVenta detalle;
		
		
	
	public List<Venta> getListadoVentaAction() {
			return listadoVentaAction;
		}



		public void setListadoVentaAction(List<Venta> listadoVentaAction) {
			this.listadoVentaAction = listadoVentaAction;
		}



		public List<DetalleVenta> getListadoDetalleVentaAction() {
			return listadoDetalleVentaAction;
		}



		public void setListadoDetalleVentaAction(List<DetalleVenta> listadoDetalleVentaAction) {
			this.listadoDetalleVentaAction = listadoDetalleVentaAction;
		}



		public List<Producto> getListadoProductoAction() {
			return listadoProductoAction;
		}



		public void setListadoProductoAction(List<Producto> listadoProductoAction) {
			this.listadoProductoAction = listadoProductoAction;
		}



		public int getParam() {
			return param;
		}



		public void setParam(int param) {
			this.param = param;
		}



		public DetalleVenta getDetalle() {
			return detalle;
		}



		public void setDetalle(DetalleVenta detalle) {
			this.detalle = detalle;
		}



	public String cargamantenimientodetalleventaaction() throws Exception{
		
		VentaDao ventadao = new VentaDao();
		DetalleVentaDao detalleventadao = new DetalleVentaDao();
		ProductoDao productodao = new ProductoDao();
		
		try {
			
			listadoVentaAction = ventadao.listadoVentaDao();
			listadoProductoAction = productodao.listadoProductoDao();
			System.out.println("Exito cargaMantenimientoDetalleAction Select");
			
			listadoDetalleVentaAction = detalleventadao.listadoDetalleDao();
		} catch (Exception e) {
			System.out.println("Error cargaMantenimientoEmpleadoAction Select" + e.getMessage());
			e.printStackTrace();
		}
		// Analisis de la Consulta
		if (listadoVentaAction.isEmpty() == false && listadoProductoAction.isEmpty() == false && listadoDetalleVentaAction.isEmpty() ==false) {
			addActionMessage("Exito al Cargar Datos Dinamico");
			return SUCCESS;
		} else {
			addActionError("Error al Cargar Datos Dinamico");
			return ERROR;
		}
	}

}
