package co.edu.ue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ue.dao.IPromocionDao;
import co.edu.ue.entity.Programa;
import co.edu.ue.entity.Promocion;

@Service
public class PromocionService implements IPromocionService {

	@Autowired
	IPromocionDao dao;
	
	@Override
	public List<Promocion> listarPromocion() {
		return dao.listarPromocion();
	}
	
	@Override
	public Promocion buscarByIdPm(int id_prom) {
		return dao.buscarByIdPm(id_prom);
	}


}
