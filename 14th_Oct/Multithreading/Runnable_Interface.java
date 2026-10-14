package Multithreading;

class MyThreadRunnable1 implements Runnable{
    public void run(){
        System.out.println("I am a 1st class");
        System.out.println("I am a 1st class");
    }
}

class MyThreadRunnable2 implements Runnable{
    public void run(){
        System.out.println("I am a 2st class");
        System.out.println("I am a 2st class");
    }
}

public class Runnable_Interface {
    public static void main(String[] args){
        MyThreadRunnable1 b1 = new MyThreadRunnable1();
        Thread g1 = new Thread(b1);
        MyThreadRunnable2 b2 = new MyThreadRunnable2();
        Thread g2 = new Thread(b2);

        g1.start();
        g2.start();
    }
}
