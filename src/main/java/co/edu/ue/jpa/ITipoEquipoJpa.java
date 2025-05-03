package co.edu.ue.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import co.edu.ue.entity.TipoEquipo;


public interface ITipoEquipoJpa extends JpaRepository<TipoEquipo, Integer>{
	boolean existsByNombre(@Param("nombre") String nombre);
}
