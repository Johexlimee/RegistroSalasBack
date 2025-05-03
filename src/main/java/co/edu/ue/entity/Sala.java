package co.edu.ue.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;

@Entity
@NamedQuery(name="Sala.findAll", query="SELECT s FROM Sala s")
public class Sala implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_sala")
	private int idSala;

	private String nombre;
/*
	//bi-directional many-to-one association to Controlsala
	@OneToMany(mappedBy="sala")
	private List<Controlsala> controlsalas;
	*/

	//bi-directional many-to-one association to Equipo
	/*@OneToMany(mappedBy="sala")
	private List<Equipo> equipos;*/

	public Sala() {
	}

	public int getIdSala() {
		return this.idSala;
	}

	public void setIdSala(int idSala) {
		this.idSala = idSala;
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
		controlsala.setSala(this);

		return controlsala;
	}

	public Controlsala removeControlsala(Controlsala controlsala) {
		getControlsalas().remove(controlsala);
		controlsala.setSala(null);

		return controlsala;
	}
	
	public List<Equipo> getEquipos() {
		return this.equipos;
	}

	public void setEquipos(List<Equipo> equipos) {
		this.equipos = equipos;
	}

	public Equipo addEquipo(Equipo equipo) {
		getEquipos().add(equipo);
		equipo.setSala(this);

		return equipo;
	}

	public Equipo removeEquipo(Equipo equipo) {
		getEquipos().remove(equipo);
		equipo.setSala(null);

		return equipo;
	}
*/
}