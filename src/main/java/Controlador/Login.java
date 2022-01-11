package Controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Modelo.UsuarioDAO;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static String usua;
	public Login() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UsuarioDAO userDao = new UsuarioDAO();

		if (request.getParameter("enviar") != null) {
			String usuario, password;
			usuario = request.getParameter("usuario");
			password = request.getParameter("clave");	
			usua=usuario;
			if(userDao.login_usuarios(usuario, password)) {
				response.sendRedirect("Menu.jsp");
			} else {
				response.sendRedirect("login.jsp?men=Datos Incorrectos");
			}
		}
	}
}