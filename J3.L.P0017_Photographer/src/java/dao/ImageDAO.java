package dao;

import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Image;

/**
 * This class is Data Access Object allows to access Data Source Almost methods
 * in this class use the sql command to get data from Database
 *
 * @author Minh Thanh
 */
public class ImageDAO {

    /**
     * get list of image in a gallery through gallery id
     *
     * This method call in GalleryDAO
     *
     * @param gid
     * @return
     * @throws java.sql.SQLException
     */
    public List<Image> getListImageInGalleryByID(int gid) throws SQLException {

        DBContext db = new DBContext();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ArrayList<Image> list = new ArrayList<>();
            String sql = "SELECT * FROM Image WHERE gid = ?";
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, gid);
            rs = ps.executeQuery();

            while (rs.next()) {
                Image i = new Image(
                        rs.getInt("id"),
                        rs.getInt("gid"),
                        db.getResource() + rs.getString("image_Path"),
                        rs.getString("content"));
                list.add(i);
            }
            return list;
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            db.closeConnection(con, ps, rs);
        }
        return null;
    }

    /**
     * count and return number of image in gallery
     *
     * @param gid
     * @return
     * @throws java.sql.SQLException
     */
    public int countImageInOneGallery(int gid) throws SQLException {
        DBContext db = new DBContext();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT COUNT(*) AS [numOfImage]\n"
                    + "FROM Image WHERE gid = ?";
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, gid);
            rs = ps.executeQuery();
            int numOfGallery = 0;
            while (rs.next()) {
                numOfGallery = rs.getInt("numOfImage");
            }
            return numOfGallery;
        } catch (Exception e) {

        } finally {
            db.closeConnection(con, ps, rs);
        }
        return -1;
    }

    /**
     * This method to paging list of image in one gallery
     *
     * @param gid
     * @param pageIndex
     * @param pageSize
     * @return
     * @throws java.sql.SQLException
     */
    public List<Image> pagingForListImageInOneGallery(int gid, int pageIndex, int pageSize) throws SQLException {

        DBContext db = new DBContext();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ArrayList<Image> list = new ArrayList<>();
            String sql = "SELECT * FROM (\n"
                    + "               SELECT ROW_NUMBER()\n"
                    + "               OVER(ORDER BY id) AS [No.] , *\n"
                    + "               FROM Image\n"
                    + "               WHERE gid = ?)\n"
                    + "AS t WHERE [No.] BETWEEN ?*?-? AND ?*?";
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, gid);
            ps.setInt(2, pageIndex);
            ps.setInt(3, pageSize);
            ps.setInt(4, pageSize - 1);
            ps.setInt(5, pageIndex);
            ps.setInt(6, pageSize);
            rs = ps.executeQuery();

            while (rs.next()) {
                Image i = new Image(
                        rs.getInt("id"),
                        rs.getInt("gid"),
                        db.getResource() + rs.getString("image_Path"),
                        rs.getString("content"));
                list.add(i);
            }
            return list;
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            db.closeConnection(con, ps, rs);
        }
        return null;
    }
}
