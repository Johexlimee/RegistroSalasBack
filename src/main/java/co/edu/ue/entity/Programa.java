package co.edu.ue.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the programa database table.
 * 
 */
@Entity
@NamedQuery(name="Programa.findAll", query="SELECT p FROM Programa p")
public class Programa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_programa")
	private int idPrograma;

	private String nombre;

	//bi-directional many-to-one association to Controlsala
	//@OneToMany(mappedBy="programa")
	//private List<Controlsala> controlsalas;

	public Programa() {
	}

	public int getIdPrograma() {
		return this.idPrograma;
	}

	public void setIdPrograma(int idPrograma) {
		this.idPrograma = idPrograma;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
/*
	public List<Controlsala> getControlsalas() {
		return this.controlsalas;
	}

	public void setControlsalas(List<Controlsala> controlsalas) {
		this.controlsalas = controlsalas;
	}

	public Controlsala addControlsala(Controlsala controlsala) {
		getControlsalas().add(controlsala);
		controlsala.setPrograma(this);

		return controlsala;
	}

	public Controlsala removeControlsala(Controlsala controlsala) {
		getControlsalas().remove(controlsala);
		controlsala.setPrograma(null);

		return controlsala;
	}
	*/
}