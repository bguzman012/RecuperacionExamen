package ec.edu.ups.est.bguzmanc.DAO;

import java.util.List;

import ec.edu.ups.est.bguzmanc.modelo.Ticket;
import ec.edu.ups.est.bguzmanc.modelo.Vehiculo;

public interface TicketDAO extends GenericDAO<Ticket, Integer>{

	List<Ticket> findByPlaca(Vehiculo vehiculo);

}
