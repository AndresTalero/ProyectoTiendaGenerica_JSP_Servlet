package Controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import Modelo.ClienteDAO;
import Modelo.ClienteDTO;
import Modelo.UsuarioDAO;
import Modelo.UsuarioDTO;
import Modelo.VentasDAO;
import Modelo.VentasDTO;

@WebServlet("/Reportes")
public class Reportes extends HttpServlet {
	private static final long serialVersionUID = 1L;       
    
    public Reportes() {
        super();        
    }	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String opcion = request.getParameter("opcionjs");
		PrintWriter escribir = response.getWriter();
		Gson datos = new Gson();
		
		if(opcion.equals("Usuarios")) {
			UsuarioDAO uDAO = new UsuarioDAO();
			ArrayList<UsuarioDTO> listaU = new ArrayList<>();
			listaU = uDAO.listarUsuarios();
			escribir.println(datos.toJson(listaU));
		}
		
		if(opcion.equals("Clientes")) {
			ClienteDAO cDAO = new ClienteDAO();
			ArrayList<ClienteDTO> listaC = new ArrayList<>();
			listaC = cDAO.listarClientes();
			escribir.println(datos.toJson(listaC));
		}
		
		if(opcion.equals("Ventas")) {
			VentasDAO vDAO = new VentasDAO();
			ArrayList<VentasDTO> listaV = new ArrayList<>();
			listaV = vDAO.listarVentas();
			escribir.println(datos.toJson(listaV));
		}
		
		if(opcion.equals("Total")) {
			VentasDAO vDAO = new VentasDAO();
			ArrayList<VentasDTO> listaTotV = new ArrayList<>();			
			listaTotV = vDAO.totalVentas();				
			escribir.println(datos.toJson(listaTotV));			
		}
	}
}