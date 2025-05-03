package co.edu.ue.service;

import java.util.List;

import co.edu.ue.entity.Programa;

public interface IProgramaService {
	
	List<Programa> listarPrograma();
	Programa buscarByIdP (int id_programa);

}
