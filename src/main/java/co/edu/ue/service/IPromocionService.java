package co.edu.ue.service;

import java.util.List;

import co.edu.ue.entity.Promocion;

public interface IPromocionService {
	
	List<Promocion> listarPromocion();
	Promocion buscarByIdPm (int id_prom);

}
