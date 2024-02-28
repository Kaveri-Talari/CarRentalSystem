package cars_rental;

public class User {
    private int id;
    private String user_name;
    private String email;
    private String license_num;

    public User(int id, String user_name, String email, String license_num) {
        this.id = id;
        this.user_name = user_name;
        this.email = email;
        this.license_num = license_num;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLicense_num() {
        return license_num;
    }

    public void setLicense_num(String license_num) {
        this.license_num = license_num;
    }
}

