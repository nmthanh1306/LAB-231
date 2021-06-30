package dao;

import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Gallery;
import model.Image;

/**
 * This class is Data Access Object allows to access Data Source Almost methods
 * in this class use the sql command to get data from Database
 *
 * @author Minh Thanh
 *
 */
public class GalleryDAO {

    /**
     * Get one gallery by it id
     *
     * @param id
     * @return
     * @throws java.sql.SQLException
     */
    public Gallery getGalleryByID(int id) throws SQLException {

        DBContext db = new DBContext();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ImageDAO iDAO = new ImageDAO();

        try {
            String sql = "SELECT * FROM Gallery WHERE ID = ?";
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            //get list image by func getListImageInGalleryByID(int gid)
            while (rs.next()) {
                List<Image> listImage = new ArrayList<>();
                Gallery g = new Gallery(
                        rs.getInt("id"),
                        rs.getString("gallery_title"),
                        rs.getString("content"),
                        db.getResource() + rs.getString("main_image"),
                        listImage = iDAO.getListImageInGalleryByID(rs.getInt("id")));
                return g;
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            db.closeConnection(con, ps, rs);
        }
        return null;
    }

    /**
     * Get list of gallery
     *
     * @return
     * @throws java.sql.SQLException
     */
    public List getListGallery() throws SQLException {

        DBContext db = new DBContext();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            List<Gallery> list = new ArrayList<>();
            String sql = "SELECT * FROM Gallery";
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            //get list image by func getListImageInGalleryByID(int gid)
            while (rs.next()) {
                Gallery g = new Gallery(
                        rs.getInt("id"),
                        rs.getString("gallery_title"),
                        rs.getString("content"),
                        db.getResource() + rs.getString("main_image"));
                list.add(g);
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
     * count and return number of gallery
     *
     * @return
     * @throws java.sql.SQLException
     */
    public int countGallery() throws SQLException {
        DBContext db = new DBContext();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ArrayList<Image> list = new ArrayList<>();
            String sql = "SELECT COUNT(*) AS [numOfGallery]\n"
                    + "FROM Gallery";
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            int numOfGallery = 0;
            while (rs.next()) {
                numOfGallery = rs.getInt("numOfGallery");
            }
            return numOfGallery;
        } catch (Exception e) {

        } finally {
            db.closeConnection(con, ps, rs);
        }
        return -1;
    }

    public List<Gallery> pagingForGallery(int pageIndex, int pageSize) {
        DBContext db = new DBContext();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            List<Gallery> list = new ArrayList<>();
            String sql = "SELECT * FROM (\n"
                    + "               SELECT ROW_NUMBER()\n"
                    + "               OVER(ORDER BY id) AS [No.] , *\n"
                    + "               FROM Gallery)\n"
                    + "AS t WHERE [No.] BETWEEN ?*?-? AND ?*?";
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, pageIndex);
            ps.setInt(2, pageSize);
            ps.setInt(3, pageSize - 1);
            ps.setInt(4, pageIndex);
            ps.setInt(5, pageSize);
            rs = ps.executeQuery();
            while (rs.next()) {
                Gallery g = new Gallery(
                        rs.getInt("id"),
                        rs.getString("gallery_title"),
                        rs.getString("content"),
                        db.getResource() + rs.getString("main_image"));
                list.add(g);
            }
            return list;
        } catch (Exception e) {

        }
        return null;
    }
}
