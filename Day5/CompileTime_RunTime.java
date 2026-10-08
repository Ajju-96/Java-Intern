import java.util.*;

//CompileTime
class Calculator{
    int add(int a, int b){
        return a+b;
    }

    int add(int a, int b, int c){
        return a+b+c;
    }

    double add(double a, double b){
        return a+b;
    }
}

//RunTime
class Animal{
    void makeSound(){
        System.out.println("Animal make a sound");
    }
}
class Dog extends Animal{
    void makeSound(){
        System.out.println("Dog barks: woof woof!");
    }
}
class Cat extends Animal{
    void makeSound(){
        System.out.println("cat Meows: Meow meow!");
    }
}


public class CompileTime_RunTime {
    public static void main(String[] args){
        Animal pet1 = new Dog();
        Animal pet2 = new Cat();
        Animal pet3 = new Animal();

        pet1.makeSound();
        pet2.makeSound();
        pet3.makeSound();
    }
}

