package MVC.model;

import MVC.entity.Users;

import java.io.IOException;
import java.sql.SQLException;

public interface LoginDAO {
    public String checkLoginStatement(Users users) throws IOException, SQLException, ClassNotFoundException;
    public String checkloginPrepareStatement(Users users) throws  IOException, SQLException, ClassNotFoundException;
}
