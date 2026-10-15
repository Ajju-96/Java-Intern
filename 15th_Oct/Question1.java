/*
Level 1: The Locker
Problem Statement
A school has lockers. One locker can hold one item. Students keep different things in them: a
book (String), a locker code (Integer), or a lunch price (Double).
Without generics, you’d write StringLocker, IntegerLocker, DoubleLocker, and so on.
Your task: Write one Locker<T> class that can hold any type of item.
Requirements:
1. put(item) stores an item.
2. get() returns the item.
3. Test it with a String and an Integer.
Expected output:
Locker has: Java Book
Locker has: 1234
*/

class Locker<T>{
    private T item;

    void put(T item){
        this.item = item;
    }

    T get(){
        return item;
    }

}
class Question1{
    public static void main(String[] args){
        Locker<String> l1 = new Locker<>();
        System.out.println("C++ book");

        Locker<Integer> intLocker = new Locker<>();
        intLocker.put(1234);
        intLocker.put(8910);

        System.out.println("IntLocker has: "+ intLocker.get());
    }
}