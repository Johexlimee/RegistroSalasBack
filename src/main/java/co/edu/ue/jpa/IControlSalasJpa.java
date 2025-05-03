package co.edu.ue.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.ue.entity.Controlsala;

public interface IControlSalasJpa extends JpaRepository<Controlsala , Integer> {
    Controlsala findTopByOrderByIdRegistroDesc();
}
