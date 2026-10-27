
public class Main {
    public static void main(String[] args) {
        Rentalshop shop = new Rentalshop();

        shop.addVehicle(new Car("C1", "Swift", 1500));
        shop.addVehicle(new Bike("B1", "Activa", 400));
        shop.addVehicle(new Truck("T1", "Tata Ace", 2500));

        Customer asha = new Customer("Asha");
        Customer ravi = new Customer("Ravi");

        shop.rent("B1", asha, 8);
        shop.rent("T1", ravi, 2);

        try {
            shop.rent("B1", ravi, 3);
        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }

        shop.giveBack("B1");

        shop.showAvailable();
    }
}
