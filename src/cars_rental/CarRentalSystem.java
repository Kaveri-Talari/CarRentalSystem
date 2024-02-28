package cars_rental;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static cars_rental.Status.*;

public class CarRentalSystem {

    private List<User> users;
    private List<Car> listCar;
    private List<Rental> rentals;

    public CarRentalSystem() {
        users = new ArrayList<>();
        listCar = new ArrayList<>();
        rentals = new ArrayList<>();
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Car> getListCar() {
        return listCar;
    }

    public void setListCar(List<Car> listCar) {
        this.listCar = listCar;
    }

    public List<Rental> getRentals() {
        return rentals;
    }

    public void setRentals(List<Rental> rentals) {
        this.rentals = rentals;
    }

    public void addUser(User user) {

        users.add(user);
    }

    public void addCars(Car car) {

        listCar.add(car);
    }

    public void addRent(Car car, User user, int days) {
        if (car.getCar_status().equals(AVAILABLE)) {
            car.setCar_status(BOOKED);
            rentals.add(new Rental(car, user, days));
        }
    }
    public void returnCar(Car car){

        if(car.getCar_status().equals(BOOKED)){

            Rental removecar=null;
            for(Rental rental:rentals){
                if(rental.getCar()==car){
                    removecar=rental;
                }
            }
            if(removecar!=null){
                car.setCar_status(AVAILABLE);
                rentals.remove(removecar);
            }
            else{
                System.out.println("Car is not available for rent");
            }
        }
    }

    public void rental_return() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Well-come to CAR RENTAL SYSTEM");
            System.out.println("1.Car for the rent");
            System.out.println("2.Returning the car");
            System.out.println("3.Exit");
            System.out.println("Enter your choice");

            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {

                System.out.println("Please enter your name:");
                String username = sc.nextLine();

                System.out.println("Please enter email:");
                String emailid = sc.nextLine();

                System.out.println("Enter the license number");
                String licensenum = sc.nextLine();

                System.out.println("Please enter the location:");
                String loc = sc.nextLine();
                List<Car> available_cars = new ArrayList<>();
                for (Car car : listCar) {
                    if (car.getLocation().getName().equals(loc) && car.getCar_status().equals(AVAILABLE)) {
                        available_cars.add(car);
                        System.out.println("CAR NAME:" + car.getCar_name() + ":: RENT " + car.getCar_rent());
                    }
                }

                System.out.println("Enter the car name you want rent");
                String carname = sc.nextLine();
                Car selected_car = null;
                for (Car car : available_cars) {
                    if (car.getCar_name().equals(carname)) {
                        selected_car = car;
                        break;
                    }
                }

                System.out.println("Enter the number of days to rent");

                int rentaldays = sc.nextInt();
                sc.nextLine();
                User newUser = new User(1, username, emailid, licensenum);
                users.add(newUser);

                if (selected_car != null) {
                    int totalprice = selected_car.getCar_rent() * rentaldays;
                    addRent(selected_car,newUser,rentaldays);
                    System.out.println("Rentals information");
                    System.out.println("user id: " + newUser.getId());
                    System.out.println("user name:" + newUser.getUser_name());

                    System.out.println("Car name:" + selected_car.getCar_name());
                    System.out.println("Total rent: " + totalprice);

                    System.out.print("\nConfirm rental (Y/N): ");
                    String confirm =sc.nextLine();
                    if (confirm.equals("Y")){
                        System.out.println("The car " + selected_car.getNumber() + " is booked");
                    } else {
                        System.out.println("The booking is canceled");
                    }
                }
            } else if (choice == 2) {

                System.out.println("Enter the Car number");
                String carnumber = sc.nextLine();
                Car return_carnumber = null;
                for (Car cars : listCar) {
                    if (cars.getNumber().equals(carnumber) && cars.getCar_status().equals(BOOKED)) {
                        return_carnumber = cars;
                        break;
                    }
                }
                if (return_carnumber != null) {
                    User username = null;
                    for (Rental rental : rentals) {
                        if (rental.getCar()==(return_carnumber)) {
                            username = rental.getUser();
                            break;
                        }
                    }
                    if (username != null) {
                        returnCar(return_carnumber);
                        System.out.println("The User " + username.getUser_name()+ " return the car");
                    }
                    else {
                        System.out.println("Car was not rented or rental information is missing.");
                    }
                }

            } else if (choice == 3) {
                break;
            } else {
                System.out.println("Invalid choice please enter correct one");
            }
        }
        System.out.println("\nThank you for using the Car Rental System!");
    }
}

