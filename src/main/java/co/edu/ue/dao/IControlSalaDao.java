package co.edu.ue.dao;

import java.util.List;

import co.edu.ue.entity.Controlsala;

public interface IControlSalaDao {

	List<Controlsala> listarControl();
	Controlsala searchById(int id);
	Controlsala postControlsala(Controlsala controlsala);
	Controlsala updateControlsala(Controlsala controlsala, int id);
	void deleteCourse(int id);
	Controlsala deleteControlsala(Controlsala controlsala, int id);
	Controlsala findTopByOrderByIdRegistroDesc();
}
