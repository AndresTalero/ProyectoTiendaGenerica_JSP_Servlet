package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//import javax.swing.JOptionPane;
import Controlador.Conexion;

public class ClienteDAO {

	Conexion cnn = new Conexion();
	Connection conec = cnn.Conecta();
	PreparedStatement ps = null;
	ResultSet res = null;

	public boolean insertar_Cliente(ClienteDTO cliente) {

		boolean resul = false;
		ClienteDTO ClienteEx = null;

		try {
			ClienteEx = buscar_Cliente(cliente.getCedulaCliente());
			if (ClienteEx == null) {
				String sql = "insert into clientes values(?,?,?,?,?)";
				ps = conec.prepareStatement(sql);
				ps.setLong(1, cliente.getCedulaCliente());
				ps.setString(2, cliente.getDireccionCliente());
				ps.setString(3, cliente.getEmailCliente());
				ps.setString(4, cliente.getNombreCliente());
				ps.setString(5, cliente.getTelefonoCliente());
				resul = ps.executeUpdate() > 0; 
			} else {
				//JOptionPane.showMessageDialog(null, "El Cliente ya existe");
			}
		} catch (Exception e) {
			//JOptionPane.showMessageDialog(null, "Error al Registrar al Cliente " + e);
		}
		return resul;
	}

	public ClienteDTO buscar_Cliente(long cedulaCliente) {

		ClienteDTO cli = null;

		try {
			String sql = "select * from clientes where cedula_cliente=?";
			ps = conec.prepareStatement(sql);
			ps.setLong(1, cedulaCliente);
			res = ps.executeQuery();

			while (res.next()) {
				cli = new ClienteDTO(res.getLong(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5));
			}
		} catch (SQLException e) {
			//JOptionPane.showMessageDialog(null, "Error al consultar los datos del Cliente " + e);
		}
		return cli;
	}
	
	public boolean actualizar_Cliente(ClienteDTO cliente) {

		boolean resul = false;
		try {
			String sql = "update clientes set direccion_cliente=?, email_cliente=?, nombre_cliente=?, telefono_cliente=? where cedula_cliente=?";
			ps = conec.prepareStatement(sql);
			ps.setString(1, cliente.getDireccionCliente());
			ps.setString(2, cliente.getEmailCliente());
			ps.setString(3, cliente.getNombreCliente());
			ps.setString(4, cliente.getTelefonoCliente());
			ps.setLong(5, cliente.getCedulaCliente());
			resul = ps.executeUpdate() > 0; 

		} catch (Exception e) {
			//JOptionPane.showMessageDialog(null, "Error al Actualizar el Cliente " + e);
		}
		return resul;
	}

	public boolean eliminar_Cliente(long cedulaCliente) {

		boolean resul = false;
		try {
			String sql = "delete from clientes where cedula_cliente=?";
			ps = conec.prepareStatement(sql);
			ps.setLong(1, cedulaCliente);
			resul = ps.executeUpdate() > 0;

		} catch (Exception e) {
			//JOptionPane.showMessageDialog(null, "Error al Borrar los datos del Cliente " + e);
		}
		return resul;
	}
	
	public ArrayList<ClienteDTO> listarClientes(){
		ClienteDTO cDTO = null;
		ArrayList<ClienteDTO> lista = new ArrayList<>();
		try {
			String seleccionar = "SELECT * FROM clientes";
			ps = conec.prepareStatement(seleccionar);
			res = ps.executeQuery();
			while(res.next()) {
				cDTO = new ClienteDTO(res.getLong(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5));
				lista.add(cDTO);
			}
		} catch (SQLException sqle) {
			//JOptionPane.showMessageDialog(null, "Error al listar los clientes en dao. "+sqle);
		}
		return lista;
	}
}