/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ale_m
 */
@WebServlet(urlPatterns = {"/registro"})
public class registro extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String nombreParametro=null;
            String[]valoresParametro=null;
            Iterator it;
            String nombre= request.getParameter("nombre");
            String cadena =  request.getParameter("telefono") ;
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet registro</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<form action=\"registro\" method=\"post\">");
            
            if (nombre == ""){
               
               out.println(" <p><label for=\"nombre\"> Nombre </label>&nbsp;&nbsp;");
               out.println( "<input type=\"text\" id  value= \""+nombre+"\"    > ");
               out.println("</br>");
                    
           
            }else{
               out.println(" <p><label for=\"nombre\"> Nombre </label>&nbsp;&nbsp;");
               out.println(request.getParameter("nombre"));
            }
             if (request.getParameter("apellido")==""){
               
               out.println(" <p><label for=\"apellido\"> Apellido </label>&nbsp;&nbsp;");
               out.println( "<input type=\"text\" id  value= \""+request.getParameter("apellido")+"\"    > ");
               out.println("</br>");
                    
           
            }else{
               out.println(" <p><label for=\"nombre\"> Apellido </label>&nbsp;&nbsp;");
               out.println(request.getParameter("apellido"));
            }
             
             if (request.getParameter("usuario")==""){
                 out.println(" <p><label for=\"usuario\"> Usuario </label>&nbsp;&nbsp;");
               out.println( "<input type=\"text\" id  value= \""+request.getParameter("usuario")+"\"    > ");
               out.println("</br>");
             }else{
                 out.println(" <p><label for=\"usuario\"> Usuario </label>&nbsp;&nbsp;");
               out.println(request.getParameter("usuario"));
             }
             
             if (request.getParameter("contrasena")==""){
                  out.println(" <p><label for=\"contraseña\"> Contraseña </label>&nbsp;&nbsp;");
               out.println( "<input type=\"text\" id  value= \""+request.getParameter("contrasena")+"\"    > ");
               out.println("</br>");
             }else{
                 out.println(" <p><label for=\"contraseña\"> Contraseña </label>&nbsp;&nbsp;");
               out.println(request.getParameter("contrasena"));
             }
             
             if (cadena.length() != 9 || !cadena.startsWith("6") || !cadena.startsWith("7") || !cadena.startsWith("9")) {
                  out.println(" <p><label for=\"telefono\"> Telefono </label>&nbsp;&nbsp;");
               out.println( "<input type=\"text\" id  value= \""+request.getParameter("telefono")+"\"    > ");
               out.println("</br>");
             }else{
                out.println(" <label for=\"telefono\"> Telefono </label>&nbsp;&nbsp;");
               out.println(request.getParameter("telefono")); 
             }
             if (request.getParameter("sexo")==null){
                 out.println("<label>Sexo :</label> &nbsp;&nbsp;");
                out.println("<label>Hombre :</label>&nbsp;&nbsp;");
                out.println("<input type=\"radio\" name=\"sexo\" value=\"hombre\" >");
                out.println("<label>Mujer :</label>&nbsp;&nbsp;");
                out.println("<input type=\"radio\" name=\"sexo\" value=\"mujer\" >");
                
             }else{
                  out.println(" <p><label for=\"sexo\"> sexo </label>&nbsp;&nbsp;");
             out.println(request.getParameter("sexo"));
             }
              
             if (request.getParameter("preferencia")==null){
                out.println("<label>Preferencias :</label>&nbsp;&nbsp;");
                    out.println("<label>Deporte</label>&nbsp;&nbsp;");
                    out.println("<input type=\"checkbox\" name=\"preferencia\" value=\"Deporte\">");
                    out.println("<label>Lectura</label>&nbsp;&nbsp;");
                            out.println("<input type=\"checkbox\" name=\"preferencia\" value=\"Lectura\">");
                    out.println("<label>Cine</label>&nbsp;&nbsp;");
                            out.println("<input type=\"checkbox\" name=\"preferencia\" value=\"Cine\">");
                   out.println("<label>Deporte</label>&nbsp;&nbsp;");
                            out.println("<input type=\"checkbox\" name=\"preferencia\" value=\"Viajes\">");
                   
             }else{
                  out.println(" <p><label for=\"preferencias\"> preferencias </label>&nbsp;&nbsp;");
            out.println(request.getParameter("preferencia"));
             }
            
            out.println("<input type=\"submit\" name=\"enviar\" value=\"Enviar\">");
                    out.println("<input type=\"reset\" name=\"borrar\" value=\"borrar\">");
                    out.println("</form>");
                    
            out.println("<h1>Servlet registro at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        
            }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
