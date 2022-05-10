package connectSQLServer;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ApplicationSQLServer {

    public static void main(String[] args) throws SQLException, ClassNotFoundException, NoSuchAlgorithmException, IOException, KeyManagementException {
        Connection sqlServer = SQLServerConnection.getSQLServerConnection();



//        PreparedStatement preparedStatement = sqlServer.prepareStatement("SELECT * from Sach WHERE SoLuong <= ?");
//        preparedStatement.setInt(1 , 300);
//        ResultSet resultSet = preparedStatement.executeQuery();

        CallableStatement callableStatement = sqlServer.prepareCall("EXEC searchDetailBook ?");
        System.out.println("Nhap tên , thể loại , tác giả : ");
        String search = new Scanner(System.in).nextLine();
        callableStatement.setString(1 ,search);
        ResultSet resultSet = callableStatement.executeQuery();

        if (resultSet != null){

            System.out.printf("%-40s %-20s %-30s %-10s %s \n" ,"Tên sách" , "Tên thể loại" , "Tên tác giả" , "Số lượng" , "Giá bán");
            System.out.println("--------------------------------------------------------------------------------------------------------------------");
            while (resultSet.next()){
                String TenSach = resultSet.getString("TenSach");
                String TenTheLoai = resultSet.getString("TenTheLoai");
                String TenTG = resultSet.getString("TenTG");
                int soLuong = resultSet.getInt("SoLuong");
                double giaBan = resultSet.getFloat("GiaBan");

                System.out.printf("%-40s %-20s %-30s %-10d %f \n" ,TenSach , TenTheLoai , TenTG , soLuong , giaBan);

            }
        }

    }
}
