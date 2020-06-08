package ec.edu.ups.est.bguzmanc.mysql.jpa;

import ec.edu.ups.est.bguzmanc.DAO.ClienteDAO;
import ec.edu.ups.est.bguzmanc.modelo.Cliente;

public class JPAClienteDAO extends JPAGenericDAO<Cliente, String> implements ClienteDAO{

	public JPAClienteDAO() {
		super(Cliente.class);
		// TODO Auto-generated constructor stub
	}
}
