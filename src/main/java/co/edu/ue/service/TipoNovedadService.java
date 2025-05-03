package co.edu.ue.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.edu.ue.dao.ITipoNovedadDao;
import co.edu.ue.entity.TipoNovedad;

@Service
public class TipoNovedadService implements ITipoNovedadService {
	
	@Autowired
	ITipoNovedadDao dao;

	@Override
	public List<TipoNovedad> ListarTipoNovedad() {
		return dao.ListarTipoNovedaes();
	}

	
	@Override
	public TipoNovedad searchByTipoNovedad(int id) {
		return dao.searchById(id);
	}

	@Override
	public boolean postTipoNovedad(TipoNovedad TipoNovedad) {
		return dao.postTipoNovedad(TipoNovedad);
	}

	@Override
	public TipoNovedad updateTipoNovedad(TipoNovedad TipoNovedad, int id) {
		return dao.updateTipoNovedad(TipoNovedad, id);
	}

	@Override
	public void deleteTipoNovedad(int id) {
		dao.deleteTipoNovedad(id);	
	}
	
}
