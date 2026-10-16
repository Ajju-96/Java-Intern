
/*
Since List<Integer> isn't a List<Number>, how do you write a method accepting
"a list of any kind of number"? That's what wildcards are for. ? means "some unknown
type.
 */

import java.util.*;

public class Question2 {
    public static void printList(List<?> list){
        for(Object o : list){
            System.out.println(o);
        }
    }
    public static void main(String[] args){
        List<String> names = Arrays.asList("Anish", "Varun", "mayur");
        List<Integer> num = Arrays.asList(100,99,98);
        List<Double> prices = Arrays.asList(99.5,99.6,99.7);

        System.out.println("Name: ");
        printList(names);

        System.out.println("\nNumbers: ");
        printList(num);

        System.out.println("\nPrices: ");
        printList(prices);

    }
}
