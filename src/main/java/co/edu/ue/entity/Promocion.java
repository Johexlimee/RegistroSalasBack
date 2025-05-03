package co.edu.ue.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the promocion database table.
 * 
 */
@Entity
@NamedQuery(name="Promocion.findAll", query="SELECT p FROM Promocion p")
public class Promocion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_prom")
	private int idProm;

	private String nombre;
/*
	//bi-directional many-to-one association to Controlsala
	@OneToMany(mappedBy="promocion")
	private List<Controlsala> controlsalas;
*/
	public Promocion() {
	}

	public int getIdProm() {
		return this.idProm;
	}

	public void setIdProm(int idProm) {
		this.idProm = idProm;
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
		controlsala.setPromocion(this);

		return controlsala;
	}

	public Controlsala removeControlsala(Controlsala controlsala) {
		getControlsalas().remove(controlsala);
		controlsala.setPromocion(null);

		return controlsala;
	}
*/
}