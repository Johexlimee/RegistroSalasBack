package co.edu.ue.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.ue.entity.Programa;
import co.edu.ue.entity.Promocion;
import co.edu.ue.jpa.IPromocionJpa;

@Repository
public class PromocionDao implements IPromocionDao{
	
	@Autowired
	IPromocionJpa jpa;

	@Override
	public List<Promocion> listarPromocion() {
		return jpa.findAll();
	}
	
	@Override
	public Promocion buscarByIdPm(int id_prom) {
		return jpa.findById(id_prom).orElse(null);
	}


}
