package ec.edu.ups.est.bguzmanc.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Vehiculo
 *
 */
@Entity

public class Vehiculo implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	private String placa;
	private String marca;
	private String modelo;	
	@ManyToOne
	@JoinColumn
	private Cliente cliente;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "vehiculo", fetch=FetchType.LAZY)
	private List<Ticket> tickets;
	
	

	public Vehiculo() {
		super();
		tickets = null;
	}



	/**
	 * @return the placa
	 */
	public String getPlaca() {
		return placa;
	}



	/**
	 * @param placa the placa to set
	 */
	public void setPlaca(String placa) {
		this.placa = placa;
	}



	/**
	 * @return the marca
	 */
	public String getMarca() {
		return marca;
	}



	/**
	 * @param marca the marca to set
	 */
	public void setMarca(String marca) {
		this.marca = marca;
	}



	/**
	 * @return the modelo
	 */
	public String getModelo() {
		return modelo;
	}



	/**
	 * @param modelo the modelo to set
	 */
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}



	/**
	 * @return the cliente
	 */
	public Cliente getCliente() {
		return cliente;
	}



	/**
	 * @param cliente the cliente to set
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	/**
	 * @return the tickets
	 */
	public List<Ticket> getTickets() {
		return tickets;
	}



	/**
	 * @param tickets the tickets to set
	 */
	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((placa == null) ? 0 : placa.hashCode());
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
		Vehiculo other = (Vehiculo) obj;
		if (placa == null) {
			if (other.placa != null)
				return false;
		} else if (!placa.equals(other.placa))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "Vehiculo [placa=" + placa + ", marca=" + marca + ", modelo=" + modelo + ", cliente=" + cliente
				+ ", tickets=" + tickets.toString() + "]";
	}
	
	
   
}
