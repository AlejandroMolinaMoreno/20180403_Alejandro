<%-- 
    Document   : saludo.jsp
    Created on : 10-abr-2018, 16:41:53
    Author     : ale_m
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Calendar"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% 
         Calendar horaActual = Calendar.getInstance();
        int hora= horaActual.get(Calendar.HOUR_OF_DAY);
        String saludo=null;
        if (hora >= 7 && hora <=12 ) {
            saludo="Buenos dias"; 
        }else if (hora > 12 && hora <= 21 ){
            saludo="Buenas tardes";
        }else {
            saludo="Buenas noches";
        }
        %>
         <%
if (request.getParameter("sexo").equals("hombre")){
%>
<H1><%=saludo%> señor <%=request.getParameter("nombre")%> </H1>
<%
} else {
%>
<H1><%=saludo%> señora <%=request.getParameter("nombre")%></H1>
<%
}
%>
       <a href="<%=request.getContextPath()%>">Menu principal</a>
    </body>
</html>
