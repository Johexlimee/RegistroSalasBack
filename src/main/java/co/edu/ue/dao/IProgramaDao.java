package co.edu.ue.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import co.edu.ue.entity.Programa;
import co.edu.ue.entity.Sala;


@Repository
public interface IProgramaDao {
	
	
	List<Programa> listarPrograma();
	Programa buscarByIdP (int id_programa);

}
