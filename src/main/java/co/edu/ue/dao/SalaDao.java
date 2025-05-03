package co.edu.ue.dao;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
 
import co.edu.ue.entity.Sala;
import co.edu.ue.jpa.ISalaJpa;
 
@Repository
public class SalaDao implements ISalaDao{
	@Autowired
	ISalaJpa jpa;
	@Override
	public List<Sala> listarSala() {
		return jpa.findAll();
	}
	@Override
	public Sala buscarById(int id_sala) {
		return jpa.findById(id_sala).orElse(null);
	}
 
 
	@Override
	public List<Sala> ListarSala() {
		return jpa.findAll();
		}

 
}