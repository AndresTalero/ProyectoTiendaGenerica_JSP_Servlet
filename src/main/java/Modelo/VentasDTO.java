package Modelo;

public class VentasDTO {
	
	private long codigo_venta;
	private long cedula_cliente;
	private String nombre_cliente;
	private long cedula_usuario;
	private double iva_venta;
	private double total_venta;
	private double valor_venta;		

	public VentasDTO(long cedula_cliente, long cedula_usuario, double iva_venta, double total_venta,
			double valor_venta) {
		
		this.cedula_cliente = cedula_cliente;
		this.cedula_usuario = cedula_usuario;
		this.iva_venta = iva_venta;
		this.total_venta = total_venta;
		this.valor_venta = valor_venta;
	}
	
	public VentasDTO(long cedula_cliente, String nombre_cliente, double total_venta) {
		
		this.cedula_cliente = cedula_cliente;
		this.nombre_cliente = nombre_cliente;
		this.total_venta = total_venta;
	}	
	
	public VentasDTO(double total_venta) {
		
		this.total_venta = total_venta;
	}

	public String getNombre_cliente() {
		return nombre_cliente;
	}

	public void setNombre_cliente(String nombre_cliente) {
		this.nombre_cliente = nombre_cliente;
	}	

	public long getCodigo_venta() {
		return codigo_venta;
	}

	public void setCodigo_venta(long codigo_venta) {
		this.codigo_venta = codigo_venta;
	}

	public long getCedula_cliente() {
		return cedula_cliente;
	}

	public void setCedula_cliente(long cedula_cliente) {
		this.cedula_cliente = cedula_cliente;
	}

	public long getCedula_usuario() {
		return cedula_usuario;
	}

	public void setCedula_usuario(long cedula_usuario) {
		this.cedula_usuario = cedula_usuario;
	}

	public double getIva_venta() {
		return iva_venta;
	}

	public void setIva_venta(double iva_venta) {
		this.iva_venta = iva_venta;
	}

	public double getTotal_venta() {
		return total_venta;
	}

	public void setTotal_venta(double total_venta) {
		this.total_venta = total_venta;
	}

	public double getValor_venta() {
		return valor_venta;
	}

	public void setValor_venta(double valor_venta) {
		this.valor_venta = valor_venta;
	}	
}