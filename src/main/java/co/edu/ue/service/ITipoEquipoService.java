package co.edu.ue.service;

import java.util.List;

import co.edu.ue.entity.TipoEquipo;

public interface ITipoEquipoService {
	List<TipoEquipo> ListarTipoEquipo();
	TipoEquipo searchByIdTipoEquipo(int id);
	boolean postTipoEquipo(TipoEquipo tipoequipo);
	TipoEquipo updateTipoEquipo(TipoEquipo tipoequipo, int id);
	void deleteTipoEquipo(int id);
	TipoEquipo deleteTipoEquipo(TipoEquipo tipoequipo, int id);
	boolean existsByNombre(String nombre);
}
