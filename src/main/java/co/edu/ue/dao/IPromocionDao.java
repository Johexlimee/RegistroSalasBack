package co.edu.ue.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import co.edu.ue.entity.Promocion;

@Repository
public interface IPromocionDao {
	
	List<Promocion> listarPromocion();
	Promocion buscarByIdPm (int id_prom);

}
