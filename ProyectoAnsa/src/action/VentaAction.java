package Action;

import com.opensymphony.xwork2.ActionSupport;

import Model.DetalleVenta;
import Model.Producto;
import Model.Venta;
import Persistencia.ProductoDao;
import Persistencia.VentaDao;



public class VentaAction  extends ActionSupport{
	
int id;
String fecv;
int dc;
int du;




public int getId() {
return id;
}





public void setId(int id) {
this.id = id;
}





public String getFecv() {
return fecv;
}





public void setFecv(String fecv) {
this.fecv = fecv;
}





public int getDc() {
return dc;
}





public void setDc(int dc) {
this.dc = dc;
}





public int getDu() {
return du;
}





public void setDu(int du) {
this.du = du;
}



int nroventa;
int idpro;
double pre;
int can;






	public int getNroventa() {
	return nroventa;
}





public void setNroventa(int nroventa) {
	this.nroventa = nroventa;
}





public int getIdpro() {
	return idpro;
}





public void setIdpro(int idpro) {
	this.idpro = idpro;
}





public double getPre() {
	return pre;
}





public void setPre(double pre) {
	this.pre = pre;
}





public int getCan() {
	return can;
}





public void setCan(int can) {
	this.can = can;
}





	public String ingresoVentaAction() throws Exception {
		boolean resultado = false;
		try {
			Venta venta = new Venta();
			venta.setIdventa(id);
            venta.setFechaventa(fecv);
			venta.setDnicliente(dc);
			venta.setDniusuario(du);
		
			VentaDao ventadao = new VentaDao();
		
			resultado = ventadao.ingresoVentaDao(venta);
			System.out.println("Exito ingresoVentaAction");
		} catch (Exception e) {
			System.out.println("Error ingresoVentaAction" + e.getMessage());
			e.printStackTrace();
		}
		
		// Analisis del ingreso
		if (resultado == true) {
			// Limpiar variables
			nroventa=id;
			fecv = "";
			dc = 0;
			du = 0;
			addActionMessage("Guardado");
			return SUCCESS;
		} else {
			addActionError("Error al guardar");
			return ERROR;
		}
	}

	public String ingresoDetalleVentaAction() throws Exception {
		boolean resultado = false;
		try {
			DetalleVenta detalleVenta = new DetalleVenta();
			Venta venta = new Venta();
			venta.setIdventa(nroventa);
            detalleVenta.setVenta(venta);
            
            Producto producto = new Producto();
            producto.setIdProducto(idpro);
            detalleVenta.setProducto(producto);
            
            detalleVenta.setPrecio(pre);
			detalleVenta.setCantidad(can);
		
			VentaDao ventadao = new VentaDao();
		
			resultado = ventadao.ingresoDetalleVentaDao(detalleVenta);
			System.out.println("Exito ingresoDetalleVentaAction");
		} catch (Exception e) {
			System.out.println("Error ingresoDetalleVentaAction" + e.getMessage());
			e.printStackTrace();
		}
		
		// Analisis del ingreso
		if (resultado == true) {
			// Limpiar variables
			id=0;
			fecv = "";
			dc = 0;
			du = 0;
			nroventa=0;
			idpro=0;
			pre=0.0;
			can=0;
			addActionMessage("Guardado");
			return SUCCESS;
		} else {
			addActionError("Error al guardar");
			return ERROR;
		}
	}

}
