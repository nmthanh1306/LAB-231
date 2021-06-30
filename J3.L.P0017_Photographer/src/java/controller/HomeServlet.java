/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.GalleryDAO;
import dao.PhotographerInforDAO;
import dao.ShareDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Gallery;
import model.Photographer;
import model.Share;

/**
 *
 * @author Minh Thanh
 */
@WebServlet(name = "HomeServlet", urlPatterns = {"/home"})
public class HomeServlet extends HttpServlet {

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
            //number of gallery will be show in home page
            final int PAGE_SIZE = 3;
            GalleryDAO dao = new GalleryDAO();

            String pageIndex = request.getParameter("index");

            if (pageIndex == null) {
                pageIndex = "1";
            }
            int index = Integer.parseInt(pageIndex);

            int numOfGallery = dao.countGallery();
            int maxPage = numOfGallery / PAGE_SIZE;

            if (numOfGallery % PAGE_SIZE != 0) {
                maxPage += 1;
            }

            request.setAttribute("maxPage", maxPage);
            request.setAttribute("index", index);
            
            //get list of gallery will be display in that page index
            List<Gallery> listGalleryPaging = dao.pagingForGallery(index, PAGE_SIZE);
            List<Gallery> listGallery = dao.getListGallery();
            //get photographer infomation from DAO class
            PhotographerInforDAO pDAO = new PhotographerInforDAO();
            Photographer p = pDAO.getPhotographerInfo();
            // get link share
            ShareDAO shareDAO = new ShareDAO();
            List<Share> shareList = shareDAO.getShare();
            request.setAttribute("ShareList", shareList);
            //give data to homePage.jspv

            request.setAttribute("listGallery", listGallery);
            request.setAttribute("listGalleryPaging", listGalleryPaging);

            request.setAttribute("photographer", p);
            request.getRequestDispatcher("view/homePage.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("err", e.toString());
            request.getRequestDispatcher("view/error.jsp").forward(request, response);
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
