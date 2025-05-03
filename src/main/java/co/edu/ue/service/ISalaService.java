package co.edu.ue.service;
 
import java.util.List;
 
import co.edu.ue.entity.Sala;
 
 
public interface ISalaService {

 
	List<Sala> listarSala();
	List<Sala> ListarSala();
	Sala buscarById(int id_sala);
}