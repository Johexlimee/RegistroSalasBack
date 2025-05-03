package co.edu.ue.entity;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the novedad database table.
 * 
 */
@Entity
@NamedQuery(name="Novedad.findAll", query="SELECT n FROM Novedad n")
public class Novedad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_novedad")
	private int idNovedad;

	@Lob
	private String descripcion;

	//bi-directional many-to-one association to Equipo
	@ManyToOne
	@JoinColumn(name="id_equipo")
	private Equipo equipo;

	//bi-directional many-to-one association to TipoNovedad
	@ManyToOne
	@JoinColumn(name="id_tipo_novedad")
	private TipoNovedad tipoNovedad1;



	public Novedad() {
	}

	public int getIdNovedad() {
		return this.idNovedad;
	}

	public void setIdNovedad(int idNovedad) {
		this.idNovedad = idNovedad;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Equipo getEquipo() {
		return this.equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	public TipoNovedad getTipoNovedad1() {
		return this.tipoNovedad1;
	}

	public void setTipoNovedad1(TipoNovedad tipoNovedad1) {
		this.tipoNovedad1 = tipoNovedad1;
	}


}