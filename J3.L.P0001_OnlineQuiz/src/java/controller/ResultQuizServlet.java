/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.QuizDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Quiz;

/**
 *
 * @author Minh Thanh
 */
@WebServlet(name = "ResultQuizServlet", urlPatterns = {"/result"})
public class ResultQuizServlet extends HttpServlet {

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
            QuizDAO quizDAO = new QuizDAO();
            HttpSession session = request.getSession();
            List<Quiz> list = (List<Quiz>) session.getAttribute("QuestionsGenerated");
            int countCorrect = 0;
            double markOfEachQuestion = (10.0 / list.size());

            for (Quiz quiz : list) {
                //In jsp, we set the name of checkbox is Ans'ID' of each quiz
                int quizID = quiz.getId();
                String[] cbNames = request.getParameterValues("Ans" + quizID);
                String answers = "";
                if (cbNames == null) {
                    continue;
                }
                // connect all value of checkbox
                for (String answer : cbNames) {
                    answers += answer;
                }
                if (quizDAO.isCorrectAnswers(quizID, answers)) {
                    countCorrect += 1;
                }
            }
            // percent of correct question
            double marksOfCorrectQuestions = (markOfEachQuestion * countCorrect);

            String state = "";
            if (marksOfCorrectQuestions >= 5) {
                state += "PASSED";
            } else {
                state += "NOT PASSED";
            }

            String marks = String.format("%.1f", marksOfCorrectQuestions);
            String percents = String.format("%.1f", marksOfCorrectQuestions * 10);

            request.setAttribute("marks", marks);
            request.setAttribute("percent", percents);
            request.setAttribute("state", state);
            request.getRequestDispatcher("view/show-result.jsp").forward(request, response);

        } catch (IOException | SQLException | ServletException ex) {
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
