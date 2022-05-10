package MVC.controller;

import java.sql.SQLException;
import MVC.entity.Users;
import MVC.model.LoginDAOimplement;

public class LoginController {
    LoginDAOimplement loginDAOimplement = new LoginDAOimplement();

    public  String loginStatementController(Users users) throws SQLException, ClassNotFoundException {

        return loginDAOimplement.checkLoginStatement(users);
    }

    public String loginPrepareController(Users users) throws SQLException, ClassNotFoundException {
        return loginDAOimplement.checkloginPrepareStatement(users);
    }


}
