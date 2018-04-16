/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ale_m
 */
@WebServlet(name = "ContadorSesion", urlPatterns = {"/contador"})
public class ContadorSesion extends HttpServlet {

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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<link rel=\"stylesheet\" href=\"css/formulario.css\" type=\"text/css\">");
            out.println("<title>Contador sesion</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1> Contador de visitas por Sesion</h1>");
            HttpSession sesion = request.getSession(true);
            int valorSesion = 0;
            if(request.getParameter("eliminar") != null){
                sesion.removeAttribute("contador");
            }else{
                if(sesion.getAttribute("contador") != null){
                    valorSesion = (Integer)sesion.getAttribute("contador");
                }
                valorSesion++;
                sesion.setAttribute("contador", new Integer(valorSesion));
            }
            if(sesion.getAttribute("contador")==null){
                sesion.setAttribute("contador", new Integer("1"));
            }
            if(sesion.getAttribute("contado")!=null && sesion.getAttribute("contador").equals("1")){
                out.println("La pagina a sido visitada " + sesion.getAttribute("contador") + "vez");
            }else{
                out.println("La pagina a sido visitada " + sesion.getAttribute("contador") + "veces");
            }
            
            
            out.println("<form action=\"contador\" >");
            out.println("<a href=\"contador\" ><input type=\"button\" name=\"recargar\" value=\"recargar\"></a>");
            out.println("<input type=\"submit\" name=\"eliminar\" value=\"eliminar\">");
            out.println("<button><a href="+request.getContextPath()+ " > Menu principal </a></button>");
            out.println("</form>");
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
