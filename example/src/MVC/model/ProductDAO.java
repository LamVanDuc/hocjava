package MVC.model;

import org.json.simple.parser.ParseException;
import MVC.entity.Product;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public interface ProductDAO {

    public ArrayList<Product> getAllProduct() throws SQLException, ClassNotFoundException;

    public Product getProductById(int id) throws SQLException, ClassNotFoundException;

    public  void updateProduct(int id , String proName, String proDesc ,float price ) throws SQLException, ClassNotFoundException;

    public void createProduct(Product product) throws SQLException, ClassNotFoundException;

    public boolean deleteProduct(int id) throws SQLException, ClassNotFoundException;


    public void WriteToJson(Product product) throws IOException;


    public void ReadFormJson() throws IOException, ParseException;
}
