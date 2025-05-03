package co.edu.ue.entity;

import java.io.Serializable;
import jakarta.persistence.*;

/**
 * The persistent class for the equipo database table.
 * 
 */
@Entity
@NamedQuery(name = "Equipo.findAll", query = "SELECT e FROM Equipo e")
public class Equipo implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_equipo")
    private int idEquipo;

    @Column(name = "estado", nullable = false)
    private boolean estado; 

    @Column(name = "serial", nullable = false, length = 100)
    private String serial; 

    @Column(name = "estadoEquipo", nullable = false, length = 255)
    private String estadoEquipo; 

    // Relación con la tabla Sala
    @ManyToOne
    @JoinColumn(name = "sala_id")
    private Sala sala;

    // Relación con la tabla TipoEquipo
    @ManyToOne
    @JoinColumn(name = "tipo_equipo_id")
    private TipoEquipo tipoEquipo;

    // Constructor vacío
    public Equipo() {}

	public int getIdEquipo() {
		return idEquipo;
	}

	public void setIdEquipo(int idEquipo) {
		this.idEquipo = idEquipo;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public String getEstadoEquipo() {
		return estadoEquipo;
	}
	

	public void setEstadoEquipo(String estadoEquipo) {
		this.estadoEquipo = estadoEquipo;
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	public TipoEquipo getTipoEquipo() {
		return tipoEquipo;
	}

	public void setTipoEquipo(TipoEquipo tipoEquipo) {
		this.tipoEquipo = tipoEquipo;
	}

 
	
}
