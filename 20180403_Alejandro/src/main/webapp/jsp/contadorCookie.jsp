<%-- 
    Document   : contadorCookie.jsp
    Created on : 12-abr-2018, 16:24:59
    Author     : ale_m
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../css/formulario.css" type="text/css">
        <title>Contador Cookie</title>
    </head>
    <body>
    <div id="Cuadro">
        <h1>Contador de visitas por cookie</h1>
        <% 
    Cookie contador = null;
    Cookie[] cookies = request.getCookies();
    int valorCookie=0;
    if (request.getParameter("Eliminar") != null){
        contador = new Cookie ("contador" , "1");
    }else{
    for (Cookie miCookie : cookies){
        if (miCookie.getName().equals("contador")){
            valorCookie = Integer.parseInt(miCookie.getValue());
        }else{
             contador = new Cookie("contador" , "0");
            }
        }
    }
    valorCookie++;
    contador.setValue(String.valueOf(valorCookie));
    contador.setMaxAge(24 * 60 * 60);
    response.addCookie(contador);
        
        if (contador.getValue().equals("1")){
        %>
        <h1>Se ha visitado la página <%= contador.getValue() %> vez</h1>
        <h1>Nombre : <%= contador.getName() %></h1>
        <h1>Ruta : <%= contador.getPath() %></h1>
        <h1>Caduca : <%= contador.getMaxAge()%></h1>
        <h1>Seguro : <%= contador.getSecure()%></h1>
        <h1>Version : <%= contador.getVersion() %></h1>
        <% } else {
        %>
        <h1> Se ha visitado la página <%= contador.getValue() %> veces</h1>
        <% }
        %>
        <form action="contadorCookie.jsp">
        <a href="contadorCookie.jsp"><input type="button" name="Recargar" value="Recargar"></a>
          <input type="submit" name="Eliminar" value="Eliminar">
          <button> <a href="<%=request.getContextPath()%>">Menu principal</a></button>
        </form>
    </div>
            
    </body>
</html>
