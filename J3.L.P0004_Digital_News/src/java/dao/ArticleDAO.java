/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import context.DBContext;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Article;

/**
 *
 * @author Minh Thanh
 */
public class ArticleDAO {

    DBContext db = new DBContext();
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public Article getNewestArticle() throws SQLException {

        try {
            String sql = "SELECT TOP 1 * FROM Article\n"
                    + "ORDER BY publish_date DESC";
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Article a = new Article(
                        rs.getInt("id"),
                        rs.getString("title"),
                        db.getResource() + rs.getString("image"),
                        rs.getString("content"),
                        rs.getDate("publish_date"),
                        rs.getTime("publish_date"),
                        rs.getString("author"));
                return a;
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            db.closeConnection(con, ps, rs);
        }
        return null;
    }

    public List getTop5Articles() throws SQLException {

        try {
            List<Article> listArticle = new ArrayList<>();
            String sql = "SELECT TOP 5 * FROM Article\n"
                    + "WHERE publish_date NOT IN(\n"
                    + "SELECT MAX(publish_date) from Article)\n"
                    + "ORDER BY publish_date DESC";
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Article a = new Article(
                        rs.getInt("id"),
                        rs.getString("title"),
                        db.getResource() + rs.getString("image"),
                        rs.getString("content"),
                        rs.getDate("publish_date"),
                        rs.getTime("publish_date"),
                        rs.getString("author"));
                listArticle.add(a);
            }
            return listArticle;
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            db.closeConnection(con, ps, rs);
        }
        return null;
    }

    public Article getAnArticleByID(int id) throws SQLException {

        try {
            String sql = "SELECT * FROM Article\n"
                    + "WHERE id = ?";
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
                Article a = new Article(
                        rs.getInt("id"),
                        rs.getString("title"),
                        db.getResource() + rs.getString("image"),
                        rs.getString("content"),
                        rs.getDate("publish_date"),
                        rs.getTime("publish_date"),
                        rs.getString("author"));
                return a;
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            db.closeConnection(con, ps, rs);
        }
        return null;
    }

    public int countNumberOfArticleFound(String txtSearch) throws Exception {

        try {
            String sql = "SELECT COUNT(*) AS [numOfArticle]\n"
                    + "FROM Article\n"
                    + "WHERE title LIKE ?";
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + txtSearch + "%");
            rs = ps.executeQuery();
            int numOfArticle = 0;
            while (rs.next()) {
                numOfArticle = rs.getInt("numOfArticle");
            }
            return numOfArticle;
        } catch (Exception e) {
            throw e;
        } finally {
            db.closeConnection(con, ps, rs);
        }
    }

    //paging
    public List<Article> getListAticleFound(String txtSearch, int pageIndex, int pageSize) throws Exception {
        try {
            List<Article> listArticle = new ArrayList<>();
            String sql = "SELECT * FROM (\n"
                    + "               SELECT ROW_NUMBER()\n"
                    + "               OVER(ORDER BY id) AS [No.] , *\n"
                    + "               FROM Article\n"
                    + "               WHERE title LIKE ?)\n"
                    + "AS DataSearch WHERE [No.] BETWEEN ?*?-? AND ?*?";
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + txtSearch + "%");
            ps.setInt(2, pageIndex);
            ps.setInt(3, pageSize);
            ps.setInt(4, pageSize - 1);
            ps.setInt(5, pageIndex);
            ps.setInt(6, pageSize);
            rs = ps.executeQuery();

            while (rs.next()) {
                Article a = new Article(
                        rs.getInt("id"),
                        rs.getString("title"),
                        db.getResource() + rs.getString("image"),
                        rs.getString("content"),
                        rs.getDate("publish_date"),
                        rs.getTime("publish_date"),
                        rs.getString("author"));
                listArticle.add(a);
            }
            return listArticle;
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            db.closeConnection(con, ps, rs);
        }
        return null;
    }

    public static void main(String[] args) throws SQLException {
        ArticleDAO dao = new ArticleDAO();
        Article a = dao.getNewestArticle();
        System.out.println(a);
    }

}
