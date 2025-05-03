package co.edu.ue.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipo_novedad database table.
 * 
 */
@Entity
@Table(name="tipo_novedad")
@NamedQuery(name="TipoNovedad.findAll", query="SELECT t FROM TipoNovedad t")
public class TipoNovedad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_tipo_novedad")
	private int idTipoNovedad;

	private String nombre;

	public TipoNovedad() {
	}

	public int getIdTipoNovedad() {
		return this.idTipoNovedad;
	}

	public void setIdTipoNovedad(int idTipoNovedad) {
		this.idTipoNovedad = idTipoNovedad;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


}