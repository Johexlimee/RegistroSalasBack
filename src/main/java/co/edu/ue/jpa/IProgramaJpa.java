package co.edu.ue.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.ue.entity.Controlsala;
import co.edu.ue.entity.Programa;

public interface IProgramaJpa extends JpaRepository<Programa , Integer> {

}
