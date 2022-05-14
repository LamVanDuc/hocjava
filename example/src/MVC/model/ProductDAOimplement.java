package MVC.model;

import MVC.DAO.SQLServerConnection;
import MVC.entity.Product;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ProductDAOimplement implements ProductDAO{
    ArrayList<Product> products = new ArrayList<>();
    @Override
    public ArrayList<Product> getAllProduct() throws SQLException, ClassNotFoundException {
        ArrayList<Product> products = new ArrayList<>();
        Connection connection = SQLServerConnection.getSQLServerConnection();

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM product");
        while (resultSet.next()){
            products.add(new Product(resultSet.getInt(1)
                    , resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getFloat(4)));

        }
        return products;
    }


    @Override
    public Product getProductById(int id) throws SQLException, ClassNotFoundException {
        Product product = null;
        Connection connection = SQLServerConnection.getSQLServerConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM product WHERE id = ?");
        preparedStatement.setInt(1 , id);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            product = new Product(resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getFloat(4));
        }
        return product;
    }


    @Override
    public void updateProduct(int id, String proName, String proDesc, float price) throws SQLException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);

        Connection connection = SQLServerConnection.getSQLServerConnection();


        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE product SET proName = ? , proDesc = ? , price = ? WHERE id= ?");

        preparedStatement.setString(1 ,proName);

        preparedStatement.setString(2 ,proDesc);

        preparedStatement.setFloat(3 ,price);

        preparedStatement.setInt(4 ,id);
        int result = preparedStatement.executeUpdate();
        if ( result == 0  ){
            System.out.println("Update False !");
        }if (result != 0){
            System.out.println("Update success .");
        }

        connection.close();
    }


    @Override
    public void createProduct(Product product) throws SQLException, ClassNotFoundException {
        Connection connection = SQLServerConnection.getSQLServerConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO product VALUES (? ,?,?)",Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1 ,product.getProName());
        preparedStatement.setString(2 ,product.getProDesc());
        preparedStatement.setFloat(3, product.getPrice());

        int check = preparedStatement.executeUpdate();
        if (check ==0){
            System.out.println("Create false !");
        }else {
            ResultSet key = preparedStatement.getGeneratedKeys();
            if (key.next()) {
                product.setId(key.getInt(1));
                System.out.println("Create Success .");
            }
            else {
                throw new SQLException("Creating user failed, no ID obtained.");
            }
        }
    }


    @Override
    public boolean deleteProduct(int id) throws SQLException, ClassNotFoundException {
        Connection connection = SQLServerConnection.getSQLServerConnection();
        boolean check = false;
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE  product WHERE id = ?");
        preparedStatement.setInt(1 ,id);
        int i = preparedStatement.executeUpdate();
        if ( i ==0){
            check = false;
        }else{
            check =true;}
        return check;
    }


    @Override
    public void WriteToJson(Product product) throws IOException {
        Writer writer = Files.newBufferedWriter(Paths.get("product.json"), StandardCharsets.UTF_8);
        List<Product> products = Arrays.asList(product);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        gson.toJson(products,writer);
        writer.close();
        System.out.println(" Add successful products");
    }


    @Override
    public void ReadFormJson() throws IOException, ParseException {
        JSONParser parser = new JSONParser();

        FileReader fileReader = new FileReader("product.json");
        Object obj = parser.parse(fileReader);

        JSONArray jsonArray = (JSONArray) obj;
        System.out.printf("\n %-20s %-20s %s\n","proName" , "proDes" , "price");
        System.out.println("----------------------------------------------------------");
        jsonArray.forEach(pro ->parserObj((JSONObject) pro));
    }
    public void parserObj(JSONObject obj){
        String proName = (String) obj.get("proName");
        String proDesc = (String) obj.get("proDesc");
        double price = (double) obj.get("price");
        System.out.printf(" %-20s %-20s %f\n",proName , proDesc , price);
    }


    public void searchProductFromJson(String search) throws  IOException{
        boolean check = false;
        List<Product> products;
        FileReader files = new FileReader("product.json");
        products = new Gson().fromJson(files , new TypeToken<List<Product>>(){}.getType());
        System.out.printf("\n %-20s %-20s %s\n","proName" , "proDes" , "price");
        System.out.println("----------------------------------------------------------");
        for (Product product: products){
            if (product.getProName().equals(search)||product.getProDesc().equals(search)){
                check = true;
                System.out.printf(" %-20s %-20s %f\n",product.getProName() , product.getProDesc() , product.getPrice());
            }
        }
        if (check == false){
            System.out.println("Not fount !");
        }

    }



    public void updateFromJson(){

        try{
            String jsonMessage = "{\"id\":1,\"proName\":\"iphone\",\"proDesc\":\"newIphone\",\"price\":6541265.5}";
            System.out.println("Original JSON String =" + jsonMessage);

            JSONParser parser = new JSONParser();
            Object obj =  parser.parse(jsonMessage);
            JSONObject jsonObject = (JSONObject) obj;
            jsonObject.put("proDesc","newIphone 2022");

            System.out.println("updated JSON String = "+jsonObject.toJSONString());

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

