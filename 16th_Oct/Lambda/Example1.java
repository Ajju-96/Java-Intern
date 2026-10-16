// Lambda
@FunctionalInterface
interface Greeter{
    void greet(String name);
}
public class Example1{
    public static void main(String[] args){
        Greeter g = name -> System.out.println("Hello, "+ name);
        g.greet("Ajay");
    }
}