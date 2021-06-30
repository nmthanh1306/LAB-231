package dal;

import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import model.Quiz;

/**
 *
 * @author Minh Thanh
 */
public class QuizDAO {

    /**
     * get all of Quizzes in database
     *
     * @return
     * @throws java.sql.SQLException
     */
    public List<Quiz> getAllQuiz() throws SQLException {

        DBContext db = new DBContext();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            List<Quiz> list = new ArrayList<>();
            String sql = "SELECT * FROM Quiz";
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Quiz q = new Quiz(
                        rs.getInt("id"),
                        rs.getString("question"),
                        rs.getString("option1"),
                        rs.getString("option2"),
                        rs.getString("option3"),
                        rs.getString("option4"),
                        rs.getString("answers"),
                        rs.getDate("dateCreated"),
                        rs.getString("username"));
                list.add(q);
            }
            return list;
        } catch (Exception e) {

        } finally {
            db.closeConnection(con, ps, rs);
        }
        return null;
    }

    /**
     * check the answers are correct or not by quiz id and its answer(s)
     *
     * @param quizID
     * @param answers
     * @return
     * @throws java.sql.SQLException
     */
    public boolean isCorrectAnswers(int quizID, String answers) throws SQLException {
        QuizDAO quizDAO = new QuizDAO();
        List<Quiz> list = quizDAO.getAllQuiz();
        
        for (Quiz quiz : list) {
            if (quiz.getId() == quizID
                    && quiz.getAnswers().equalsIgnoreCase(answers)) {
                return true;
            }
        }
        return false;
    }

    public void insertNewQuiz(Quiz quiz) throws SQLException {
        
        DBContext db = new DBContext();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {

            String sql = "INSERT INTO Quiz VALUES(?,?,?,?,?,?,?,?)";
            
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, quiz.getQuestion());
            ps.setString(2, quiz.getOption1());
            ps.setString(3, quiz.getOption2());
            ps.setString(4, quiz.getOption3());
            ps.setString(5, quiz.getOption4());
            ps.setString(6, quiz.getAnswers());
            ps.setDate(7, quiz.getDateCreated());
            ps.setString(8, quiz.getUsername());
            
            ps.executeUpdate();
         
        } catch (Exception e) {

        } finally {
            db.closeConnection(con, ps, rs);
        }
    }

    public static void main(String[] args) throws SQLException {
        QuizDAO quizDAO = new QuizDAO();
        List<Quiz> list = quizDAO.getAllQuiz();
        // shuffle list question
        Collections.shuffle(list);
        // new sub list contain number of questions that user entered

        List<Quiz> subList = list.subList(0, 11);

        for (Quiz quiz : subList) {
            System.out.println(quiz.toString());
        }
    }

}
