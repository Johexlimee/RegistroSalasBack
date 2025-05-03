package co.edu.ue.dao;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.ue.entity.Usuario;
import co.edu.ue.jpa.IUsuarioJpa;


@Repository
public class UsuarioDao implements IUsuarioDao {

	 @Autowired
	    private IUsuarioJpa jpa; 
	 
	@Override
	public Usuario registerUser(Usuario usuario) {
		return jpa.save(usuario);
	}


	

	
}
