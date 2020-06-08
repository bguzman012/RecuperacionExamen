package ec.edu.ups.est.bguzmanc.DAO;

import java.util.List;

import ec.edu.ups.est.bguzmanc.modelo.Cliente;
import ec.edu.ups.est.bguzmanc.modelo.Vehiculo;

public interface VehiculoDAO extends GenericDAO<Vehiculo, String> {

	List<Vehiculo> findByCedula(Cliente cliente);

}
