public class App1 {
    public static void main(String[] args){
        Address home1 = new Address("Mumbai", "MH", 414001);
        Student std1 = new Student("Ajay", 21, home1);

        std1.displayProfile();
    }
}
