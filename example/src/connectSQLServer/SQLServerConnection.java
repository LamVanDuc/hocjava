package connectSQLServer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLServerConnection {
    public static Connection getSQLServerConnection() throws SQLException, ClassNotFoundException {
        String hostName = "localhost";
        String severName = "LAPTOP-BGF9U42U"; // dùng server name sql
        String database ="bookstore"; // dùng tên của table
        String login = "lamduc"; // tài khoản kết nối
        String password ="123456"; //mk của tài khoản
        Connection connection = getSQLServerConnection(hostName,severName,database,login,password); // gọi hàm connect

        return connection;
    }

    public static Connection getSQLServerConnection(String hostname , String severName , String database , String login , String password) throws SQLException, ClassNotFoundException{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String connectionString = "jdbc:sqlserver://"+hostname+":1433"+
                ";instance="+severName+";databaseName="+database;

        Connection connection = DriverManager.getConnection(connectionString,login,password);

        return connection;

    }
}
