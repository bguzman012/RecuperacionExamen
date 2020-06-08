package ec.edu.ups.est.bguzmanc.controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.est.bguzmanc.DAO.ClienteDAO;
import ec.edu.ups.est.bguzmanc.DAO.DAOParqueadero;
import ec.edu.ups.est.bguzmanc.DAO.TicketDAO;
import ec.edu.ups.est.bguzmanc.DAO.VehiculoDAO;
import ec.edu.ups.est.bguzmanc.modelo.Cliente;
import ec.edu.ups.est.bguzmanc.modelo.Ticket;
import ec.edu.ups.est.bguzmanc.modelo.Vehiculo;

/**
 * Servlet implementation class Controlador
 */
@WebServlet("/ControladorBuscarTicket")
public class ControladorBuscarTicket extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorBuscarTicket() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String name = request.getParameter("opcion");
		String parametro = request.getParameter("parametro");
		
		if(name.equals("CedulaCliente")) {
	
			ClienteDAO clienteDAO = DAOParqueadero.getParqueadero().getClienteDAO();
			Cliente cli = new Cliente(); 
			cli = clienteDAO.read(parametro);
			VehiculoDAO vehiculoDAO = DAOParqueadero.getParqueadero().getVehiculoDAO();
			List<Vehiculo> vehiculos = vehiculoDAO.findByCedula(cli);
			
			request.setAttribute("cliente", cli);
			request.setAttribute("vehiculos", vehiculos);
			
		}else {
			VehiculoDAO vehiculoDAO = DAOParqueadero.getParqueadero().getVehiculoDAO();
			Vehiculo vehiculo = new Vehiculo();
			vehiculo = vehiculoDAO.read(parametro);
			List<Vehiculo> vehiculos = vehiculoDAO.findByCedula(vehiculo.getCliente());
			request.setAttribute("cliente", vehiculo.getCliente());
			request.setAttribute("vehiculos", vehiculos);
			
		}
		
		request.getRequestDispatcher("JSPs/ListarTickets.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
