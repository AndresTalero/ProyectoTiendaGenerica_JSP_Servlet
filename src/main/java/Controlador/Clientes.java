package Controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Modelo.ClienteDAO;
import Modelo.ClienteDTO;

@WebServlet("/Clientes")
public class Clientes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Clientes() {
        super();        
    }	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ClienteDAO cliente = new ClienteDAO();

		if (request.getParameter("insertar") != null) {			
			long cedulaCliente;
			String direccionCliente, emailCliente, nombreCliente, telefonoCliente;			

			cedulaCliente = Long.parseLong(request.getParameter("cedulaCliente"));
			direccionCliente = request.getParameter("direccionCliente");
			emailCliente = request.getParameter("emailCliente");
			nombreCliente = request.getParameter("nombreCliente");			
			telefonoCliente = request.getParameter("telefonoCliente");			

			ClienteDTO clienteDTO = new ClienteDTO(cedulaCliente, direccionCliente, emailCliente, nombreCliente, telefonoCliente);

			if (cliente.insertar_Cliente(clienteDTO)) {
				response.sendRedirect("Clientes.jsp?men=Cliente Creado");
			} else {
				response.sendRedirect("Clientes.jsp?men=No se Registro el Cliente");
			}
		}
		
		if (request.getParameter("consultar") != null) {			
			long cedulaCliente = Long.parseLong(request.getParameter("cedulaCliente"));						
			ClienteDTO clien = cliente.buscar_Cliente(cedulaCliente);
			
			if (clien != null) {				
				String direccionCliente, emailCliente, nombreCliente, telefonoCliente;				
				cedulaCliente = clien.getCedulaCliente();
				direccionCliente = clien.getDireccionCliente();
				emailCliente = clien.getEmailCliente();
				nombreCliente = clien.getNombreCliente();
				telefonoCliente = clien.getTelefonoCliente();

				response.sendRedirect("Clientes.jsp?cedulaCliente=" + cedulaCliente + "&&direccionCliente=" + direccionCliente + "&&emailCliente=" + emailCliente
						+ "&&nombreCliente=" + nombreCliente + "&&telefonoCliente=" + telefonoCliente);
			} else {				
				response.sendRedirect("Clientes.jsp?men=Cliente Inexistente");				
			}
		}
		
		if (request.getParameter("actualizar") != null) {				
			String direccionCliente, emailCliente, nombreCliente, telefonoCliente;
			long cedulaCliente;

			cedulaCliente = Long.parseLong(request.getParameter("cedulaCliente"));			
			direccionCliente = request.getParameter("direccionCliente");
			emailCliente = request.getParameter("emailCliente");
			nombreCliente = request.getParameter("nombreCliente");
			telefonoCliente = request.getParameter("telefonoCliente");

			ClienteDTO cli = new ClienteDTO(cedulaCliente, direccionCliente, emailCliente, nombreCliente, telefonoCliente);

			if (cliente.actualizar_Cliente(cli)) {				
				response.sendRedirect("Clientes.jsp?men=Datos del Cliente Actualizados");
			} else {
				response.sendRedirect("Clientes.jsp?men=Cliente Inexistente");
			}
		}

		if (request.getParameter("eliminar") != null) {
			long cedulaCliente;
			cedulaCliente = Long.parseLong(request.getParameter("cedulaCliente"));			
			if (cliente.eliminar_Cliente(cedulaCliente)) {
				response.sendRedirect("Clientes.jsp?men=Datos del Cliente Borrados");
			} else {
				response.sendRedirect("Clientes.jsp?men=Cedula Errada");
			}			
		}
		
		if(request.getParameter("limpiar") !=null) {
			String cedulaCliente, direccionCliente, emailCliente, nombreCliente, telefonoCliente;			
			
			cedulaCliente = "";
			direccionCliente = "";
			emailCliente = "";
			nombreCliente = "";
			telefonoCliente = "";				
												
			response.sendRedirect("Clientes.jsp?cedulaCliente=" + cedulaCliente + "&&direccionCliente=" + direccionCliente + "&&emailCliente=" + emailCliente
					+ "&&nombreCliente=" + nombreCliente + "&&telefonoCliente=" + telefonoCliente);
		}
	}
}