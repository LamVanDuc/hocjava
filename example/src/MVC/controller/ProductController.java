package MVC.controller;

import MVC.model.ProductDAOimplement;
import org.json.simple.parser.ParseException;
import MVC.entity.Product;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductController {
    ProductDAOimplement productDAOimplement = new ProductDAOimplement();

    public ArrayList<Product> getAllProduct() throws SQLException, ClassNotFoundException {
        return productDAOimplement.getAllProduct();
    }

    public Product getProductById(int id) throws SQLException, ClassNotFoundException {
        return productDAOimplement.getProductById(id);
    }
    public void updateProduct(int id, String proName, String proDesc, float price) throws SQLException, ClassNotFoundException {
        productDAOimplement.updateProduct(id , proName , proDesc , price);
    }

    public void createProduct(Product product) throws SQLException, ClassNotFoundException {
        productDAOimplement.createProduct(product);
    }

    public boolean deleteProduct(int id) throws SQLException, ClassNotFoundException {
        return productDAOimplement.deleteProduct(id);
    }
    public void readFormJson() throws IOException, ParseException {
        productDAOimplement.ReadFormJson();
    }

    public void writeProductFormJson(Product product) throws IOException{
        productDAOimplement.WriteToJson(product);
    }

    public void searchProductFromJson(String search)throws IOException{
        productDAOimplement.searchProductFromJson(search);
    }

    public void UpdateFileJson(){
        productDAOimplement.updateFromJson();
    }
}
