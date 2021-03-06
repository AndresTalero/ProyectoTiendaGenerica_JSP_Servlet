package Controlador;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
//import javax.swing.JOptionPane;

import Modelo.ProductosDAO;

@WebServlet("/Productos")
@MultipartConfig
public class Productos extends HttpServlet {
	private static final long serialVersionUID = 1L;       
    
    public Productos() {  
    	super(); 
    }
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ProductosDAO produc = new ProductosDAO();
								
		if(request.getParameter("cargar")!=null) {			
			
			Part archivo=request.getPart("archivo");
									
			String Url="C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/";			
			
			//String Url="C:\\Program Files\\Apache Software Foundation\\Tomcat 9.0\\webapps\\Tienda-Generica-Grupo2\\Documentos";		
			
					
			try {
				InputStream file= archivo.getInputStream();
				File copia=new File(Url+"productos.csv");
				FileOutputStream escribir=new FileOutputStream(copia);
				int num=file.read();	
				while(num != -1) {
					escribir.write(num);		
					num=file.read();					
				}
				escribir.close();
				file.close();							
				if(produc.cargar_Productos(Url+"productos.csv")) {
					response.sendRedirect("Productos.jsp?men=Archivo Cargado Exitosamente");
				}else {
					response.sendRedirect("Productos.jsp?men=Error: al cargar el archivo");
				}
			} catch (Exception e) {
				//JOptionPane.showMessageDialog(null,"Error: datos leidos invalidos..."+e);				
			}			
		}		
	}
}