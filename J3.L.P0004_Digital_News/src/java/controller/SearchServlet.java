/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ArticleDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Article;

/**
 *
 * @author Minh Thanh
 */
public class SearchServlet extends HttpServlet {

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

        try {

            final int PAGE_SIZE = 2;
            ArticleDAO dao = new ArticleDAO();
            String txtSearch = request.getParameter("txtSearch");
            String pageIndex = request.getParameter("index");

            if (pageIndex == null) {
                pageIndex = "1";
            }
            
            int index = Integer.parseInt(pageIndex);
            int numOfArticle = dao.countNumberOfArticleFound(txtSearch);
            int maxPage = numOfArticle / PAGE_SIZE;

            if (numOfArticle % PAGE_SIZE != 0) {
                maxPage += 1;
            }
            List<Article> listSearch = dao.getListAticleFound(txtSearch, index, PAGE_SIZE);

            request.setAttribute("listFound", listSearch);
            request.setAttribute("maxPage", maxPage);
            request.setAttribute("txtSearch", txtSearch);
            request.setAttribute("index", index);

            Article newestArticle = dao.getNewestArticle();
            List<Article> top5Articles = dao.getTop5Articles();

            request.setAttribute("currentArticle", newestArticle);
            request.setAttribute("top5Articles", top5Articles);

            request.getRequestDispatcher("view/search.jsp").forward(request, response);

        } catch (Exception e) {

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
