package dao;

import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * This class have method to get and update number of view page Almost methods
 * in this class use the sql command (table [View])
 *
 * @author Minh Thanh
 */
public class ViewCounterDAO {

    public int getNumberOfView() throws SQLException {

        DBContext db = new DBContext();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT * FROM [View]";
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt("numberOfViews");
            }
        } catch (Exception e) {

        } finally {
            db.closeConnection(con, ps, rs);
        }
        return -1;
    }

    public void updateNumberOfView() throws SQLException {
        DBContext db = new DBContext();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            String sql = "UPDATE [View] SET numberOfViews = numberOfViews + 1 ";
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();

        } catch (Exception e) {

        } finally {
            db.closeConnection(con, ps, rs);
        }
    }

    public static void main(String[] args) throws SQLException {
        ViewCounterDAO dao = new ViewCounterDAO();
        int a = dao.getNumberOfView();
        System.out.println(a);
    }
}
