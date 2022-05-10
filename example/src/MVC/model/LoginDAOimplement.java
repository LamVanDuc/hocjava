package MVC.model;

import MVC.DAO.SQLServerConnection;
import MVC.entity.Users;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginDAOimplement implements LoginDAO{


    @Override
    public String checkLoginStatement(Users users) throws  SQLException, ClassNotFoundException {
        Connection connection = SQLServerConnection.getSQLServerConnection();

        String query ="select username from account where username = '"+users.getUsername()+"'" +
                " and password ='"+users.getPassword()+"'";

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);



        while(resultSet.next()){
            System.out.println("Login thanh cong: "+resultSet.getString("username"));
            return users.getUsername();
        }
        return "fail";
    }

    @Override
    public String checkloginPrepareStatement(Users users) throws  SQLException, ClassNotFoundException {
        Connection connection = SQLServerConnection.getSQLServerConnection();

        String query ="select username from account where username = '"+users.getUsername()+"'" +
                " and password ='"+users.getPassword()+"'";

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);



        while(resultSet.next()){
            System.out.println("Login thanh cong: "+resultSet.getString("username"));
            return users.getUsername();
        }
        return "fail";
    }
}
