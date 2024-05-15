package action;

import java.util.List;
import java.util.Map;

import com.mysql.fabric.Response;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import model.TipoUsuario;
import model.Usuario;
import persistencia.ClienteDao;
import persistencia.UsuarioDao;

public class UsuarioAction extends ActionSupport{
	
	// Ingreso usuario
		int tip;
		String usu;
		String contra;
		String est;
		String nom;
		// 2 Select Dinamico , Tipo usuario
		private List<TipoUsuario> listadoTipoAction = null;

		// 3 Listado de usuario
		private List<Usuario> listadoUsuarioAction = null;

		// 4 Parametro de Busqueda
		int param;
		// 5 Busqueda usuarioObj
		Usuario usuario;
		// 6 Actualizacion de usuario
		int dni;
		//
		String tipou;
		
		
		

	public String getTipou() {
			return tipou;
		}




		public void setTipou(String tipou) {
			this.tipou = tipou;
		}




	public int getTip() {
			return tip;
		}




		public void setTip(int tip) {
			this.tip = tip;
		}




		public String getUsu() {
			return usu;
		}




		public void setUsu(String usu) {
			this.usu = usu;
		}




		public String getContra() {
			return contra;
		}




		public void setContra(String contra) {
			this.contra = contra;
		}




		public String getEst() {
			return est;
		}




		public void setEst(String est) {
			this.est = est;
		}




		public String getNom() {
			return nom;
		}




		public void setNom(String nom) {
			this.nom = nom;
		}




		public List<TipoUsuario> getListadoTipoAction() {
			return listadoTipoAction;
		}




		public void setListadoTipoAction(List<TipoUsuario> listadoTipoAction) {
			this.listadoTipoAction = listadoTipoAction;
		}




		public List<Usuario> getListadoUsuarioAction() {
			return listadoUsuarioAction;
		}




		public void setListadoUsuarioAction(List<Usuario> listadoUsuarioAction) {
			this.listadoUsuarioAction = listadoUsuarioAction;
		}




		public int getParam() {
			return param;
		}




		public void setParam(int param) {
			this.param = param;
		}




		public Usuario getUsuario() {
			return usuario;
		}




		public void setUsuario(Usuario usuario) {
			this.usuario = usuario;
		}




		public int getDni() {
			return dni;
		}




		public void setDni(int dni) {
			this.dni = dni;
		}

//
		int idtipo;
		


	public int getIdtipo() {
			return idtipo;
		}




		public void setIdtipo(int idtipo) {
			this.idtipo = idtipo;
		}




	public String ValidaUsuarioAction() throws Exception {
		try {
			
			UsuarioDao usuariodao = new UsuarioDao();
		    
			usuario = usuariodao.validaUsuarioDao(usu, contra);
			
			System.out.println("Exito validaUsuarioAction");
		} catch (Exception e) {
			System.out.println("Error validaUsuarioAction" + e.getMessage());
			e.printStackTrace();
		}
		// Analisis		
		
		if (usuario.getNombre() != null && getTipou().equals("usuario") ) {
			
				// Sesiones, crear una sesion
				Map<String, Object> sesionUsuario = ActionContext.getContext().getSession();
				sesionUsuario.put("sesionUsuario", usuario);
				addActionMessage("Bienvenido al Sistema Ansa:" + usuario.getNombre());
				return SUCCESS;
		
		} 
		if(usuario.getNombre() != null && getTipou().equals("administrador")){
			Map<String, Object> sesionUsuario = ActionContext.getContext().getSession();
			sesionUsuario.put("sesionUsuario", usuario);
			addActionMessage("Bienvenido al Sistema Ansa:" + usuario.getNombre());
			return NONE;
			
		}
      else {
			addActionError("Usuario y/o clave erronea");
			return ERROR;
		}
		
				
	}
	
	
	public String cerrarSesionUsuario() throws Exception {
		Map sessionLogout = ActionContext.getContext().getSession();
		sessionLogout.remove("sesionUsuario");
		addActionMessage("Has salido de su sesion");
		return SUCCESS;
	}
	public String busquedaUsuarioDniAction() throws Exception {
		UsuarioDao usuariodao = new UsuarioDao();
		try {

			System.out.println("Exito busquedausuariodniAction");
			listadoUsuarioAction = usuariodao.busquedaUsuarioDaoDni(param);
		} catch (Exception e) {
			System.out.println("Error busquedausuariodniAction" + e.getMessage());
			e.printStackTrace();
		}
		if (listadoUsuarioAction.isEmpty()) {
			addActionMessage("usuario no encontrado o no existe ");
			return ERROR;
		} else {
			addActionMessage("usuario encotrado");
			return SUCCESS;
			
		}
	}

}
