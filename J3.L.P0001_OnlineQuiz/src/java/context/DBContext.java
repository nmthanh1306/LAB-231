package context;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Minh Thanh
 */
public class DBContext {

    private final String serverName = "localhost"; //127.0.0.1
    private final String dbName = "P0001_OnlineQuiz";
    private final String portNumber = "1433";
    private final String userID = "sa";
    private final String password = "sa";

    public Connection getConnection() throws Exception {
        String url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName=" + dbName;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(url, userID, password);
    }
    
//    public Connection getConnection() throws Exception {
//        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//        String url = ("jdbc:sqlserver://"
//                + serverName + ":"
//                + portNumber + ";databaseName="
//                + dbName + ";integratedSecurity=true;");
//
//        return DriverManager.getConnection(url);
//    }

    public void closeConnection(Connection con, PreparedStatement ps, ResultSet rs) throws SQLException {
        if (rs != null && !rs.isClosed()) {
            rs.close();
        }
        if (ps != null && !ps.isClosed()) {
            ps.close();
        }
        if (con != null && !con.isClosed()) {
            con.close();
        }
    }

    public String getResource() {
        return "./resource/images/";
    }
}

/**
 *
 * // Tomcat
 *
 * public class DBContext { InitialContext initCxt; Context envirCxt; String
 * serverName; String port; String username; String password; String dbName;
 * String imgFolder;
 *
 * public DBContext() throws Exception { initCxt = new InitialContext();
 * envirCxt = (Context) initCxt.lookup("java:/comp/env"); serverName = (String)
 * envirCxt.lookup("severName"); port = (String) envirCxt.lookup("port");
 * username = (String) envirCxt.lookup("username"); password = (String)
 * envirCxt.lookup("password"); dbName = (String) envirCxt.lookup("dbName");
 * imgFolder = (String) envirCxt.lookup("imgFolder"); }
 *
 * public Connection getConnection() throws Exception {
 * Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); return
 * DriverManager.getConnection("jdbc:sqlserver://" + serverName + ":" + port +
 * ";databaseName=" + dbName, username, password); }
 *
 * public String getResource() throws Exception { return imgFolder; } }
 */
