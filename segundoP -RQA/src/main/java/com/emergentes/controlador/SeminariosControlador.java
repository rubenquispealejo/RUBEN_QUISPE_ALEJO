
package com.emergentes.controlador;

import com.emergentes.dao.SeminariosDAO;
import com.emergentes.dao.SeminariosDAOimpl;
import com.emergentes.modelo.Seminarios;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SeminariosControlador", urlPatterns = {"/SeminariosControlador"})
public class SeminariosControlador extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         try {
            SeminariosDAO dao = new SeminariosDAOimpl();
            Seminarios se = new Seminarios();
            int id;
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            switch (action) {
                case "add":
                    request.setAttribute("seminarios", se);
                    request.getRequestDispatcher("frmseminario.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    se = dao.getById(id);
                    request.setAttribute("seminarios", se);
                    request.getRequestDispatcher("frmseminario.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect("SeminariosControlador");
                    break;
                case "view":
                    List<Seminarios> lista = dao.getAll();
                    request.setAttribute("seminarios", lista);
                    request.getRequestDispatcher("Seminarios.jsp").forward(request, response);
                    break;                
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String titulo = request.getParameter("titulo");
        String fecha = request.getParameter("fecha");
        int cupo = Integer.parseInt(request.getParameter("cupo"));
        Seminarios se = new Seminarios();
        se.setId(id);
        se.setTitulo(titulo);
        se.setFecha(fecha);
        se.setCupo(cupo);
        SeminariosDAO dao = new SeminariosDAOimpl();
        
            if (id == 0) {
            try {
                // Nuevo
                dao.insert(se);
            } catch (Exception ex) {
                System.out.println("Error al Insertar: "  + ex.getMessage());
            }
        } else {
            try {
                // Edicion
                dao.update(se);
            } catch (Exception ex) {
                System.out.println("Error al Actualizar: " + ex.getMessage());
            }
        }
        
        response.sendRedirect("SeminariosControlador");
      
    }

}
