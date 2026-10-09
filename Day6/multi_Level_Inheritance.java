
class Shape{
    String color = "Black";
}
//child - 1
class Circle extends Shape{
    void drawCircle(){
        System.out.println("Drawing a "+color+" circle.");
    }
}
//child - 2
class Rectangel extends Shape{
    void drawRectangle(){
        System.out.println("Drawing a "+color+" rectangle.");
    }
}



public class Inheritance {
    public static void main(String[] args){
        Circle c = new Circle();
        Rectangel r = new Rectangel();

        c.drawCircle();
        r.drawRectangle();
    }
}
