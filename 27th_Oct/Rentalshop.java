
import java.util.ArrayList;
import java.util.List;

public class Rentalshop {
    private List<Vehicle> fleet;
    private List<Rental> rentals;

    public Rentalshop() {
        fleet = new ArrayList<>();
        rentals = new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle) {
        fleet.add(vehicle);
    }

    public Rental rent(String vehicleId, Customer customer, int days) {
        if (days <= 0) {
            throw new IllegalArgumentException(
                    "Rental days must be greater than zero"
            );
        }

        Vehicle selectedVehicle = null;

        for (Vehicle vehicle : fleet) {
            if (vehicle.getId().equals(vehicleId)) {
                selectedVehicle = vehicle;
                break;
            }
        }

        if (selectedVehicle == null) {
            throw new IllegalArgumentException(
                    "Vehicle " + vehicleId + " not found"
            );
        }

        if (!selectedVehicle.isAvailable()) {
            throw new IllegalStateException(
                    selectedVehicle.getDetails() + " is already rented"
            );
        }

        selectedVehicle.setAvailable(false);

        Rental rental = new Rental(selectedVehicle, customer, days);
        rentals.add(rental);
        customer.addRental(rental);

        rental.displayRental();
        return rental;
    }

    public void giveBack(String vehicleId) {
        for (Vehicle vehicle : fleet) {
            if (vehicle.getId().equals(vehicleId)) {
                if (vehicle.isAvailable()) {
                    throw new IllegalStateException(
                            vehicle.getDetails() + " is not currently rented"
                    );
                }

                vehicle.setAvailable(true);
                return;
            }
        }

        throw new IllegalArgumentException(
                "Vehicle " + vehicleId + " not found"
        );
    }

    public void showAvailable() {
        System.out.println("Available vehicles:");

        for (Vehicle vehicle : fleet) {
            if (vehicle.isAvailable()) {
                System.out.println("  " + vehicle.getDetails());
            }
        }
    }
}
