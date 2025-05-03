package co.edu.ue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ue.dao.IControlSalaDao;
import co.edu.ue.entity.Controlsala;

@Service
public class ControlSalasService implements IControlSalasService {

	@Autowired
	IControlSalaDao dao;
	@Override
	public List<Controlsala> listarControl() {
		return dao.listarControl();
	}

	@Override
	public Controlsala searchById(int id) {
		return dao.searchById(id);
	}

	@Override
	public Controlsala postControlsala(Controlsala controlsala) {
		return dao.postControlsala(controlsala);
	}

	@Override
	public Controlsala updateControlsala(Controlsala controlsala, int id) {
		return dao.updateControlsala(controlsala, id);
	}

	@Override
	public void deleteCourse(int id) {

	}
	
	@Override
	public Controlsala obtenerUltimoRegistro() {
	    return dao.findTopByOrderByIdRegistroDesc();
	}


	@Override
	public Controlsala deleteControlsala(Controlsala controlsala, int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
