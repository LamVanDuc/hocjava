package MVC.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLServerConnection {

    public static Connection getSQLServerConnection() throws SQLException, ClassNotFoundException{
        String hostname="localhost";
        String databaseName = "DBtest";
        String instanceName = "LAPTOP-BGF9U42U";
        String login = "lamduc";
        String password = "123456";

        return getSQLServerConnection(hostname ,databaseName , instanceName , login , password);

    }
    public static Connection getSQLServerConnection(String hostname , String databaseName , String instanceName , String login , String password) throws SQLException , ClassNotFoundException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

        String connectionString = "jdbc:sqlserver://"+hostname+":1433;instance="+instanceName+";databaseName="+databaseName
                +";integrated security = true";

        Connection connection = DriverManager.getConnection(connectionString,login,password);
        return connection;

    }
}
