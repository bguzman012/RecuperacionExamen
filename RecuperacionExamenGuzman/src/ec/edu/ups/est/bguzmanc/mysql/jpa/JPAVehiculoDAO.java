package ec.edu.ups.est.bguzmanc.mysql.jpa;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import ec.edu.ups.est.bguzmanc.DAO.VehiculoDAO;
import ec.edu.ups.est.bguzmanc.modelo.Cliente;
import ec.edu.ups.est.bguzmanc.modelo.Ticket;
import ec.edu.ups.est.bguzmanc.modelo.Vehiculo;

public class JPAVehiculoDAO  extends JPAGenericDAO<Vehiculo, String> implements VehiculoDAO {
	
	public JPAVehiculoDAO() {
		super(Vehiculo.class);
		// TODO Auto-generated constructor stub
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Vehiculo> findByCedula(Cliente cliente) {
		
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<Vehiculo> criteriaQuery = criteriaBuilder.createQuery(Vehiculo.class);
		// Se establece la clausula FROM
		Root<Vehiculo> root = criteriaQuery.from(Vehiculo.class);
		criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("cliente"), cliente)); // criteriaQuery.multiselect(root.get(atr))
		// // Se configuran los predicados,
		// combinados por AND
		System.out.println(em.createQuery(criteriaQuery).getResultList());
		
		return em.createQuery(criteriaQuery).getResultList();
		
	}
	
	
	
	


}
