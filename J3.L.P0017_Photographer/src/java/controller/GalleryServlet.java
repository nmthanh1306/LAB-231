/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.GalleryDAO;
import dao.ImageDAO;
import dao.ShareDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Gallery;
import model.Image;
import model.Share;

/**
 *
 * @author Minh Thanh
 */
@WebServlet(name = "GalleryServlet", urlPatterns = {"/gallery"})
public class GalleryServlet extends HttpServlet {

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

            GalleryDAO gDAO = new GalleryDAO();
            ImageDAO iDAO = new ImageDAO();

            final int PAGE_SIZE = 8;

            // receive parameter from request 
            String pageIndex = request.getParameter("index");
            int galleryID = Integer.parseInt((String) request.getParameter("id"));

            if (pageIndex == null) {
                pageIndex = "1";
            }
            int index = Integer.parseInt(pageIndex);

            // get the number of image in one gallery
            int numOfImageInOneGallery = iDAO.countImageInOneGallery(galleryID);
            int maxPage = numOfImageInOneGallery / PAGE_SIZE;

            if (numOfImageInOneGallery % PAGE_SIZE != 0) {
                maxPage += 1;
            }

            // get link share
            ShareDAO shareDAO = new ShareDAO();
            List<Share> shareList = shareDAO.getShare();
            request.setAttribute("ShareList", shareList);

            //get a gallery by it id
            Gallery g = gDAO.getGalleryByID(galleryID);
            List<Gallery> listGallery = gDAO.getListGallery();
            List<Image> listImage = iDAO.pagingForListImageInOneGallery(galleryID, index, PAGE_SIZE);

            //give data to gallery.jsp
            request.setAttribute("maxPage", maxPage);
            request.setAttribute("index", index);
            request.setAttribute("listGallery", listGallery);
            request.setAttribute("listImage", listImage);
            request.setAttribute("gallery", g);

            request.getRequestDispatcher("view/gallery.jsp").forward(request, response);
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
