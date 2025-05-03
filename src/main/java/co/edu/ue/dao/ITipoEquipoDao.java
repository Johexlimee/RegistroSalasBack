package co.edu.ue.dao;
import java.util.List;

import co.edu.ue.entity.TipoEquipo;

public interface ITipoEquipoDao {
	List<TipoEquipo> ListarTipoEquipo();
	TipoEquipo searchByIdTipoEquipo(int id);
	boolean postEquipo(TipoEquipo tipoequipo);
	TipoEquipo updateTipoEquipo(TipoEquipo tipoequipo, int id);
	void deleteTipoEquipo(int id);
	TipoEquipo deleteTipoEquipo(TipoEquipo tipoequipo, int id);
	boolean existsByNombre(String nombre);
}
