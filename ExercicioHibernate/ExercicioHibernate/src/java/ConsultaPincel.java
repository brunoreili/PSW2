/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author ra21550273
 */
public class ConsultaPincel extends HttpServlet {

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
            out.println("<title>Servlet ConsultaPincel</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ConsultaPincel at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
            
            Session s = HibernateUtil.getSessionFactory().openSession();
            
            // CRITERIA é o "método" pelo qual o Hibernate identifica tabelas (e faz "selects") sem que seja pela chave primária.
            Criteria criteria = s.createCriteria(Pincel.class);
            //criteria.add(Restrictions.eq("cor", "azul")); // .add neste caso está colocando restrição do tipo igual (.eq = equals).
                                                          // Os parâmetros são; A coluna da tabela (variavel correspondente) e o valor que se queira comparar.
            
            List<Pincel> result = criteria.list(); //Cria uma lista de dados com os resultados buscados.
            
            out.println("Pinceis encontrados: <br/>");
            
            for(Pincel p : result){ //Para cada Pincel (p) da lista result...
                out.println("<br> Pincel num: " + p.getNum_serie());
                out.println("<br> Cor: " + p.getCor());
                out.println("<br/>");
            }
            
            s.close();          
            
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
