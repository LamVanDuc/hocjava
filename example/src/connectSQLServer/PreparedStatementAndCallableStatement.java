package connectSQLServer;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class PreparedStatementAndCallableStatement {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        // kết nối với database (ở đây là XAMPP)
        Connection connection = MySQLConnectionXAMPP.getMySQLConnection();


        // cách đọc dữ liệu 2 chiều "cuộn"

//        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE , ResultSet.CONCUR_READ_ONLY);
//        String selectAllEmployee = "SELECT * FROM employee";
//        ResultSet resultSet = statement.executeQuery(selectAllEmployee);

//=========================== PreparedStatement ===========================================================================
        // PreparedStatement : thực thi các câu lệnh truy vấn sql động và có tham số truyền vào.


//        String selectAllEmployee = "SELECT * FROM employee WHERE name LIKE ?";
//        PreparedStatement preparedStatement = connection.prepareStatement(selectAllEmployee);
//        preparedStatement.setString(1,"duc");
//        ResultSet resultSet = preparedStatement.executeQuery();



//====================================== CallableStatement =================================================================
//         sử dụng procedure trên database // callableStatement



        System.out.println("Nhap tên cần tìm: ");
        String getname = new Scanner(System.in).nextLine();
        String procedure = "{call getData(?)}";
        CallableStatement callableStatement = connection.prepareCall(procedure);

        callableStatement.setString(1,getname);

        ResultSet resultSet = callableStatement.executeQuery();


//============================== out put ============================================


        if (connection!= null) {
            System.out.printf("%-5s %-10s %s \n","ID" , "Emp No" ,"Emp Name");
            System.out.println("======================================");
            while (resultSet.next()){
                int eID = resultSet.getInt("empID");
                String empNo = resultSet.getString("empNo");
                String name = resultSet.getString("name");
                System.out.printf("%-5d %-10s %s \n",eID, empNo,name);
            }
        }else {
            System.out.println("kết nối không thành công !");
        }
        connection.close();



    }
}
