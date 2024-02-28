package cars_rental;

public class Car {
    private String car_name;

    private String number;
    private Locations location;
    private Status car_status;
    private int car_rent;

    public Car(String car_name, String number, Locations location, Status car_status, int car_rent) {
        this.car_name = car_name;
        this.number = number;
        this.location = location;
        this.car_status = car_status;
        this.car_rent = car_rent;
    }

    public String getCar_name() {
        return car_name;
    }

    public void setCar_name(String car_name) {
        this.car_name = car_name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Locations getLocation() {
        return location;
    }

    public void setLocation(Locations location) {
        this.location = location;
    }

    public Status getCar_status() {
        return car_status;
    }

    public void setCar_status(Status car_status) {
        this.car_status = car_status;
    }

    public int getCar_rent() {
        return car_rent;
    }

    public void setCar_rent(int car_rent) {
        this.car_rent = car_rent;
    }
}
