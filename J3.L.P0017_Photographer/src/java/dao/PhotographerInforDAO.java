package dao;

import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Photographer;

/**
 * This class is Data Access Object allows to access Data Source
 * Almost methods in this class use the sql command to get data from Database
 * 
 * @author Minh Thanh
 * 
 */
public class PhotographerInforDAO {

    /**
     * get all Information of photographer
     *
     * @return
     * @throws java.sql.SQLException
     */
    public Photographer getPhotographerInfo() throws SQLException {

        DBContext db = new DBContext();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT * FROM Photographer";
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Photographer p = new Photographer(
                        rs.getString("name"),
                        rs.getString("address"),
                        rs.getString("city"),
                        rs.getString("country"),
                        rs.getInt("tel"),
                        rs.getString("email"),
                        rs.getString("aboutMe"),
                        rs.getString("map"),
                        db.getResource() + rs.getString("feature_Image"),
                        rs.getString("title_Feature_Image"));
                return p;
            }
        } catch (Exception e) {

        } finally {
            db.closeConnection(con, ps, rs);
        }
        return null;
    }
}
