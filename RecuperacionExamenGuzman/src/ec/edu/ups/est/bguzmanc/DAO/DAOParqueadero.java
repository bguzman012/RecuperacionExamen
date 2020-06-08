package ec.edu.ups.est.bguzmanc.DAO;

import ec.edu.ups.est.bguzmanc.mysql.jpa.JPAParqueaderoDAO;

public abstract class DAOParqueadero {

	protected static DAOParqueadero parqueadero = new JPAParqueaderoDAO();

	/**
	 * @return the parqueadero
	 */
	public static DAOParqueadero getParqueadero() {
		return parqueadero;
	}

	public abstract ClienteDAO getClienteDAO();
	
	public abstract TicketDAO getTicketDAO();
	
	public abstract VehiculoDAO getVehiculoDAO();
}
