package co.edu.ue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.edu.ue.dao.ITipoEquipoDao;
import co.edu.ue.entity.TipoEquipo;

@Service 
public class TipoEquipoService implements ITipoEquipoService{
	
	@Autowired
	ITipoEquipoDao dao;

	@Override
	public List<TipoEquipo> ListarTipoEquipo() {
		return dao.ListarTipoEquipo();
	}

	@Override
	public TipoEquipo searchByIdTipoEquipo(int id) {
		return dao.searchByIdTipoEquipo(id);
	}

	@Override
	public boolean postTipoEquipo(TipoEquipo tipoequipo) {
		return dao.postEquipo(tipoequipo);
	}

	@Override
	public TipoEquipo updateTipoEquipo(TipoEquipo tipoequipo, int id) {
		return dao.updateTipoEquipo(tipoequipo, id);
	}

	@Override
	public void deleteTipoEquipo(int id) {
		dao.deleteTipoEquipo(id);
		
	}

	@Override
	public TipoEquipo deleteTipoEquipo(TipoEquipo tipoequipo, int id) {
		return dao.deleteTipoEquipo(tipoequipo, id);
	}
	
	@Override
	public boolean existsByNombre(String nombre) {
	    return dao.existsByNombre(nombre); // ✅ Delegamos la lógica al DAO
	}

}
