package co.edu.ue.service;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import co.edu.ue.dao.ISalaDao;
import co.edu.ue.entity.Programa;
import co.edu.ue.entity.Sala;
 
@Service
public class SalaService implements ISalaService {
	@Autowired
	ISalaDao dao;
 
	@Override
	public List<Sala> listarSala() {
		return dao.listarSala();
	}
	@Override
	public Sala buscarById(int id_sala) {
		return dao.buscarById(id_sala);
	}
 
	@Override
	public List<Sala> ListarSala() {
		return dao.ListarSala();
	}
 
}