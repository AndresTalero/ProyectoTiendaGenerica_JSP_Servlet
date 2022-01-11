package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//import javax.swing.JOptionPane;
import Controlador.Conexion;

public class UsuarioDAO {

	Conexion cnn = new Conexion();
	Connection conec = cnn.Conecta();
	PreparedStatement ps = null;
	ResultSet res = null;

	public boolean insertar_Usuario(UsuarioDTO usuario) {

		boolean resul = false;
		UsuarioDTO UsuarioEx = null;

		try {
			UsuarioEx = buscar_Usuario(usuario.getCedulaUsuario());
			if (UsuarioEx == null) {
				String sql = "insert into usuarios values(?,?,?,?,?)";
				ps = conec.prepareStatement(sql);
				ps.setLong(1, usuario.getCedulaUsuario());				
				ps.setString(2, usuario.getEmailUsuario());
				ps.setString(3, usuario.getNombreUsuario());
				ps.setString(4, usuario.getClave());
				ps.setString(5, usuario.getUsuario());
				resul = ps.executeUpdate() > 0; 
			} else {
				//JOptionPane.showMessageDialog(null, "El Usuario ya existe");
			}
		} catch (Exception e) {
			//JOptionPane.showMessageDialog(null, "Error al Registrar al Usuario " + e);
		}
		return resul;
	}

	public UsuarioDTO buscar_Usuario(long cedulaUsuario) {

		UsuarioDTO usu = null;

		try {
			String sql = "select * from usuarios where cedula_usuario=?";
			ps = conec.prepareStatement(sql);
			ps.setLong(1, cedulaUsuario);
			res = ps.executeQuery();

			while (res.next()) {
				usu = new UsuarioDTO(res.getLong(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5));
			}
		} catch (SQLException e) {
			//JOptionPane.showMessageDialog(null, "Error al consultar los datos del Usuario " + e);
		}
		return usu;
	}
	
	//Método para registrar las ventas del usuario que entra al sistema
	
	public UsuarioDTO buscar_cedula(String usuario) {

		UsuarioDTO usu = null;
		try {
			String sql = "select cedula_usuario from usuarios where usuario=?";
			ps = conec.prepareStatement(sql);
			ps.setString(1, usuario);
			res = ps.executeQuery();

			while (res.next()) {
				usu = new UsuarioDTO(res.getLong(1));
			}
		} catch (SQLException e) {
			//JOptionPane.showMessageDialog(null, "Error al consultar la cedula del Usuario " + e);
		}
		return usu;
	}
	
	public boolean actualizar_Usuario(UsuarioDTO usuario) {

		boolean resul = false;
		try {
			String sql = "update usuarios set email_usuario=?, nombre_usuario=?, password_usuario=?, usuario=? where cedula_usuario=?";
			ps = conec.prepareStatement(sql);
			ps.setString(1, usuario.getEmailUsuario());
			ps.setString(2, usuario.getNombreUsuario());
			ps.setString(3, usuario.getClave());
			ps.setString(4, usuario.getUsuario());
			ps.setLong(5, usuario.getCedulaUsuario());
			resul = ps.executeUpdate() > 0; 

		} catch (Exception e) {
			//JOptionPane.showMessageDialog(null, "Error al Actualizar el Usuario " + e);
		}
		return resul;
	}

	public boolean eliminar_Usuario(long cedulaUsuario) {

		boolean resul = false;
		try {
			String sql = "delete from usuarios where cedula_usuario=?";
			ps = conec.prepareStatement(sql);
			ps.setLong(1, cedulaUsuario);
			resul = ps.executeUpdate() > 0;

		} catch (Exception e) {
			//JOptionPane.showMessageDialog(null, "Error al borrar los datos del Usuario " + e);
		}
		return resul;
	}
	
	//Login
	public boolean login_usuarios(String usuario, String password) {
		boolean resultado = false;
		try {
			String sql = "select * from usuarios where usuario=? and password_usuario=?";
			ps = conec.prepareStatement(sql);
			ps.setString(1, usuario);
			ps.setString(2, password);
			res = ps.executeQuery();			
			while(res.next()) {
				resultado = true;
			}
		} catch (Exception e) {
			//JOptionPane.showMessageDialog(null, "Error en la consulta de los datos del Usuario " + e);
		}			
		return resultado;
	}
	
	public ArrayList<UsuarioDTO> listarUsuarios(){
		UsuarioDTO uDTO = null;
		ArrayList<UsuarioDTO> lista = new ArrayList<>();
		try {
			String seleccionar = "SELECT * FROM usuarios";
			ps = conec.prepareStatement(seleccionar);
			res = ps.executeQuery();
			while(res.next()) {
				uDTO = new UsuarioDTO(res.getLong(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5));
				lista.add(uDTO);
			}
		} catch (SQLException sqle) {
			//JOptionPane.showMessageDialog(null, "Error al listar los usuarios en dao. "+sqle);
		}
		return lista;
	}	
}