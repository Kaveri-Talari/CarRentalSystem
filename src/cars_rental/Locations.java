package cars_rental;

public class Locations {

    private String name;
    private String pincode;

    public Locations(String name, String pincode) {
        this.name = name;
        this.pincode = pincode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

}
