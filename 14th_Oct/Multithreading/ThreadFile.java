package Multithreading;

class MyThread1 extends Thread{
    public void run(){
        while(true){
            System.out.println("I am sad");
        }
    }
}

class MyThread2 extends Thread{
    public void run(){
        while(true){
            System.out.println("Thread2 is good");
        }
    }
}

public class ThreadFile {
    public static void main(String[] args){
        MyThread1 t1 = new MyThread1();
        MyThread2 t2 = new MyThread2();
        t1.start();
        t2.start();
    }

}
