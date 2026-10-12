//--------------
//Static KeyWord.
//--------------
/*
class Student2{
    String name;
    static String collageName = "IIT Bombay";

    Student2(String name){
        this.name = name;
    }
    void stucol(){
        System.out.println(name  +" studies in "+ collageName);
    }
}

public class KeyWord {
    public static void main(String[] args){
        Student2  s1 = new Student2("AJAY");
        s1.stucol();
    }
}

*/

/*
//--------------
// Final keyWord
//--------------
class Bank{
    final void claculateInterest(){
        System.out.println("Base Interest calculation");
    }
}

class Branch extends Bank{
    void calculateInterest(){    // A method marked with the final keyword cannot be overridden by a subclass
        System.out.println("Custom Interest");
    }
}

public class KeyWord{
    public static void main(String[] args){
        Bank b1 = new Bank();
        b1.claculateInterest();

    }
}


*/

//-----------------
// Abstract keyword
//-----------------

abstract class Shape{
    private String colour;

    void setColour(String colour){
        this.colour = colour;
    }
    String getColour(){
        return colour;
    }

    abstract double calculaterArea();
}

class Circle extends Shape{
    double radius;

    Circle(double radius){
        this.radius = radius;
    }

    double calculaterArea(){
        return (3.14) * radius * radius;
    }

}

class Rectangle extends Shape{
    double length, breath;
    Rectangle(double length, double breath){
        this.length = length;
        this.breath = breath;
    }
    double calculaterArea(){
        return (length * breath);

    }
}

class KeyWord{
    public static void main(String[] args){
        Shape s = new Circle(0.5);
        Shape s1 = new Rectangle(2,4);

        s.setColour("Red");
        s1.setColour("Black");

        s.calculaterArea();
        s1.calculaterArea();


        System.out.printf("%s circle area is %.2f", s.getColour(), s.calculaterArea());
        System.out.println();
        System.out.printf("%s Rectangle area is %.2f%n", s1.getColour(), s1.calculaterArea());
    }
}


