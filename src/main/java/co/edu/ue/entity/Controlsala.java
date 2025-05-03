package co.edu.ue.entity;

import java.io.Serializable;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.sql.Time;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;


/**
 * The persistent class for the controlsala database table.
 * 
 */
@Entity
@NamedQuery(name="Controlsala.findAll", query="SELECT c FROM Controlsala c")
public class Controlsala implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_registro")
	private int idRegistro;
	//validaciones
	@NotNull(message = "El código del bocero no puede ser nulo")
	@Pattern(regexp = "^[0-9]+$", 
	         message = "El código del bocero solo puede contener números")
	@Size(min = 1, max = 10, 
	      message = "El código del bocero debe tener entre 1 y 10 dígitos")
	
	private String codigoBocero1;

	private String codigoBocero2;

	private String descripcion;

	
	private String descripcion_dos;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	@Column(name="hora_entrada")
	private Time horaEntrada;

	@Column(name="hora_salida", nullable = true)
	private Time horaSalida;

	//bi-directional many-to-one association to Programa
	@ManyToOne
	@JoinColumn(name="id_programa")
	private Programa programa;

	//bi-directional many-to-one association to Promocion
	@ManyToOne
	@JoinColumn(name="id_prom")
	private Promocion promocion;

	private String nombreBocero1;

	private String nombreBocero2;

	//bi-directional many-to-one association to Sala
	@ManyToOne
	@JoinColumn(name="sala_id")
	private Sala sala;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="usuario_id")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Usuario usuario;

	public Controlsala() {
	}

	public int getIdRegistro() {
		return this.idRegistro;
	}

	public void setIdRegistro(int idRegistro) {
		this.idRegistro = idRegistro;
	}

	public String getCodigoBocero1() {
		return this.codigoBocero1;
	}

	public void setCodigoBocero1(String codigoBocero1) {
		this.codigoBocero1 = codigoBocero1;
	}

	public String getCodigoBocero2() {
		return this.codigoBocero2;
	}

	public void setCodigoBocero2(String codigoBocero2) {
		this.codigoBocero2 = codigoBocero2;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion_dos() {
		return this.descripcion_dos;
	}

	public void setDescripcion_dos(String descripcion_dos) {
		this.descripcion_dos = descripcion_dos;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Time getHoraEntrada() {
		return this.horaEntrada;
	}

	public void setHoraEntrada(Time horaEntrada) {
		this.horaEntrada = horaEntrada;
	}

	public Time getHoraSalida() {
		return this.horaSalida;
	}

	public void setHoraSalida(Time horaSalida) {
		this.horaSalida = horaSalida;
	}

	public Programa getPrograma() {
		return this.programa;
	}
 
	public void setPrograma(Programa programa) {
		this.programa = programa;
	}
	public Promocion getPromocion() {
		return this.promocion;
	}
 
	public void setPromocion(Promocion promocion) {
		this.promocion = promocion;
	}

	public String getNombreBocero1() {
		return this.nombreBocero1;
	}

	public void setNombreBocero1(String nombreBocero1) {
		this.nombreBocero1 = nombreBocero1;
	}

	public String getNombreBocero2() {
		return this.nombreBocero2;
	}

	public void setNombreBocero2(String nombreBocero2) {
		this.nombreBocero2 = nombreBocero2;
	}

	public Sala getSala() {
		return this.sala;
	}
 
	public void setSala(Sala sala) {
		this.sala = sala;
	}
	public Usuario getUsuario() {
		return this.usuario;
	}
 
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}