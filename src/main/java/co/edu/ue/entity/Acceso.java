package co.edu.ue.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@Table(name = "acceso")
public class Acceso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "acceso_id")
    private Long accesoId;

    @Column(name = "acceso_status", nullable = false)
    private Byte accesoStatus;

    // Relación con Usuario
    @ManyToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "id_usuario", nullable = false)
    @JsonBackReference
    private Usuario usuario;

    // Relación con Proyecto (Many-to-One)
    @ManyToOne
    @JoinColumn(name = "proyecto_id", nullable = false)
    private Proyecto proyecto;

    // Getters y Setters
    public Long getAccesoId() {
        return accesoId;
    }

    public void setAccesoId(Long accesoId) {
        this.accesoId = accesoId;
    }

    public Byte getAccesoStatus() {
        return accesoStatus;
    }

    public void setAccesoStatus(Byte accesoStatus) {
        this.accesoStatus = accesoStatus;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }
}
