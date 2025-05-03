package co.edu.ue.service;

import java.util.List;

import co.edu.ue.entity.Controlsala;

public interface IControlSalasService {

	List<Controlsala> listarControl();
	Controlsala searchById(int id);
	Controlsala postControlsala(Controlsala controlsala);
	Controlsala updateControlsala(Controlsala controlsala, int id);
	void deleteCourse(int id);
	Controlsala deleteControlsala(Controlsala controlsala, int id);
	Controlsala obtenerUltimoRegistro();
}
