package co.edu.ue.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.ue.entity.Programa;
import co.edu.ue.entity.Sala;
import co.edu.ue.jpa.IProgramaJpa;

@Repository
public class ProgramaDao implements IProgramaDao{
	
	@Autowired
	IProgramaJpa jpa;

	@Override
	public List<Programa> listarPrograma() {
		return jpa.findAll();
	}

	
	@Override
	public Programa buscarByIdP(int id_programa) {
		return jpa.findById(id_programa).orElse(null);
	}

}
