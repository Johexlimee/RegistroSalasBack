package co.edu.ue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ue.dao.INovedadDao;
import co.edu.ue.entity.Novedad;

@Service
public class NovedadService implements INovedadService {
	
	@Autowired
	INovedadDao dao;

	@Override
	public List<Novedad> ListarNovedad() {
		return dao.ListarNovedad();
	}

	@Override
	public Novedad searchByIdNovedad(int id) {
		return dao.searchByIdNovedad(id);
	}

	@Override
	public boolean postNovedad(Novedad novedad) {
		return dao.postNovedad(novedad);
	}

	@Override
	public Novedad updateNovedad(Novedad novedad, int id) {
		return dao.updateNovedad(novedad, id);
	}

	@Override
	public void deleteNovedad(int id) {
		dao.deleteNovedad(id);
	}

	@Override
	public Novedad deleteNovedad(Novedad novedad, int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
