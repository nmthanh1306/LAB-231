package listener;

import dao.ViewCounterDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * This class implemented HttpSessionListener to count number of view in life
 * cycle session listener
 *
 * @author Minh Thanh
 */
public class ViewCounter implements HttpSessionListener {

    /** 
     * When session is created(access to web site), update and get number of view in database
     * 
     * @param se
     */
    @Override
    public void sessionCreated(HttpSessionEvent se) {

        try {
            ViewCounterDAO dao = new ViewCounterDAO();
            dao.updateNumberOfView();
            String s = String.format("%06d", dao.getNumberOfView());
            
            // split string of number of views, each number is 1 member of array
            String arr[] = s.split("");
            se.getSession().setAttribute("views", arr);
        } catch (SQLException e) {
   
        }
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
    }

}
