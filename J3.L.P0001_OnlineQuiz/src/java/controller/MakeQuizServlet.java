/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.QuizDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Account;
import model.Quiz;

/**
 *
 * @author Minh Thanh
 */
public class MakeQuizServlet extends HttpServlet {

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
        try {
            response.setContentType("text/html;charset=UTF-8");
            request.setCharacterEncoding("UTF-8");

            //get session to get the name of admin account
            HttpSession session = request.getSession();
            Account a = (Account) session.getAttribute("Account");
            QuizDAO quizDAO = new QuizDAO();
            String questionRequest = request.getParameter("question");
            String option1Request = request.getParameter("opt1");
            String option2Request = request.getParameter("opt2");
            String option3Request = request.getParameter("opt3");
            String option4Request = request.getParameter("opt4");
            String[] answers = request.getParameterValues("answer");

            String question = questionRequest.replaceAll("\\s{2,}", " ").trim();
            String option1 = option1Request.replaceAll("\\s{2,}", " ").trim();
            String option2 = option2Request.replaceAll("\\s{2,}", " ").trim();
            String option3 = option3Request.replaceAll("\\s{2,}", " ").trim();
            String option4 = option4Request.replaceAll("\\s{2,}", " ").trim();

            String resultCheck = checkEmptyFields(question, option1, option2, option3, option4, answers);
            // if result of check is empty means that NO fields are empty
            if (resultCheck.equals("")) {
                String answer = "";
                for (String ans : answers) {
                    answer += ans;
                }
                java.sql.Date dateCreated = new java.sql.Date(new java.util.Date().getTime()); // java.sql.Date
                Quiz quiz = new Quiz(0, question, option1, option2, option3, option4, answer, dateCreated, a.getUsername());

                quizDAO.insertNewQuiz(quiz);
                request.setAttribute("msg", "Add new quiz successfully!");

            } else { // result has message -> some field are empty
                request.setAttribute("question", questionRequest);
                request.setAttribute("opt1", option1Request);
                request.setAttribute("opt2", option2Request);
                request.setAttribute("opt3", option3Request);
                request.setAttribute("opt4", option4Request);
                request.setAttribute("msg", resultCheck);
            }
            request.getRequestDispatcher("view/make-quiz.jsp").forward(request, response);
        } catch (SQLException ex) {
            request.setAttribute("err", ex);
            request.getRequestDispatcher("component/errorPage.jsp").forward(request, response);
        }
    }

    private String checkEmptyFields(String question, String opt1, String opt2,
            String opt3, String opt4, String[] answers) {

        String msg = "";
        if (question.equals("") || opt1.equals("") || opt2.equals("")
                || opt3.equals("") || opt4.equals("")) {
            msg += "All fields can't be empty";
        }
        if (answers == null) {
            msg += "</br>Answer(s) must be choose";
        }
        if(answers.length == 4){
            msg += "</br>Answer(s) must < 4 answers";
        }
        return msg;
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
