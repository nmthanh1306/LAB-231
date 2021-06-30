/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Share;

/**
 *
 * @author Minh Thanh
 */
public class ShareDAO {

    public ArrayList<Share> getShare() throws SQLException, Exception {

        DBContext db = new DBContext();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Share> shares = new ArrayList<>();
        try {

            String sql = "SELECT * FROM Share";
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Share share = new Share(
                        db.getResource() + rs.getString("icon"),
                        rs.getString("social_network"),
                        rs.getString("url"));
                shares.add(share);
            }
            return shares;

        } catch (SQLException ex) {
            throw ex;
        }
    }
}
