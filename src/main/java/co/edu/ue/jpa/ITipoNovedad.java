package co.edu.ue.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.ue.entity.TipoNovedad;

public interface ITipoNovedad extends JpaRepository<TipoNovedad, Integer> {

}
