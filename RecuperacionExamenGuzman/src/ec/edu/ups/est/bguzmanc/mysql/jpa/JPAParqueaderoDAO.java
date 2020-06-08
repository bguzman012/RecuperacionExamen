package ec.edu.ups.est.bguzmanc.mysql.jpa;

import ec.edu.ups.est.bguzmanc.DAO.ClienteDAO;
import ec.edu.ups.est.bguzmanc.DAO.DAOParqueadero;
import ec.edu.ups.est.bguzmanc.DAO.TicketDAO;
import ec.edu.ups.est.bguzmanc.DAO.VehiculoDAO;

public class JPAParqueaderoDAO extends DAOParqueadero {

	@Override
	public ClienteDAO getClienteDAO() {
		// TODO Auto-generated method stub
		return new JPAClienteDAO();
	}

	@Override
	public TicketDAO getTicketDAO() {
		// TODO Auto-generated method stub
		return new JPATicketDAO();
	}

	@Override
	public VehiculoDAO getVehiculoDAO() {
		// TODO Auto-generated method stub
		return new JPAVehiculoDAO();
	}

}
