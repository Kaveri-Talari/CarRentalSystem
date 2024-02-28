package cars_rental;

import static cars_rental.Status.AVAILABLE;
public class Main {
    public static void main(String args[]) {
        CarRentalSystem rentalsystem = new CarRentalSystem();
        Car car1 = new Car("BMW", "TS5627", new Locations("HYD", "978"), AVAILABLE, 3000);
        Car car2 = new Car("Maruthi", "TS0035", new Locations("HYD", "25877"), AVAILABLE, 1500);
        Car car3 = new Car("Honda", "KL8927", new Locations("KERALA", "9876"), AVAILABLE, 2000);

        rentalsystem.addCars(car1);
        rentalsystem.addCars(car2);
        rentalsystem.addCars(car3);

        rentalsystem.rental_return();
    }
}
