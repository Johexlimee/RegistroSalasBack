package co.edu.ue.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.ue.entity.Controlsala;
import co.edu.ue.jpa.IControlSalasJpa;

@Repository
public class ControlSalaDao implements IControlSalaDao{

	@Autowired 
	IControlSalasJpa jpa;
	
	@Override
	public List<Controlsala> listarControl() {
		return jpa.findAll();
	}

	@Override
	public Controlsala searchById(int id) {
		return jpa.findById(id).orElse(null);
	}

	@Override
	public Controlsala postControlsala(Controlsala controlsala) {
	    Controlsala savedControlsala = jpa.save(controlsala); // Guarda la entidad
	    if (savedControlsala != null) {
	        return savedControlsala; // Devuelve la entidad guardada si fue exitosa
	    }
	    return null; // Devuelve null si hubo un error en la operación
	}

	@Override
	public Controlsala updateControlsala(Controlsala controlsala, int id) {
		if (jpa.existsById(id)) {
			controlsala.setIdRegistro(id);
            return jpa.save(controlsala);
        }
        return null;
	}

	@Override
	public void deleteCourse(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Controlsala deleteControlsala(Controlsala controlsala, int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Controlsala findTopByOrderByIdRegistroDesc() {
		return jpa.findTopByOrderByIdRegistroDesc();
	}

}
