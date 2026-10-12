

class Engine{
    void start(){
        System.out.println("Engine is starting....");
    }
}

class Breaks{
    void apply(){
        System.out.println("Breaks are apply....");
    }
}
//--------------------------------------
//This is what i try
//--------------------------------------
class Bike{
    private Engine engine;
    private Breaks breaks;

    Bike(){
        this.engine = new Engine();
        this.breaks = new Breaks();
    }

    void drives(){
        engine.start();
        breaks.apply();
        System.out.println("bike stop..");
    }
}
//------------------------------------------

class Car{
    private Engine engine;
    Car(){
        this.engine = new Engine();
    }
    void drive(){
        engine.start();
        System.out.println("Car is moving");
    }

}

class Drive{

}


public class relationships {

}
