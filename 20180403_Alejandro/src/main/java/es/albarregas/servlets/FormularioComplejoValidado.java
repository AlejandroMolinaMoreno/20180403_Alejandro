package es.albarregas.servlets;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ale_m
 */
@WebServlet(urlPatterns = {"/fcomplejovali"})
public class FormularioComplejoValidado extends HttpServlet {

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
            String cadena =  request.getParameter("telefono") ;
            
            String mail = request.getParameter("email");
           Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
           Matcher mather = pattern.matcher(mail);
           
           String fecha = request.getParameter("fechaNacimiento");
           Pattern fechaN = Pattern.compile("\\d{1,2}/\\d{1,2}/\\d{4}");
           Matcher mather2 = fechaN.matcher(fecha);
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet FormularioComplejoValidado</title>");   
            out.println("<link rel=\"Stylesheet\" href=\"css/formulario.css\" type=\"text/css\" />");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Datos del Formulario</h1>");
            if (request.getParameter("vehiculo") == null || request.getParameter("nombre") == ""  || cadena.length() <9 || cadena.length()>9 || !cadena.startsWith("6") || mather.find()==false || mather2.find()==false ) {
                out.println("<p style='color:red;'>Algun dato es incorrecto</p><br>");
            }else{
             it=request.getParameterMap().keySet().iterator();
            while(it.hasNext()){
                nombreParametro=(String)it.next();
                out.println(nombreParametro);
                valoresParametro=(String[])request.getParameterMap().get(nombreParametro);
                for(String valorParametro:valoresParametro){
                    out.println(valorParametro);  
                    out.println("</br>");
                }
                out.println("<br>");
            }  
            }
            out.println("<br><a href="+request.getContextPath()+">Inicio </a>");
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
