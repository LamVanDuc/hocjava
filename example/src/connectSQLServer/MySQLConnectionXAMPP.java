package connectSQLServer;

import java.sql.*;

public class MySQLConnectionXAMPP {
    public static Connection getMySQLConnection()throws SQLException, ClassNotFoundException  {
        String databaseName = "productmanegement";
        String userName = "root";
        String password = "";
        return getMySQLConnection( databaseName , userName , password);
    }

    public static Connection getMySQLConnection( String databaseName , String username , String password) throws SQLException, ClassNotFoundException{


        Class.forName("com.mysql.cj.jdbc.Driver");
        String connectionString = "jdbc:mysql://localhost:3306/"+databaseName;
        Connection connection = DriverManager.getConnection(connectionString,username,password);

        return connection;
    }

    public static void main(String[] args) throws SQLException , ClassNotFoundException {
        Connection connection = MySQLConnectionXAMPP.getMySQLConnection();

        Statement statement  = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("select * from employee");

        if (resultSet != null){
            System.out.printf("%-5s %-10s %s \n","ID" , "Emp No" ,"Emp Name");
            while (resultSet.next()){
                int eID = resultSet.getInt("empID");
                String empNo = resultSet.getString("empNo");
                String name = resultSet.getString("name");
                System.out.printf("%-5d %-10s %s \n",eID, empNo,name);
            }
        }
        else {
            System.out.println("That bai !");
        }


    }
}
