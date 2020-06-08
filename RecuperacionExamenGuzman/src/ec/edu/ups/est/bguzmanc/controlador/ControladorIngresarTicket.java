package ec.edu.ups.est.bguzmanc.controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.est.bguzmanc.DAO.DAOParqueadero;
import ec.edu.ups.est.bguzmanc.DAO.TicketDAO;
import ec.edu.ups.est.bguzmanc.DAO.VehiculoDAO;
import ec.edu.ups.est.bguzmanc.modelo.Ticket;
import ec.edu.ups.est.bguzmanc.modelo.Vehiculo;

/**
 * Servlet implementation class ControladorIngresarTicket
 */
@WebServlet("/ControladorIngresarTicket")
public class ControladorIngresarTicket extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorIngresarTicket() {
        super();
        // TODO Auto-generated constructor stub
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String fecha_in = request.getParameter("date_in");
		String hora_in = request.getParameter("hora_in");
		String fecha_out = request.getParameter("date_out");
		String hora_out = request.getParameter("hora_out");
		System.out.println(fecha_in);
		System.out.println(hora_in);
		System.out.println(fecha_out);
		System.out.println(hora_out);
		String placa = request.getParameter("vehiculo");
		VehiculoDAO vehiculoDAO = DAOParqueadero.getParqueadero().getVehiculoDAO();
		Vehiculo vehi = vehiculoDAO.read(placa);
		System.out.println(vehi);
		TicketDAO ticketDAO = DAOParqueadero.getParqueadero().getTicketDAO();
		
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		Date date = null;
		try {
			date = sdf.parse(hora_in);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Calendar calendar = GregorianCalendar.getInstance();
		calendar.setTime(date);
		Date date_salida = null;
		try {
			date_salida = sdf.parse(hora_out);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Calendar calendar_salida = GregorianCalendar.getInstance();
		calendar_salida.setTime(date_salida);
		
		SimpleDateFormat objSDF = new SimpleDateFormat("yyyy-mm-dd"); 
		Date fecha_entrada = null;
		try {
			fecha_entrada = objSDF.parse(fecha_in);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Date fecha_salida = null;
		try {
			fecha_salida = objSDF.parse(fecha_out);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Ticket ticket = new Ticket(fecha_entrada, calendar, fecha_salida, calendar_salida, vehi);
		
		ticketDAO.create(ticket);
		
		 PrintWriter out;
		 response.setContentType("text/html");
		 out = response.getWriter();
		 out.println("<HTML><HEAD><TITLE>");
		 out.println("Respuesta");
		 out.println("</TITLE>");
		 out.println("<style>");     // start style
		  // enclose style attributes withing the <style> </style> elements
		  
		 out.println("h1 {");        // note leading brace
		  out.println("color:cyan;");
		  out.println("background-color: #333;");
		  out.println("border: 1px solid black;");
		  out.println("}");
		  out.println("body {");
		  out.println("background-color: #333; }");
		  out.println("a {");
		  out.println("margin-left: 109px;");
		  out.println("color: cyan;");
		  out.println("}");
		  
		  out.println("</style>");  // terminate style
		  out.println("</HEAD><BODY>");
		
		 out.println("<H1> Se ha registrado el ticket correctamente </H1>");
		 out.println("<a href=\"JSPs/IngresarTicket.jsp\">Ingresar otro ticket</a>");
		 out.println("<br>");
		 out.println("<a href=\"/RecuperacionExamenGuzman/index.html\">Volver al inicio</a>");
		
		 out.println("</BODY></HTML>");
		 out.close();
		 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
