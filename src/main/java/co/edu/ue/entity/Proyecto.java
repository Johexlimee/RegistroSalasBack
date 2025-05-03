package co.edu.ue.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the proyectos database table.
 * 
 */
@Entity
@Table(name="proyectos")
@NamedQuery(name="Proyecto.findAll", query="SELECT p FROM Proyecto p")
public class Proyecto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="proyecto_id")
	private int proyectoId;

	@Column(name="proyecto_name")
	private String proyectoName;

	//bi-directional many-to-one association to Acceso
	@OneToMany(mappedBy="proyecto")
	private List<Acceso> accesos;

	//bi-directional many-to-one association to Area
	@ManyToOne
	@JoinColumn(name="area_id")
	private Area area;

	public Proyecto() {
	}

	public int getProyectoId() {
		return this.proyectoId;
	}

	public void setProyectoId(int proyectoId) {
		this.proyectoId = proyectoId;
	}

	public String getProyectoName() {
		return this.proyectoName;
	}

	public void setProyectoName(String proyectoName) {
		this.proyectoName = proyectoName;
	}

	public List<Acceso> getAccesos() {
		return this.accesos;
	}

	public void setAccesos(List<Acceso> accesos) {
		this.accesos = accesos;
	}

	public Acceso addAcceso(Acceso acceso) {
		getAccesos().add(acceso);
		acceso.setProyecto(this);

		return acceso;
	}

	public Acceso removeAcceso(Acceso acceso) {
		getAccesos().remove(acceso);
		acceso.setProyecto(null);

		return acceso;
	}

	public Area getArea() {
		return this.area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

}