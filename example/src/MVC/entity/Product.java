package MVC.entity;

public class Product {
    private  int id;
    private String proName ;
    private String proDesc;
    private float price;

    public Product( String proName, String proDesc, float price) {
        this.proName = proName;
        this.proDesc = proDesc;
        this.price = price;
    }


    public Product(int id, String proName, String proDesc, float price) {
        this.id = id;
        this.proName = proName;
        this.proDesc = proDesc;
        this.price = price;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public String getProDesc() {
        return proDesc;
    }

    public void setProDesc(String proDesc) {
        this.proDesc = proDesc;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
