/*
Build in function interfaces

Predicate<T> test(t) T -> t/f 1/0
Function<T, R> : apply(t) ; T -> R
 */

import java.util.function.Function;

public class Example3 {
    public static void main(String[] args){
        Function<String, Integer> getLength = name -> name.length();
        System.out.println(getLength.apply("Java"));
        System.out.println(getLength.apply("john"));

//        Function<Interger, Interger> square = n -> n * n;
//        System.out.println(square.apply(5));
    }
}
