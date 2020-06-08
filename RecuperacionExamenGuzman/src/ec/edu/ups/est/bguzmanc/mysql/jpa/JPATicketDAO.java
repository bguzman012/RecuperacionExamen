package ec.edu.ups.est.bguzmanc.mysql.jpa;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import ec.edu.ups.est.bguzmanc.DAO.TicketDAO;
import ec.edu.ups.est.bguzmanc.modelo.Cliente;
import ec.edu.ups.est.bguzmanc.modelo.Ticket;
import ec.edu.ups.est.bguzmanc.modelo.Vehiculo;

public class JPATicketDAO extends JPAGenericDAO<Ticket, Integer> implements TicketDAO{

	public JPATicketDAO() {
		super(Ticket.class);
		// TODO Auto-generated constructor stub
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<Ticket> findByPlaca(Vehiculo vehiculo) {
		
		
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<Ticket> criteriaQuery = criteriaBuilder.createQuery(Ticket.class);
		// Se establece la clausula FROM
		Root<Ticket> root = criteriaQuery.from(Ticket.class);
		criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("vehiculo"), vehiculo)); // criteriaQuery.multiselect(root.get(atr))
		// // Se configuran los predicados,
		// combinados por AND
		System.out.println(em.createQuery(criteriaQuery).getResultList());
		
		return em.createQuery(criteriaQuery).getResultList();
		
	}
	

}
