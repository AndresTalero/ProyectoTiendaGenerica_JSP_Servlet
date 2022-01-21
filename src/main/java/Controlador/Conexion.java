package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class Conexion {

		private String bd = "tiendagenerica_bd";
		private String url = "jdbc:mysql://localhost:3306/"+bd;
		private String user = "root";
		private String pass = "Weak";
		
		Connection conec=null;
		
		public Connection Conecta() {
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conec = DriverManager.getConnection(url,user,pass);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Error en la Conexión....."+e);
			}
			return conec;
		}
}
	
/*
		//Conexión proyecto Amazon
		private String bd = "grupo25_equipo2";
		private String url = "jdbc:mariadb://grupo25db2.c47knbsonjdi.us-east-2.rds.amazonaws.com/"+bd;
		private String user = "admin";
		private String pass = "Grupo25DB2";
		
		Connection conec=null;
		
		public Connection Conecta() {
			
			try {
				Class.forName("org.mariadb.jdbc.Driver");
				conec = DriverManager.getConnection(url,user,pass);
			} catch (Exception e) {
				//JOptionPane.showMessageDialog(null, "Error en la Conexión....."+e);
			}
			return conec;
		}	
*/