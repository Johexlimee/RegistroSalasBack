package co.edu.ue.service;

import co.edu.ue.entity.Usuario;

public interface IUsuarioInterface {
	Usuario registerUser(Usuario usuario);
	String iniciarSesion(String correo, String contrasena);
	String obtenerRolDesdeAcceso(String correo);
	void registrarUsuario(String correo, String contrasena);
	
}
