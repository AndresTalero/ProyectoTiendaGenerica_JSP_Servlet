package Modelo;

public class UsuarioDTO {
	
	private long cedulaUsuario;
	private String emailUsuario;
	private String nombreUsuario;	
	private String clave;
	private String usuario;
	
	public UsuarioDTO(long cedulaUsuario, String emailUsuario, String nombreUsuario, String clave, String usuario) {
		
		this.cedulaUsuario = cedulaUsuario;
		this.emailUsuario = emailUsuario;
		this.nombreUsuario = nombreUsuario;
		this.clave = clave;
		this.usuario = usuario;
	}
	
	public UsuarioDTO(long cedulaUsuario) {
		
		this.cedulaUsuario = cedulaUsuario;
	}

	public long getCedulaUsuario() {
		return cedulaUsuario;
	}

	public void setCedulaUsuario(long cedulaUsuario) {
		this.cedulaUsuario = cedulaUsuario;
	}

	public String getEmailUsuario() {
		return emailUsuario;
	}

	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}	
}