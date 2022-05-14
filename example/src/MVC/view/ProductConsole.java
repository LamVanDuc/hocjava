package MVC.view;

import MVC.controller.ProductController;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import MVC.entity.Product;


public class ProductConsole {

    ProductController productController = new ProductController();
    Product product;
    static Scanner sc;
    public ProductConsole(){
        this.sc = new Scanner(System.in);
    }

    public static int menu(){
        System.out.println("---------------Product--------------");
        System.out.println("1. Show All Product(ArrayList) .");
        System.out.println("2. Show Product By ID .");
        System.out.println("3. Update Product By ID .");
        System.out.println("4. Create Product .");
        System.out.println("5. delete Product .");
        System.out.println("6. Read product form json(show all) .");
        System.out.println("7.Write Form Json .");
        System.out.println("8.Find product by Name(From json file)");
        System.out.println("9. Update product(From json file)");

        System.out.println("10. Exit");
        int choice =readInt(0,10);
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


    public   void start()throws SQLException, ClassNotFoundException , IOException, ParseException {
        try{
            while (true){
                int choice = menu();
                switch (choice){
                    case 0: System.exit(0);break;
                    case 1: showAllProduct();break;
                    case 2:showProductById();break;
                    case 3:updateProduct();break;
                    case 4:createProduct();break;
                    case 5:deleteProduct();break;
                    case 6:readProductFormJson();break;
                    case 7:writeProductFormJson();break;
                    case 8:searchProductFromJson();break;
                    case 9:updateFromJson();break;
                    case 10:System.exit(1);
                    default:
                        System.out.println("Invalid menu select !");
                }
            }
        }catch (InputMismatchException ex){
            System.out.println("Entered incorrect format ! ");
        }
    }

    public void showAllProduct() throws SQLException, ClassNotFoundException {
        ArrayList<Product> products = productController.getAllProduct();
        System.out.println("========== Show all ============");
        for (int i = 0 ; i<products.size(); i++) {
            System.out.printf(" %-5d %-20s %-30s %f\n",products.get(i).getId(),products.get(i).getProName(), products.get(i).getProDesc() , products.get(i).getPrice());
        }
    }

    public void showProductById()throws  SQLException, ClassNotFoundException{
        System.out.println("Enter the product id : ");
        int id = sc.nextInt();

        product = productController.getProductById(id);
        if (product !=null) {
            System.out.println(product.getId() + " | " + product.getProName() + " | " + product.getProDesc() + " | " + product.getPrice());
        }
        else{
            System.out.println("ID \""+id+"\" Not found ! ");
        }
    }

    public void updateProduct() throws SQLException, ClassNotFoundException {

        System.out.println("Enter the product id you want to update : ");
        int id = sc.nextInt();
        product = productController.getProductById(id);
        if (product !=null) {
            System.out.println(product.getId() + " | " + product.getProName() + " | " + product.getProDesc() + " | " + product.getPrice());

            System.out.print("Enter new name of the product : ");
            String proName = sc.next();

            System.out.print("\nEnter new Description of the "+proName +" : ");
            String proDesc = sc.next();


            System.out.print("\nEnter new price : ");
            float price = sc.nextFloat();

            productController.updateProduct(product.getId() , proName , proDesc , price);
        }
        else{
            System.out.println("ID \""+id+"\" Not found ! ");
        }

    }

    public void createProduct() throws SQLException, ClassNotFoundException {
        Product product;
        String proName , proDesc ;
        float price;
        System.out.println("======================= Create ===========================");
        System.out.print("Enter the name : ");
        proName = sc.next();
        System.out.print("\nEnter the Description : ");
        proDesc = sc.next();
        System.out.print("\nEnter the price : ");
        price = sc.nextFloat();
        product = new Product(proName , proDesc , price);
        productController.createProduct(product);
    }

    public void deleteProduct() throws SQLException, ClassNotFoundException {
        System.out.println("======================== Delete ==========================");
        System.out.println("Enter the id Product: ");
        int id = sc.nextInt();
        boolean check = productController.deleteProduct(id);
        if (check == true){
            System.out.println("Delete success .");
        }else {
            System.out.println("ID \""+id+"\" Not found ! ");
        }
    }
    public void readProductFormJson()throws IOException, ParseException {
        productController.readFormJson();
    }

    public void writeProductFormJson() throws IOException{

        System.out.print("product id: ");
        int id = sc.nextInt();
        System.out.print("\nproduct name : ");
        String proName = sc.next();
        System.out.print("\n product des :");
        String proDes = sc.next();
        System.out.print("\nproduct price : ");
        float price = sc.nextFloat();
        Product product = new Product(id , proName , proDes , price);

        productController.writeProductFormJson(product);
    }

    public void searchProductFromJson()throws IOException{

        System.out.print("\nEnter the product name: ");
        String search = sc.next();

        productController.searchProductFromJson(search);
    }

    public void updateFromJson(){
        productController.UpdateFileJson();
    }
}
