<%-- 
    Document   : fecha.jsp
    Created on : 10-abr-2018, 17:19:09
    Author     : ale_m
--%>

<%@page import="java.util.Calendar"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
            <%
                String fecha= request.getParameter("fecha");
                 
                %>
                <%
                    
                     Calendar fechaActual = Calendar.getInstance();
                     int año = fechaActual.get(Calendar.YEAR);
                     int mes = fechaActual.get(Calendar.MONTH) + 1;
                     int dia = fechaActual.get(Calendar.DAY_OF_MONTH);
                     int añoV = Integer.parseInt(fecha.substring(0, 4)); 
                     int mesV = Integer.parseInt(fecha.substring(6, 7));
                     int diaV = Integer.parseInt(fecha.substring(9, 10));
                    %>
                <h1><%=fecha%></h1>
               <%
                 int añosVividos = año - añoV;
                 int mesesVividos =mes - mesV;
                 int diasVividos =diaV - diaV;
                 %>
              
                    
                <h1>La fecha actual es <%=año%>-<%=mes%>-<%=dia%> </h1> 
                <h1>Los años vividos son <%= añosVividos %></h1>
                <h1>Los meses vividos son <%=mesesVividos%></h1>
                <h1>Los dias vividos son <%=diasVividos%></h1>
               
    </body>
</html>
