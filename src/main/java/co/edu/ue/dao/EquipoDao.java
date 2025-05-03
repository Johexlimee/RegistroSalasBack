package co.edu.ue.dao;

import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import co.edu.ue.entity.Equipo;
import co.edu.ue.jpa.IEquipoJpa;

@Repository
public class EquipoDao implements IEquipoDao {
    @Autowired
    IEquipoJpa jpa;

    @Override
    public List<Equipo> obtenerEquiposPorIdRegistro(int idRegistro) {
        return jpa.findEquiposByIdRegistro(idRegistro);
    }

    @Override
    public List<Equipo> ListarEquipos() {
        return jpa.findAll();
    }

    @Override
    public Equipo searchByIdEquipo(int id) {
        return jpa.findById(id).orElse(null);
    }

    @Override
    public boolean postEquipo(Equipo equipo) {
        return jpa.save(equipo) != null;
    }

    @Override
    public Equipo updateEquipo(Equipo equipo, int id) {
        Equipo nuevoEquipo = jpa.findById(id).orElse(null);
        if (nuevoEquipo == null) return null;
        
        if (Objects.nonNull(equipo.getSerial())) {
            nuevoEquipo.setSerial(equipo.getSerial());
        }
        if (Objects.nonNull(equipo.getSala())) {
            nuevoEquipo.setSala(equipo.getSala());
        }
        if (Objects.nonNull(equipo.getTipoEquipo())) {
            nuevoEquipo.setTipoEquipo(equipo.getTipoEquipo());
        }
        if (Objects.nonNull(equipo.getEstadoEquipo())) {
            nuevoEquipo.setEstadoEquipo(equipo.getEstadoEquipo());
        }
        if (Objects.nonNull(equipo.isEstado())) {
            nuevoEquipo.setEstado(equipo.isEstado());
        }

        return jpa.save(nuevoEquipo);
    }

    @Override
    public void deleteEquipo(int id) {
        if (jpa.existsById(id)) {
            jpa.deleteById(id);
        }
    }

    @Override
    public List<Equipo> buscarPorTipoEquipo(String tipoEquipo) {
        return jpa.buscarPorTipoEquipo(tipoEquipo);
    }

	@Override
	public Equipo cambiarEstado(int id, Equipo equipo) {
		Equipo newEquipo = jpa.findById(id).get();
        if (newEquipo.isEstado()== true) newEquipo.setEstado(false);;
		
		return jpa.save(newEquipo);
	}

	

  
   
}
