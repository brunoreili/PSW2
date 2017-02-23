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
import org.hibernate.Session;

/**
 *
 * @author ra21550273
 */
public class CarregaPencel extends HttpServlet {

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
            
            //Id do pincel que se queira buscar
            int idPincel = 2;
            
            //Buscar do banco..
            Pincel pincel;
                        
            //Conectar-se ao banco (Abrindo porta com o Banco de Dados)
            Session sessao = HibernateUtil.getSessionFactory().openSession();
            
            //o métodos .get(a,b) busca no banco pelo nome da classe (a) e a chave primária (b) (do mesmo tipo do id mapeado na classe)
            //Necessita da utilização da typecast antes do .get para forçar o tipo da classe(mesmo nome da classe)
            //Obs: para se usar o método .get é sempre necessário ter a chave primária.
            pincel = (Pincel) sessao.get(Pincel.class, idPincel);
            
            if(pincel == null){
                
                out.println("Não encontrei o pincel de id: " + idPincel);
                
            }else{
                
                out.println("Dados do pincel : " + idPincel + " ");
                out.println("Cor: " + pincel.getCor());
                out.println("Fabricante: " + pincel.getFabricante());
                out.println("Numero de Série: " + pincel.getNum_serie());
                
            }                 
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
