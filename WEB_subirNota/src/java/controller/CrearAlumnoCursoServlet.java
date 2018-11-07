package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.AlumnoCurso;
import model.Data;

@WebServlet(name = "CrearAlumnoCurso", urlPatterns = {"/crearAlumnoCurso.do"})
public class CrearAlumnoCursoServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            Data d = new Data();
            AlumnoCurso alc = new AlumnoCurso();

            int idCurso = Integer.parseInt(request.getParameter("cmbCursos"));
            int idAlumn = Integer.parseInt(request.getParameter("check"));
            out.print("fkAlumno:" + idAlumn);
            out.print("fkCurso:" + idCurso);

            alc.setFk_curso(idCurso);
            alc.setFk_Alumno(idAlumn);
            d.validarAsignacion(idCurso);

            d.crearAlumnoCurso(alc);
            response.sendRedirect("crearAlumnoCurso.jsp");

        } catch (SQLException ex) {
            Logger.getLogger(CrearAlumnoCursoServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CrearAlumnoCursoServlet.class.getName()).log(Level.SEVERE, null, ex);
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
