package Controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Modelo.ProveedorDAO;
import Modelo.ProveedorDTO;

@WebServlet("/Proveedores")
public class Proveedor extends HttpServlet {
	private static final long serialVersionUID = 1L;
          
    public Proveedor() {
        super();        
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ProveedorDAO proveed = new ProveedorDAO();

		if (request.getParameter("insertar") != null) {			
			long nitProveedor;
			String ciudadProveedor, direccionProveedor, nombreProveedor, telefonoProveedor;			

			nitProveedor = Long.parseLong(request.getParameter("nitProveedor"));
			ciudadProveedor = request.getParameter("ciudadProveedor");
			direccionProveedor = request.getParameter("direccionProveedor");			
			nombreProveedor = request.getParameter("nombreProveedor");			
			telefonoProveedor = request.getParameter("telefonoProveedor");			

			ProveedorDTO proveeDTO = new ProveedorDTO(nitProveedor, ciudadProveedor, direccionProveedor, nombreProveedor, telefonoProveedor);

			if (proveed.insertar_Proveedor(proveeDTO)) {
				response.sendRedirect("Proveedores.jsp?men=Proveedor Creado");
			} else {
				response.sendRedirect("Proveedores.jsp?men=No se Registro el Proveedor");
			}
		}
		
		if (request.getParameter("consultar") != null) {			
			long nitProveedor = Long.parseLong(request.getParameter("nitProveedor"));						
			ProveedorDTO pro = proveed.buscar_Proveedor(nitProveedor);
			
			if (pro != null) {				
				String ciudadProveedor, direccionProveedor, nombreProveedor, telefonoProveedor;				
				nitProveedor = pro.getNit_proveedor();
				ciudadProveedor = pro.getCiudad_proveedor();
				direccionProveedor = pro.getDireccion_proveedor();				
				nombreProveedor = pro.getNombre_proveedor();
				telefonoProveedor = pro.getTelefono_proveedor();

				response.sendRedirect("Proveedores.jsp?nitProveedor=" + nitProveedor + "&&ciudadProveedor=" + ciudadProveedor + "&&direccionProveedor=" + direccionProveedor
						+ "&&nombreProveedor=" + nombreProveedor + "&&telefonoProveedor=" + telefonoProveedor);
			} else {
				response.sendRedirect("Proveedores.jsp?men=Proveedor Inexistente");
			}
		}
		
		if (request.getParameter("actualizar") != null) {				
			String ciudadProveedor, direccionProveedor, nombreProveedor, telefonoProveedor;	
			long nitProveedor;

			nitProveedor = Long.parseLong(request.getParameter("nitProveedor"));	
			ciudadProveedor = request.getParameter("ciudadProveedor");
			direccionProveedor = request.getParameter("direccionProveedor");			
			nombreProveedor = request.getParameter("nombreProveedor");
			telefonoProveedor = request.getParameter("telefonoProveedor");

			ProveedorDTO pro = new ProveedorDTO(nitProveedor, ciudadProveedor, direccionProveedor, nombreProveedor, telefonoProveedor);

			if (proveed.actualizar_Proveedor(pro)) {				
				response.sendRedirect("Proveedores.jsp?men=Datos del Proveedor Actualizados");
			} else {
				response.sendRedirect("Proveedores.jsp?men=No se Actualizo el Proveedor");
			}
		}

		if (request.getParameter("eliminar") != null) {
			long nitProveedor;
			nitProveedor = Long.parseLong(request.getParameter("nitProveedor"));			
			if (proveed.eliminar_Proveedor(nitProveedor)) {
				response.sendRedirect("Proveedores.jsp?men=Datos del Proveedor Borrados");
			} else {
				response.sendRedirect("Proveedores.jsp?men=NIT Errado");
			}			
		}	
		
		if(request.getParameter("limpiar") !=null) {
			String nitProveedor, ciudadProveedor, direccionProveedor, nombreProveedor, telefonoProveedor;			
			
			nitProveedor = "";
			ciudadProveedor = "";
			direccionProveedor = "";
			nombreProveedor = "";
			telefonoProveedor = "";				
												
			response.sendRedirect("Proveedores.jsp?nitProveedor=" + nitProveedor + "&&ciudadProveedor=" + ciudadProveedor + "&&direccionProveedor=" + direccionProveedor
					+ "&&nombreProveedor=" + nombreProveedor + "&&telefonoProveedor=" + telefonoProveedor);
		}
	}
}