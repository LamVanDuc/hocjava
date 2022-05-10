package MVC;

import MVC.view.LoginConsole;
import MVC.view.ProductConsole;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) throws SQLException, IOException, ParseException, ClassNotFoundException {
        System.out.println("1 . User ");
        System.out.println("2 . Product ");
        System.out.println("choice : ");
        int i = new Scanner(System.in).nextInt();
        switch (i){
            case 1:new LoginConsole().Start();break;
            case 2: new ProductConsole().start();break;
            default: System.exit(0);
        }
    }
}
