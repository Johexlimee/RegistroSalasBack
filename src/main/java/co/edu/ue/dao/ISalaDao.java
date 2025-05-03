package co.edu.ue.dao;
import java.util.List;
import org.springframework.stereotype.Repository;
import co.edu.ue.entity.Sala;


@Repository
public interface ISalaDao{

	List<Sala>ListarSala();
	Sala buscarById(int id_sala);
	List<Sala> listarSala();

}
