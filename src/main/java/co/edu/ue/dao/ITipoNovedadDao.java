package co.edu.ue.dao;

import java.util.List;

import co.edu.ue.entity.TipoNovedad;

public interface ITipoNovedadDao {
	List<TipoNovedad> ListarTipoNovedaes();
	TipoNovedad searchById(int id);
	boolean postTipoNovedad(TipoNovedad tipoNovedad);
	TipoNovedad updateTipoNovedad(TipoNovedad tipoNovedad, int id);
	void deleteTipoNovedad(int id);
	TipoNovedad deleteTipoNovedad(TipoNovedad tipoNovedad, int id);
}
