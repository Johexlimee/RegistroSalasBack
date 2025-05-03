package co.edu.ue.dao;

import java.util.List;
import co.edu.ue.entity.Equipo;

public interface IEquipoDao {

    List<Equipo> obtenerEquiposPorIdRegistro(int idRegistro);

    List<Equipo> ListarEquipos();

    Equipo searchByIdEquipo(int id);

    boolean postEquipo(Equipo equipo);

    Equipo updateEquipo(Equipo equipo, int id);

    void deleteEquipo(int id);

    List<Equipo> buscarPorTipoEquipo(String tipoEquipo);

    Equipo cambiarEstado(int id,Equipo equipo);
}
