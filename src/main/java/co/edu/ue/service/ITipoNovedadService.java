package co.edu.ue.service;
import java.util.List;
import co.edu.ue.entity.TipoNovedad;

public interface ITipoNovedadService {
	List<TipoNovedad> ListarTipoNovedad();
	TipoNovedad searchByTipoNovedad(int id);
	boolean postTipoNovedad(TipoNovedad tipoNovedad);
	TipoNovedad updateTipoNovedad(TipoNovedad tipoNovedad, int id);
	void deleteTipoNovedad(int id);
	
}
