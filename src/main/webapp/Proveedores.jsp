<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Proveedores</title>
<link rel="stylesheet" href="css/estiloOpciones2.css">
</head>
<body>
<%!String nitProveedor = "", ciudadProveedor = "", direccionProveedor = "", nombreProveedor = "",  telefonoProveedor = "",  estado = "";%>

<%
if (request.getParameter("nitProveedor") != null) {
	nitProveedor = request.getParameter("nitProveedor");
	ciudadProveedor = request.getParameter("ciudadProveedor");
	direccionProveedor = request.getParameter("direccionProveedor");		
	nombreProveedor = request.getParameter("nombreProveedor");		
	telefonoProveedor = request.getParameter("telefonoProveedor");		
	if(nitProveedor == "") {
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
	<form action="Proveedores" method="post">
		<div class="titulo">
			<h3>Proveedores</h3>
		</div>
        <div class="contenedorIN">
			<div>
            <label for="">NIT</label>
            <label for="">Nombre Proveedor</label>
            <label for="">Dirección</label>
            </div>
            <div>
            	<input type="text" name="nitProveedor" value="<%=nitProveedor%>" <%=estado%> required>
                <input type="hidden" name="niProveedor" value="<%=nitProveedor%>">
                <input type="text" name="nombreProveedor" value="<%=nombreProveedor%>">
                <input type="text" name="direccionProveedor" value="<%=direccionProveedor%>">
            </div>
            <div>
                <label for="">Teléfono Proveedor</label>
                <label for="">Ciudad Proveedor</label>
            </div>
            <div>
                <input type="text" name="telefonoProveedor" value="<%=telefonoProveedor%>">
                <input type="text" name="ciudadProveedor" value="<%=ciudadProveedor%>">
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