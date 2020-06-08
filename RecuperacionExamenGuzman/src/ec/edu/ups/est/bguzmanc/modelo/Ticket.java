package ec.edu.ups.est.bguzmanc.modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Ticket
 *
 */
@NamedQuery(name = "findByPlaca", query = "SELECT t FROM Ticket t WHERE t.vehiculo.placa = :placa")
@Entity

public class Ticket implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int numero;
	@Temporal(TemporalType.DATE)
	private Date fechaDeIngreso;
	@Temporal(TemporalType.TIME)
	private Calendar horaDeIngreso;
	@Temporal(TemporalType.DATE)
	private Date fechaDeSalida;
	@Temporal(TemporalType.TIME)
	private Calendar horaDeSalida;
	@ManyToOne
	@JoinColumn
	private Vehiculo vehiculo;

	public Ticket() {
		super();
	}
	

	public Ticket(Date fechaDeIngreso, Calendar horaDeIngreso, Date fechaDeSalida, Calendar horaDeSalida,
			Vehiculo vehiculo) {
		super();
		this.fechaDeIngreso = fechaDeIngreso;
		this.horaDeIngreso = horaDeIngreso;
		this.fechaDeSalida = fechaDeSalida;
		this.horaDeSalida = horaDeSalida;
		this.vehiculo = vehiculo;
	}






	/**
	 * @return the fechaDeIngreso
	 */
	public Date getFechaDeIngreso() {
		return fechaDeIngreso;
	}






	/**
	 * @param fechaDeIngreso the fechaDeIngreso to set
	 */
	public void setFechaDeIngreso(Date fechaDeIngreso) {
		this.fechaDeIngreso = fechaDeIngreso;
	}






	/**
	 * @return the horaDeIngreso
	 */
	public Calendar getHoraDeIngreso() {
		return horaDeIngreso;
	}






	/**
	 * @param horaDeIngreso the horaDeIngreso to set
	 */
	public void setHoraDeIngreso(Calendar horaDeIngreso) {
		this.horaDeIngreso = horaDeIngreso;
	}






	/**
	 * @return the fechaDeSalida
	 */
	public Date getFechaDeSalida() {
		return fechaDeSalida;
	}






	/**
	 * @param fechaDeSalida the fechaDeSalida to set
	 */
	public void setFechaDeSalida(Date fechaDeSalida) {
		this.fechaDeSalida = fechaDeSalida;
	}






	/**
	 * @return the horaDeSalida
	 */
	public Calendar getHoraDeSalida() {
		return horaDeSalida;
	}






	/**
	 * @param horaDeSalida the horaDeSalida to set
	 */
	public void setHoraDeSalida(Calendar horaDeSalida) {
		this.horaDeSalida = horaDeSalida;
	}






	/**
	 * @return the vehiculo
	 */
	public Vehiculo getVehiculo() {
		return vehiculo;
	}






	/**
	 * @param vehiculo the vehiculo to set
	 */
	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}






	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + numero;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ticket other = (Ticket) obj;
		if (numero != other.numero)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Ticket [numero=" + numero + ", fechaDeIngreso=" + fechaDeIngreso + ", horaDeIngreso=" + horaDeIngreso
				+ ", fechaDeSalida=" + fechaDeSalida + ", horaDeSalida=" + horaDeSalida + ", vehiculo=" + vehiculo
				+ "]";
	}


	
   
}
