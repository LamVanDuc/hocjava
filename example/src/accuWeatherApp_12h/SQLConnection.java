package accuWeatherApp_12h;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLConnection {

    public static Connection getConnectSQLServer() throws SQLException, ClassNotFoundException {
        String databaseName = "AccuWeather";
        String login = "lamduc";
        String password = "123456";
        String instanceName = "LAPTOP-BGF9U42U";
       return getConnectSQLServer(instanceName, login, password, databaseName);

    }

    public static Connection getConnectSQLServer(String instanceName , String login , String password , String databaseName) throws SQLException, ClassNotFoundException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String connectionString = "jdbc:sqlserver://localhost:1433;instance="+instanceName+";databaseName="+databaseName;
        Connection connection = DriverManager.getConnection(connectionString,login,password);


        return connection;

    }


    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        if (getConnectSQLServer() !=null){
            System.out.println("ket noi thanh cong");
        }
        else {
            System.out.println("ket noi khong thanh cong");

        }    }

}
