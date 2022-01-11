package Controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Modelo.UsuarioDAO;
import Modelo.UsuarioDTO;

@WebServlet("/Usuarios")
public class Usuarios extends HttpServlet {
	private static final long serialVersionUID = 1L;
           
    public Usuarios() {
        super();        
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UsuarioDAO usu = new UsuarioDAO();

		if (request.getParameter("insertar") != null) {			
			long cedulaUsuario;
			String emailUsuario, nombreUsuario, clave, usuario;			

			cedulaUsuario = Long.parseLong(request.getParameter("cedulaUsuario"));			
			emailUsuario = request.getParameter("emailUsuario");			
			nombreUsuario = request.getParameter("nombreUsuario");
			clave = request.getParameter("clave");
			usuario = request.getParameter("usuario");			

			UsuarioDTO usuDTO = new UsuarioDTO(cedulaUsuario, emailUsuario, nombreUsuario, clave, usuario);

			if (usu.insertar_Usuario(usuDTO)) {
				response.sendRedirect("Usuarios.jsp?men=Usuario Creado");
			} else {
				response.sendRedirect("Usuarios.jsp?men=No se Registro el Usuario");
			}
		}
		
		if (request.getParameter("consultar") != null) {			
			long cedulaUsuario = Long.parseLong(request.getParameter("cedulaUsuario"));						
			UsuarioDTO usua = usu.buscar_Usuario(cedulaUsuario);
			
			if (usua != null) {				
				String emailUsuario, nombreUsuario, clave, usuario;				
				cedulaUsuario = usua.getCedulaUsuario();				
				emailUsuario = usua.getEmailUsuario();
				nombreUsuario = usua.getNombreUsuario();
				clave = usua.getClave();
				usuario = usua.getUsuario();

				response.sendRedirect("Usuarios.jsp?cedulaUsuario=" + cedulaUsuario + "&&emailUsuario=" + emailUsuario + "&&nombreUsuario=" + nombreUsuario
						+ "&&clave=" + clave + "&&usuario=" + usuario);
			} else {
				response.sendRedirect("Usuarios.jsp?men=Usuario Inexistente");
			}
		}
		
		if (request.getParameter("actualizar") != null) {				
			String emailUsuario, nombreUsuario, clave, usuario;
			long cedulaUsuario;

			cedulaUsuario = Long.parseLong(request.getParameter("cedulaUsuario"));				
			emailUsuario = request.getParameter("emailUsuario");
			nombreUsuario = request.getParameter("nombreUsuario");
			clave = request.getParameter("clave");
			usuario = request.getParameter("usuario");

			UsuarioDTO usua = new UsuarioDTO(cedulaUsuario, emailUsuario, nombreUsuario, clave, usuario);

			if (usu.actualizar_Usuario(usua)) {				
				response.sendRedirect("Usuarios.jsp?men=Datos del Usuario Actualizados");
			} else {
				response.sendRedirect("Usuarios.jsp?men=Usuario Inexistente");
			}
		}

		if (request.getParameter("eliminar") != null) {
			long cedulaUsuario;
			cedulaUsuario = Long.parseLong(request.getParameter("cedulaUsuario"));			
			if (usu.eliminar_Usuario(cedulaUsuario)) {
				response.sendRedirect("Usuarios.jsp?men=Datos del Usuario Borrados");
			} else {
				response.sendRedirect("Usuarios.jsp?men=Cedula Errada");
			}		
		}
		
		if(request.getParameter("limpiar") !=null) {
			String cedulaUsuario, emailUsuario, nombreUsuario, clave, usuario;			
			
			cedulaUsuario = "";
			emailUsuario = "";
			nombreUsuario = "";
			clave = "";
			usuario = "";				
									
			response.sendRedirect("Usuarios.jsp?cedulaUsuario=" + cedulaUsuario + "&&emailUsuario=" + emailUsuario + "&&nombreUsuario=" + nombreUsuario
					+ "&&clave=" + clave + "&&usuario=" + usuario);
		}
	}
}