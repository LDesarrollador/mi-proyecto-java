package Action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import Model.Producto;
import Model.Categoria;
import Persistencia.ProductoDao;
import Persistencia.CategoriaDao;

public class ProductoAction extends ActionSupport{
	int idpro;
	int idcat;
	String des;
	double pre;
	int stock;
	String param;
	private List<Categoria> listadoCategoriaAction = null;
	private List<Producto> listadoProductoAction = null;
		
	
	public String getParam() {
		return param;
	}
	public void setParam(String param) {
		this.param = param;
	}
	public int getIdpro() {
		return idpro;
	}
	public void setIdpro(int idpro) {
		this.idpro = idpro;
	}
	public int getIdcat() {
		return idcat;
	}
	public void setIdcat(int idcat) {
		this.idcat = idcat;
	}
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	public double getPre() {
		return pre;
	}
	public void setPre(double pre) {
		this.pre = pre;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public List<Categoria> getListadoCategoriaAction() {
		return listadoCategoriaAction;
	}
	public void setListadoCategoriaAction(List<Categoria> listadoCategoriaAction) {
		this.listadoCategoriaAction = listadoCategoriaAction;
	}
	public List<Producto> getListadoProductoAction() {
		return listadoProductoAction;
	}
	public void setListadoProductoAction(List<Producto> listadoProductoAction) {
		this.listadoProductoAction = listadoProductoAction;
	}
	
	
	
	public String cargaMantenimientoProductoAction() throws Exception {
		CategoriaDao catDao = new CategoriaDao();
		ProductoDao productodao = new ProductoDao();
		try {
			listadoCategoriaAction = catDao.listadoCategoria();
			System.out.println("Exito cargaMantenimientoProductoAction Select");
			
			listadoProductoAction = productodao.listadoProductoDao();
		} catch (Exception e) {
			System.out.println("Error cargaMantenimientoProductoAction Select" + e.getMessage());
			e.printStackTrace();
		}
		if (listadoCategoriaAction.isEmpty() == false && listadoProductoAction.isEmpty() == false) {
			addActionMessage("Exito al Cargar Datos Dinamico");
			return SUCCESS;
		} else {
			addActionError("Error al Cargar Datos Dinamico");
			return ERROR;
		}
	}
	public String ListadoTipoAction()throws Exception
	{
		ProductoDao productoDao=new ProductoDao();
		CategoriaDao catedao=new CategoriaDao();
		try {
			listadoCategoriaAction=catedao.listadoCategoria();
			listadoProductoAction=productoDao.listadoProductoDao();
			
			System.out.println("Exito ListadoTipoAction");
		} catch (Exception e) {
			System.out.println("Error ListadoTipoAction");
			throw e ;
		}
		if(listadoProductoAction.isEmpty()==false& listadoProductoAction.isEmpty()==false){
			addActionMessage("Exito operacion");
			return SUCCESS;
			
			
		}else{
			addActionError("Error Operacion");
			return ERROR;
		}
		
	}
	
	public String ingresoProductoAction() throws Exception {
		boolean resultado = false;
		try {
			Producto producto = new Producto();
			// Asociacion de Objeto
			Categoria cat = new Categoria();
			cat.setIdCategoria(idcat);
			// Se inserta Tipo dentro de Empleado
			producto.setCategoria(cat);
			producto.setDescripcion(des);
			producto.setPrecio(pre);
			producto.setStock(stock);
			// Se instancia a EmpleadoDao
			ProductoDao productoDao = new ProductoDao();
			// Se envia el objeto empleado y se recibe el resultado
			// de la operacion
			resultado = productoDao.ingresoProductoDao(producto);
			System.out.println("Exito ingresoProductoAction");
		} catch (Exception e) {
			System.out.println("Error ingresoProductoAction" + e.getMessage());
			e.printStackTrace();
		}
		// Se llama al metodo para recargar los datos Dinamicos
		cargaMantenimientoProductoAction();
		// Analisis del ingreso
		if (resultado == true) {
			// Limpiar variables
			des = "";
			pre = 0.0;
			stock = 0;
			addActionMessage("Producto Ingresado Correctamente");
			return SUCCESS;
		} else {
			addActionError("Error al Ingresar Producto");
			return ERROR;
		}
	}

	public String busquedaNombresAction() throws Exception {
		ProductoDao productodao = new ProductoDao();
		CategoriaDao categoriadao = new CategoriaDao();
		try {
			listadoCategoriaAction = categoriadao.listadoCategoria();
			listadoProductoAction = productodao.busquedaProductoNombresDao(String.valueOf(param));
			System.out.println("Exito busquedaNombresAction");
		} catch (Exception e) {
			System.out.println("Error busquedaNombresAction" + e.getMessage());
			e.printStackTrace();
		}
		// Analisis de la Consulta
		if (listadoProductoAction.isEmpty()) {
			addActionMessage("producto no encontrado o no existe ");
			return ERROR;
		} else {
			addActionMessage("producto encotrado");
			return SUCCESS;
		}
	}


	

}
