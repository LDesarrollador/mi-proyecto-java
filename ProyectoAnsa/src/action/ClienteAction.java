package Action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import Model.Categoria;
import Model.Producto;
import Model.cliente;
import Persistencia.CategoriaDao;
import Persistencia.ClienteDao;
import Persistencia.ProductoDao;

public class ClienteAction extends ActionSupport{
	
	int dni;
	String nombre;
	String apellido;
	int telefono;
	//global
	cliente client;
	
	
	public cliente getClient() {
		return client;
	}


	public void setClient(cliente client) {
		this.client = client;
	}


	public VentaAction getVa() {
		return va;
	}


	public void setVa(VentaAction va) {
		this.va = va;
	}


	public int getN() {
		return n;
	}


	public void setN(int n) {
		this.n = n;
	}


	public int getDni() {
		return dni;
	}


	public void setDni(int dni) {
		this.dni = dni;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public int getTelefono() {
		return telefono;
	}


	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	int param;

	private List<cliente> listadoclienteAction = null;
	

	public List<cliente> getListadoclienteAction() {
		return listadoclienteAction;
	}


	public void setListadoclienteAction(List<cliente> listadoclienteAction) {
		this.listadoclienteAction = listadoclienteAction;
	}


	public int getParam() {
		return param;
	}
	


	//producto
	
	int idproducto;
	int idcategoria;
	String descripcion;
	double precio;
	int stock;
	String parame;
	
		//para listar el producto
	private List<Producto> listadoProductoAction = null;
	private List<Categoria> listadocategoriaAction = null;
	
	
	
	public String getParame() {
		return parame;
	}


	public void setParame(String parame) {
		this.parame = parame;
	}


	public List<Producto> getListadoProductoAction() {
		return listadoProductoAction;
	}


	public void setListadoProductoAction(List<Producto> listadoProductoAction) {
		this.listadoProductoAction = listadoProductoAction;
	}


	public int getIdproducto() {
		return idproducto;
	}


	public void setIdproducto(int idproducto) {
		this.idproducto = idproducto;
	}


	public int getIdcategoria() {
		return idcategoria;
	}


	public void setIdcategoria(int idcategoria) {
		this.idcategoria = idcategoria;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public double getPrecio() {
		return precio;
	}


	public void setPrecio(double precio) {
		this.precio = precio;
	}


	public int getStock() {
		return stock;
	}


	public void setStock(int stock) {
		this.stock = stock;
	}


	public List<Producto> getListadoproductoAction() {
		return listadoProductoAction;
	}


	public void setListadoproductoAction(List<Producto> listadoproductoAction) {
		this.listadoProductoAction = listadoproductoAction;
	}


	public List<Categoria> getListadocategoriaAction() {
		return listadocategoriaAction;
	}


	public void setListadocategoriaAction(List<Categoria> listadocategoriaAction) {
		this.listadocategoriaAction = listadocategoriaAction;
	}

	//
	int	nroventa;
	int id;
	
	

	public int getNroventa() {
		return nroventa;
	}


	public void setNroventa(int nroventa) {
		this.nroventa = nroventa;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}
	
	VentaAction va = new VentaAction();
	int n= va.id ;
	
	
//

	public String ingresoClienteAction() throws Exception {
		boolean resultado = false;
		try {
			cliente client = new cliente();
			
			client.setDnicliente(dni);
			client.setNombre(nombre);
			client.setApellido(apellido);
			client.setTelefono(telefono);
			// Se instancia a EmpleadoDao
			ClienteDao clientedao = new ClienteDao();
			// Se envia el objeto cliente y se recibe el resultado
			// de la operacion
			resultado = clientedao.ingresoClienteDao(client);
			System.out.println("Exito ingresoClenteAction");
		} catch (Exception e) {
			System.out.println("Error ingresoClenteAction" + e.getMessage());
			e.printStackTrace();
		}
		// Se llama al metodo para recargar los datos Dinamicos
		cargaMantenimientoClienteAction();
		// Analisis del ingreso
		if (resultado == true) {
			// Limpiar variables
			dni=0;
			nombre = "";
			apellido = "";
			telefono = 0;
			addActionMessage("Cliente Ingresado Correctamente");
			return SUCCESS;
		} else {
			addActionError("Error al Ingresar Cliente");
			return ERROR;
		}
	}


	public String cargaMantenimientoClienteAction() throws Exception {
		ClienteDao clientedao = new ClienteDao();
		ProductoDao productoDao = new ProductoDao();
		CategoriaDao categoriadao = new CategoriaDao();
		try {
			System.out.println("Exito cargaMantenimientoClienteAction Select");
			
			listadoclienteAction = clientedao.listadoClienteDao();
            listadocategoriaAction = categoriadao.listadoCategoria();
            listadoProductoAction = productoDao.listadoProductoDao();
            
            nroventa=n;
			
		} catch (Exception e) {
			System.out.println("Error cargaMantenimientoClienteAction Select" + e.getMessage());
			e.printStackTrace();
		}
		if (listadoclienteAction.isEmpty() == false) {
			addActionMessage("Exito al Cargar Datos Dinamico");
			return SUCCESS;
		} else {
			addActionError("Error al Cargar Datos Dinamico");
			return ERROR;
		}
	}

	public void setParam(int param) {
		this.param = param;
	}
	public String busquedaclienteDniAction() throws Exception {
		ClienteDao clientedao = new ClienteDao();
		try {

			System.out.println("Exito busquedaclientedniAction");
			listadoclienteAction = clientedao.busquedaClienteDaoDni(param);
		} catch (Exception e) {
			System.out.println("Error busquedaclientedniAction" + e.getMessage());
			e.printStackTrace();
		}
		if (listadoclienteAction.isEmpty()) {
			addActionMessage("cliente no encontrado o no existe ");
			return ERROR;
		} else {
			addActionMessage("cliente encotrado");
			return SUCCESS;
			
		}
	
	
	}
	public String busquedaNombresAction() throws Exception {
		ProductoDao productodao = new ProductoDao();
		CategoriaDao categoriadao = new CategoriaDao();
		try {
			listadocategoriaAction = categoriadao.listadoCategoria();
			listadoProductoAction = productodao.busquedaProductoNombresDao(String.valueOf(parame));
			nroventa=id;
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
	public String busquedaclienteNombreAction() throws Exception {
		ClienteDao clientedao = new ClienteDao();

		try {

			listadoclienteAction = clientedao.busquedaClienteNombresDao(String.valueOf(param));
			System.out.println("Exito busquedaClienteNombresAction");
		} catch (Exception e) {
			System.out.println("Error busquedaClienteNombresAction" + e.getMessage());
			e.printStackTrace();
		}
		// Analisis de la Consulta
		if (listadoclienteAction.isEmpty()) {
			addActionMessage("Cliente no encontrado o no existe ");
			return ERROR;
		} else {
			addActionMessage("Cliente encotrado");
			return SUCCESS;
		}
	}

	
	public String busquedaClienteIdObjAction() throws Exception {

		try {
			
			ClienteDao clientedao = new ClienteDao();
			// Se busca el cliente a partir de un id(dni)
			// y se almacena el Objeto cliente - Variable Global
			client = clientedao.busquedaClienteObjIdDao(param);

	

			System.out.println("Exito busquedaClienteIdObjAction");
		} catch (Exception e) {
			System.out.println("Error busquedaClienteIdObjAction " + e.getMessage());
			e.printStackTrace();
		}
		// se Cargan los datos Dinamicos, Select Dinamico
		cargaMantenimientoClienteAction();
		// Analisis de la busqueda
		if (client.getNombre() != null) {
			addActionMessage("Cliente encontrado");
			return SUCCESS;
		} else {
			addActionError("El Cliente no existe");
			return ERROR;
		}
	}

	public String actualizaClienteAction() throws Exception {
		boolean resultado = false;
		try {
			cliente clie = new cliente();
			clie.setDnicliente(dni);
			clie.setNombre(nombre);
			clie.setApellido(apellido);
			clie.setTelefono(telefono);
			ClienteDao clientedao = new ClienteDao();
			resultado = clientedao.actualizaClienteDao(clie);
			System.out.println("Exito actualizaClienteAction");

		} catch (Exception e) {
			System.out.println("Error actualizaClienteAction" + e.getMessage());
			e.printStackTrace();
		}
		// Actualizar el mantenimiento
		cargaMantenimientoClienteAction();
		// Analisis de la consulta
		// Analisis del ingreso
		if (resultado == true) {
			// Limpiar variables
			dni = 0;
			nombre = "";
			apellido = "";
			telefono = 0;
			
			addActionMessage("Cliente Actualizado Correctamente");
			return SUCCESS;
		} else {
			addActionError("Error al Actualizar Cliente");
			return ERROR;
		}
	}

	
}
