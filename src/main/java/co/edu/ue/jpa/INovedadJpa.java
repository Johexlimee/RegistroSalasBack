package co.edu.ue.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.ue.entity.Novedad;

public interface INovedadJpa extends JpaRepository<Novedad, Integer> {

}
