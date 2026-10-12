// has a relation ..Example


public class App2 {
    public static void main(String[] args){
        Battery b1 = new Battery(50000);
        Camera c1 = new Camera(2);
        Phone p1 = new Phone("Apple", b1, c1);
    }
}
