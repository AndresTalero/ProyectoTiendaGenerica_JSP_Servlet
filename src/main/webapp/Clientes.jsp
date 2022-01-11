<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Clientes</title>
<link rel="stylesheet" href="css/estiloOpciones2.css">
</head>
<body>
<%!String cedulaCliente = "", direccionCliente = "", emailCliente = "", nombreCliente = "", telefonoCliente = "", estado = "";%>

<%
if (request.getParameter("cedulaCliente") != null) {
	cedulaCliente = request.getParameter("cedulaCliente");
	direccionCliente = request.getParameter("direccionCliente");
	emailCliente = request.getParameter("emailCliente");
	nombreCliente = request.getParameter("nombreCliente");		
	telefonoCliente = request.getParameter("telefonoCliente");		
	if(cedulaCliente == "") {
		estado = "enabled";
	}
	else{
		estado = "disabled";
	}
}
%>	
	
<div class="titulo">
	<h1>Tienda Genérica</h1>
</div>
<header>
	<nav>
		<ul>
			<li><a href="Usuarios.jsp">Usuarios</a></li>
			<li><a href="Clientes.jsp">Clientes</a></li>
			<li><a href="Proveedores.jsp">Proveedores</a></li>
			<li><a href="Productos.jsp">Productos</a></li>
			<li><a href="Ventas.jsp">Ventas</a></li>
			<li><a href="Reportes.jsp">Reportes</a></li>
			<li><a href="index.jsp">Cerrar sesión</a></li>
		</ul>
	</nav>
</header>	
	
<div class="contendor-fluid">
	<form action="Clientes" method="post">
    	<div class="titulo">
			<h3>Clientes</h3>
		</div>
        <div class="contenedorIN">
        	<div>
            	<label for="">Cédula</label>
                <label for="">Nombre Completo</label>
                <label for="">Dirección</label>
            </div>
            <div>
                <input type="text" name="cedulaCliente" value="<%=cedulaCliente%>" <%=estado%> required>
                <input type="hidden" name="cedCliente" value="<%=cedulaCliente%>">
                <input type="text" name="nombreCliente" value="<%=nombreCliente%>">
            	<input type="text" name="direccionCliente" value="<%=direccionCliente%>">
            </div>
			<div>
			    <label for="">Teléfono</label>
                <label for="">Correo Electrónico</label>
            </div>
            <div>
            	<input type="text" name="telefonoCliente" value="<%=telefonoCliente%>">                    
                <input type="email" name="emailCliente" value="<%=emailCliente%>">
			</div>
		</div>
        <div class="contenedorBotones">
        	<input type="submit" name="consultar" value="Consultar">
            <input type="submit" name="insertar" value="Crear">
            <input type="submit" name="actualizar" value="Actualizar">
            <input type="submit" name="eliminar" value="Borrar">
            <input type="submit" name="limpiar" value="Limpiar">
     	</div>
	</form>
</div>	

<%
if (request.getParameter("men") != null) {
	String mensaje = request.getParameter("men");
	out.print("<script>alert('" + mensaje + "');</script>");
}
%>

</body>
</html>