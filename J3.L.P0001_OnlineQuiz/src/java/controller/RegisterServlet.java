/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.AccountDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Account;

/**
 * this servlet class to register new account, get all necessary information to
 * insert into database
 *
 * @author Minh Thanh
 */
public class RegisterServlet extends HttpServlet {

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
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String email = request.getParameter("email");
            String sRole = request.getParameter("role");
            int role = 0;
            if (sRole.equals("teacher")) {
                role = 1;
            } else if (sRole.equals("student")) {
                role = 2;
            }
            AccountDAO dao = new AccountDAO();
            Account a = new Account(username, password, email, role);

            // if one of username or email that user entered are existed, send error message
            String err = "";
            if (dao.isExistUsername(a)) {
                err += "Username '" + a.getUsername() + "' is existed, please try again </br>";
            }
            if (dao.isExistEmail(a)) {
                err += "Email '" + a.getEmail() + "' is existed, please try again";
            }
            if (!dao.isExistUsername(a) && !dao.isExistEmail(a)) {
                dao.createNewAccount(a);
                request.setAttribute("msg", "Create new account successfully!");
            }
            request.setAttribute("err", err);
            request.getRequestDispatcher("view/register-account.jsp").forward(request, response);
        } catch (Exception ex) {
            request.setAttribute("err", ex);
            request.getRequestDispatcher("component/errorPage.jsp").forward(request, response);
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
