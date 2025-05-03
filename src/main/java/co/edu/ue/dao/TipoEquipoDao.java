package co.edu.ue.dao;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import co.edu.ue.entity.TipoEquipo;
import co.edu.ue.jpa.ITipoEquipoJpa;

@Repository
public class TipoEquipoDao implements ITipoEquipoDao{
	
	@Autowired
	ITipoEquipoJpa jpa;
	

	@Override
	public List<TipoEquipo> ListarTipoEquipo() {
		return jpa.findAll();
	}

	@Override
	public TipoEquipo searchByIdTipoEquipo(int id) {
		 return jpa.findById(id).orElse(null);
	}

	@Override
	public boolean postEquipo(TipoEquipo tipoequipo) {
	    TipoEquipo tipoGuardado = jpa.save(tipoequipo);
	    return tipoGuardado != null;
	}

	@Override
	public TipoEquipo updateTipoEquipo(TipoEquipo tipoequipo, int id) {
		TipoEquipo newTipoEquipo = jpa.findById(id).get();
		
		if (Objects.nonNull(tipoequipo.getNombre()) && !"".equalsIgnoreCase(tipoequipo.getNombre())) {
			newTipoEquipo.setNombre(tipoequipo.getNombre());
		}
		return jpa.save(newTipoEquipo);
	}

	@Override
	public void deleteTipoEquipo(int id) {
		if(jpa.existsById(id)) jpa.deleteById(id);
		
	}

	@Override
	public TipoEquipo deleteTipoEquipo(TipoEquipo tipoequipo, int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public boolean existsByNombre(String nombre) {
	    return jpa.existsByNombre(nombre); 
	}
	
}
