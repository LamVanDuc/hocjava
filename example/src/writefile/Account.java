package writefile;

public class Account {

    private int id;
    private String name;
    private String[] address;
    private String email;
    private boolean active;

    public Account(int id, String name, String[] address, String email, boolean active) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.email = email;
        this.active = active;
    }

    public Account(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getAddress() {
        return address;
    }

    public void setAddress(String[] address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
