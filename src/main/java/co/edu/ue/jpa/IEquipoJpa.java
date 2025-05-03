package co.edu.ue.jpa;
 
import java.util.List;
 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
 
import co.edu.ue.entity.Equipo;
 
 
public interface IEquipoJpa  extends JpaRepository<Equipo, Integer>{
	 @Query(value = "SELECT e.* " +
             "FROM gestionsalas.equipo e " +
             "INNER JOIN gestionsalas.sala s ON e.sala_id = s.id_sala " +
             "INNER JOIN gestionsalas.controlsala cs ON s.id_sala = cs.sala_id " +
             "WHERE cs.id_registro = :idRegistro", nativeQuery = true)
	    List<Equipo> findEquiposByIdRegistro(@Param("idRegistro") int idRegistro);
	 
	 @Query("SELECT e FROM Equipo e WHERE e.tipoEquipo.nombre = :tipoEquipo")
	    List<Equipo> buscarPorTipoEquipo(@Param("tipoEquipo") String tipoEquipo);
	 
	}
 
 