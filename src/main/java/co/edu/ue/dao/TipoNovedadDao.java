package co.edu.ue.dao;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.ue.entity.TipoNovedad;
import co.edu.ue.jpa.ITipoNovedad;

@Repository
public class TipoNovedadDao implements ITipoNovedadDao {
	
	@Autowired
	ITipoNovedad jpa;

	@Override
	public List<TipoNovedad> ListarTipoNovedaes() {
		return jpa.findAll();
	}

	@Override
	public TipoNovedad searchById(int id) {
		return jpa.findById(id).orElse(null);
	}

	@Override
	public boolean postTipoNovedad(TipoNovedad tipoNovedad) {
	    try {
	        jpa.save(tipoNovedad);
	        return true; // Registro exitoso
	    } catch (Exception e) {
	        System.err.println("Error al guardar TipoNovedad: " + e.getMessage());
	        return false; // Fallo en la inserción
	    }
	}


	@Override
	public TipoNovedad updateTipoNovedad(TipoNovedad tipoNovedad, int id) {
		TipoNovedad newTipoNovedad = jpa.findById(id).get();
		
		if (Objects.nonNull(tipoNovedad.getNombre()) && !"".equalsIgnoreCase(tipoNovedad.getNombre())) {
			newTipoNovedad.setNombre(tipoNovedad.getNombre());
		}
		
		
		return jpa.save(newTipoNovedad);
	}


	@Override
	public void deleteTipoNovedad(int id) {
		if(jpa.existsById(id)) jpa.deleteById(id);
		
		
	}

	@Override
	public TipoNovedad deleteTipoNovedad(TipoNovedad tipoNovedad, int id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
