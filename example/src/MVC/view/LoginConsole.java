package MVC.view;

import java.sql.SQLException;
import java.util.Scanner;

import MVC.controller.LoginController;
import MVC.entity.Users;

public class LoginConsole {

    LoginController loginController = new LoginController();
    Users users = new Users();
    static Scanner sc;
    public LoginConsole(){
        this.sc = new Scanner(System.in);
    }

    public static int menu(){
        System.out.println("---------------Login--------------");
        System.out.println("1. Login Statement");
        System.out.println("2. Login PrepareStatement");
        System.out.println("3. Exit");
        int choice =readInt(0,3);
        return choice;
    }

    public static int readInt(int min, int max){
        int choice ;
        while (true){
            try {
                choice = Integer.parseInt(sc.nextLine());
                if (choice >=min && choice<=max){
                    break;

                }
            }catch (NumberFormatException e){
                e.getMessage();
            }
        }
        return choice;
    }


    public  void Start()throws SQLException, ClassNotFoundException {
        while (true){
            int choice = menu();
            switch (choice){
                case 0: System.exit(0);break;
                case 1: loginStatement();
                case 2:loginPrepateStatement();
                case 3:System.exit(0);
            }
        }
    }


    private void loginStatement() throws SQLException , ClassNotFoundException {

        System.out.println("Username : ");
        String username = sc.next();
        users.setUsername(username);

        System.out.println("Password : ");
        String password = sc.next();
        users.setPassword(password);

        String result =  loginController.loginStatementController(users);
        System.out.println(result);
    }

    private void loginPrepateStatement() throws SQLException , ClassNotFoundException{
        System.out.println("Username : ");
        String username = sc.next();
        users.setUsername(username);

        System.out.println("Password : ");
        String password = sc.next();
        users.setPassword(password);

        String result =  loginController.loginPrepareController(users);
        System.out.println(result);
    }
}
