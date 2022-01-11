$(document).ready(function(){
	
	function listarUsuarios(){
		$.ajax({
			type:"post",
			url:"Reportes",
			dataType:"json",
			data:{opcionjs:"Usuarios"},
			success: function(result){
				console.log(result)
				var tabla=document.getElementById("tabla")
				tabla.innerHTML=''
				tabla.innerHTML+=`<tr>
				<th>Cedula</th>
				<th>Correo</th>
				<th>Nombre</th>
				<th>Password</th>
				<th>Usuario</th>
				</tr>`
				for(let fila of result){
					tabla.innerHTML+=`<tr>
					<td>${fila.cedulaUsuario}</td>
					<td>${fila.emailUsuario}</td>
					<td>${fila.nombreUsuario}</td>
					<td>${fila.clave}</td>
					<td>${fila.usuario}</td>
					</tr>`
				}
			}
		})
	}
	
	function listarClientes(){
		$.ajax({
			type:"post",
			url:"Reportes",
			dataType:"json",
			data:{opcionjs:"Clientes"},
			success: function(result){
				console.log(result)
				var tabla=document.getElementById("tabla")
				tabla.innerHTML=''
				tabla.innerHTML+=`<tr>
				<th>Cedula</th>
				<th>Direccion</th>				
				<th>Correo</th>				
				<th>Nombre</th>
				<th>Telefono</th>
				</tr>`
				for(let fila of result){
					tabla.innerHTML+=`<tr>
					<td>${fila.cedulaCliente}</td>
					<td>${fila.direccionCliente}</td>
					<td>${fila.emailCliente}</td>
					<td>${fila.nombreCliente}</td>					
					<td>${fila.telefonoCliente}</td>
					</tr>`
				}
			}
		})
	}
	
	function listarVentas(){
		$.ajax({
			type:"post",
			url:"Reportes",
			dataType:"json",
			data:{opcionjs:"Ventas"},
			success: function(result){
				console.log(result)
				var tabla=document.getElementById("tabla")
				tabla.innerHTML=''
				tabla.innerHTML+=`<tr>				
				<th>Cedula Cliente</th>
				<th>Nombre Cliente</th>				
				<th>Total Ventas</th>						
				</tr>`
				for(let fila of result){
					tabla.innerHTML+=`<tr>					
					<td>${fila.cedula_cliente}</td>	
					<td>${fila.nombre_cliente}</td>				
					<td>${fila.total_venta}</td>								
					</tr>`
				}
			}
		})
	}
	
	function totalVentas(){
		$.ajax({
			type:"post",
			url:"Reportes",
			dataType:"json",
			data:{opcionjs:"Total"},
			success: function(result){
				console.log(result)
				var tabla=document.getElementById("tabla")
				tabla.innerHTML=''
				tabla.innerHTML+=`<tr>				
				<th>Total Ventas de la Tienda $</th>								
				</tr>`
				for(let fila of result){
					tabla.innerHTML+=`<tr>								
					<td>${fila.total_venta}</td>								
					</tr>`
				}
			}
		})
	}
	
	$('#listarUsuarios').on('click',function(){
			listarUsuarios();
		})
	
	$('#listarClientes').on('click',function(){
			listarClientes();
		})
	
	$('#listarVentas').on('click',function(){
			listarVentas();			
		})	
		
	$('#totalVentasTienda').on('click',function(){
			totalVentas();			
		})	
})