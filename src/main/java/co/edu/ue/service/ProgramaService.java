package co.edu.ue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ue.dao.IProgramaDao;
import co.edu.ue.entity.Controlsala;
import co.edu.ue.entity.Programa;

@Service
public class ProgramaService implements IProgramaService {
	
	@Autowired
	IProgramaDao dao;
	
	@Override
	public List<Programa> listarPrograma() {
		return dao.listarPrograma();
	}

	
	@Override
	public Programa buscarByIdP(int id_programa) {
		return dao.buscarByIdP(id_programa);
	}

}
