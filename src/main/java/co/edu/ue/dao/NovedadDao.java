package co.edu.ue.dao;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import co.edu.ue.entity.Novedad;
import co.edu.ue.jpa.INovedadJpa;

@Repository
public class NovedadDao implements INovedadDao {
	
	@Autowired
	INovedadJpa jpa;

	@Override
	public List<Novedad> ListarNovedad() {
		return jpa.findAll();
	}

	@Override
	public Novedad searchByIdNovedad(int id) {
		return jpa.findById(id).orElse(null);
	}

	@Override
	public Novedad postNovedad(Novedad novedad) {
	    return jpa.save(novedad); // ✅ Ahora devuelve la novedad creada
	}



	@Override
	public Novedad updateNovedad(Novedad novedad, int id) {
		Novedad newNovedad = jpa.findById(id).get();	
		
		if (Objects.nonNull(novedad.getDescripcion()) && !"".equalsIgnoreCase(novedad.getDescripcion())) {
			newNovedad.setDescripcion(novedad.getDescripcion());
		}
		
		return jpa.save(newNovedad);
	}

	@Override
	public void deleteNovedad(int id) {
		jpa.deleteById(id);
		
	}

	@Override
	public Novedad deleteNovedad(Novedad Novedad, int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
