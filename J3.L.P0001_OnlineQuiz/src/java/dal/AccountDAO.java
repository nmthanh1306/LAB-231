package dal;

import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Account;

/**
 *
 * @author Minh Thanh
 */
public class AccountDAO {

    public List<Account> getAllAccounts() throws SQLException {

        DBContext db = new DBContext();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            List<Account> list = new ArrayList<>();
            String sql = "SELECT * FROM Account";
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Account a = new Account(
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("email"),
                        rs.getInt("role"));
                list.add(a);
            }
            return list;
        } catch (Exception e) {

        } finally {
            db.closeConnection(con, ps, rs);
        }
        return null;
    }

    public Account getAccountByUsername(String username) throws SQLException {

        DBContext db = new DBContext();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT * FROM Account WHERE username = ?";
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, username);
            rs = ps.executeQuery();
            while (rs.next()) {
                Account a = new Account(
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("email"),
                        rs.getInt("role"));
                return a;
            }

        } catch (Exception e) {

        } finally {
            db.closeConnection(con, ps, rs);
        }
        return null;
    }

    public void createNewAccount(Account acc) throws SQLException {

        DBContext db = new DBContext();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            String sql = "INSERT INTO Account VALUES(?,?,?,?)";
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, acc.getUsername());
            ps.setString(2, acc.getPassword());
            ps.setString(3, acc.getEmail());
            ps.setInt(4, acc.getRole());
            ps.executeUpdate();

        } catch (Exception e) {

        } finally {
            db.closeConnection(con, ps, rs);
        }
    }

    public boolean isExistAccount(String username, String password) throws SQLException {

        List<Account> list = getAllAccounts();
        for (Account account : list) {
            if (account.getUsername().equals(username)
                    && account.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public boolean isExistUsername(Account a) throws SQLException {
        List<Account> list = getAllAccounts();
        for (Account account : list) {
            if (account.getUsername().equals(a.getUsername())) {
                return true;
            }
        }
        return false;
    }

    public boolean isExistEmail(Account a) throws SQLException {
        List<Account> list = getAllAccounts();
        for (Account account : list) {
            if (account.getEmail().equals(a.getEmail())) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws SQLException {
        AccountDAO a = new AccountDAO();
        List<Account> list = a.getAllAccounts();
        Account acc = a.getAccountByUsername("admin");
        System.out.println(acc);
//        for (Account account : list) {
//            System.out.println(account);
//        }
    }
}
