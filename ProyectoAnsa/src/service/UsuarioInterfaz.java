package service;

import java.util.List;

import model.Usuario;

public interface UsuarioInterfaz {
	 public Usuario validaUsuarioDao(String usu,String contra) throws Exception;
	 public List busquedaUsuarioDaoDni(int dni)throws Exception;

	 
}
