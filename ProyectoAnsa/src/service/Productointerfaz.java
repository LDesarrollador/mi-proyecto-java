package Service;

import java.util.*;

import Model.Producto;

public interface Productointerfaz {

	 public List listadoProductoDao() throws Exception;
	 public boolean ingresoProductoDao(Producto producto)throws Exception;
	 public List busquedaProductoNombresDao(String nom)throws Exception;
}
