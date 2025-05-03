package co.edu.ue.dao;

import java.util.List;

import co.edu.ue.entity.Novedad;

public interface INovedadDao {
	List<Novedad> ListarNovedad();
	Novedad searchByIdNovedad(int id);
	boolean postNovedad(Novedad novedad);
	Novedad updateNovedad(Novedad novedad, int id);
	void deleteNovedad(int id);
	Novedad deleteNovedad(Novedad novedad, int id);
}
