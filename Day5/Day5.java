
import java.util.*;

class Car{
    String color;
    String brand;
    int speed;

    Car(String color, String brand, int speed){
        this.speed = speed;
        this.brand = brand;
    }

    void displayInfo(){
        System.out.println("Brand: "+brand+" Color: "+color+" speed: "+speed);
    }

    void accelerate(int incr){
        int or_speed = speed;
        speed += incr;

        System.out.println("Original speed: "+or_speed);
        System.out.println(brand+"\n"+color+"\n"+speed+"km/hr");
    }
}



public class Main {
    public static void main(String[] args){
        Car c1 = new Car("black", "BMW", 360);
        c1.displayInfo();
        c1.accelerate(50);
    }

}
