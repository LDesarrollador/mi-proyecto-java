package Service;

import java.util.List;

import Model.cliente;

public interface ClienteInterfaz {
	 public List busquedaClienteDaoDni(int dni)throws Exception;

	 public List listadoClienteDao() throws Exception;

	 public boolean ingresoClienteDao (cliente client) throws Exception;

	 public List busquedaClienteNombresDao(String nom)throws Exception;
	 
	 public cliente busquedaClienteObjIdDao(int dni) throws Exception;
	
	 public boolean actualizaClienteDao(cliente clien) throws Exception;

}
