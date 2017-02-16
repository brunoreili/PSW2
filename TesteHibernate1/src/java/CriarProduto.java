/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session; // Hibernate Session
import org.hibernate.Transaction; // Hibernate Transaction

/**
 *
 * @author ra21550273
 */
public class CriarProduto extends HttpServlet {

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
            out.println("<title>Servlet CriarProduto</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CriarProduto at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
            
            //Criar tabela
            Produto pteste = new Produto();
            pteste.setFabricante("pilot");
            pteste.setNome("pincel azul");
            pteste.setPreco(1);
            pteste.setId(0);
            
            //Conectar com o banco
            Session sessao = HibernateUtil.getSessionFactory().openSession();
            
            //Criar ponto de Transação (Ponto de Restauração "CheckPoint") - BANCO DE DADOS
            Transaction tx = sessao.beginTransaction();
            
            try{
                //Armazena no Hibernate (Não salva no banco) - HIBERNATE
                sessao.save(pteste);
                //Despacha para o banco de dados (Salva no banco efetivamente) - HIBERNATE PARA BANCO DE DADOS
                sessao.flush();
            
                //Confirmação do banco de dados - BANCO DE DADOS
                tx.commit();  
            } catch(Exception e){
                //Usar o ponto de Restauralção
                tx.rollback(); 
            }        
            
            //Fechar a sessão
            sessao.close();
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
