package co.edu.ue.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.edu.ue.dao.IEquipoDao;
import co.edu.ue.entity.Equipo;

@Service
public class EquipoService implements IEquipoService {

    @Autowired
    IEquipoDao dao;

    @Override
    public List<Equipo> obtenerEquiposPorIdRegistro(int idRegistro) {
        return dao.obtenerEquiposPorIdRegistro(idRegistro);
    }

    @Override
    public List<Equipo> ListarEquipos() {
        return dao.ListarEquipos();
    }

    @Override
    public Equipo searchByIdEquipo(int id) {
        return dao.searchByIdEquipo(id);
    }

    @Override
    public boolean postEquipo(Equipo equipo) {
        return dao.postEquipo(equipo);
    }

    @Override
    public Equipo updateEquipo(Equipo equipo, int id) {
        return dao.updateEquipo(equipo, id);
    }

    @Override
    public void deleteEquipo(int id) {
        dao.deleteEquipo(id);
    }

    @Override
    public List<Equipo> buscarPorTipoEquipo(String tipoEquipo) {
        return dao.buscarPorTipoEquipo(tipoEquipo);
    }

	@Override
	public Equipo cambiarEstadoEquipo(int id, Equipo equipo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Equipo cambiarEstado(int id,Equipo equipo){
		return dao.cambiarEstado(id, equipo);
	}

   /* @Override
    public Equipo cambiarEstadoEquipo(int id, Equipo equipo) {
        return dao.cambiarEstadoEquipo(id, equipo );
    }

    @Override
    public Equipo cambiarEstado(int id, Equipo equipo) {
        return dao.cambiarEstadoEquipo(id, equipo);
    }
    */
}
