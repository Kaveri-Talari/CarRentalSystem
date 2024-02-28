package cars_rental;

import static cars_rental.Status.AVAILABLE;

public class Rental {
    private Car car;
    private User user;
    private int days;

    public Rental(Car car, User user, int days) {
        this.car = car;
        this.user = user;
        this.days = days;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public Car getCar() {
        return car;
    }

    public User getUser() {

        return user;
    }

    public int getDays() {

        return days;
    }

}

