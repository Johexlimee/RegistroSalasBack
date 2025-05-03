package co.edu.ue.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipo_equipo database table.
 * 
 */
@Entity
@Table(name="tipo_equipo")
@NamedQuery(name="TipoEquipo.findAll", query="SELECT t FROM TipoEquipo t")
public class TipoEquipo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_tipo_equipo")

	private int idTipoEquipo;

	private String nombre;

	public TipoEquipo() {
	}

	public int getIdTipoEquipo() {
		return this.idTipoEquipo;
	}

	public void setIdTipoEquipo(int idTipoEquipo) {
		this.idTipoEquipo = idTipoEquipo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}