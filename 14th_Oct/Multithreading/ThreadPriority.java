package Multithreading;

class ThreadPriorityEx extends Thread{
    public void run(){
        System.out.println("Inside the run() method");
    }
}
public class ThreadPriority {
    public static void main(String[] args){
        ThreadPriorityEx p = new ThreadPriorityEx();
        System.out.println(p.getPriority());
        Thread.currentThread().setPriority(10);
        System.out.println(p.getPriority());
    }
}
