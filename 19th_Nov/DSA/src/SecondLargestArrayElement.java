public class SecondLargestArrayElement {
    public static void main(String[] args){
        int[] array = {1,7,3,2};

        int largest = Integer.MIN_VALUE;
        int seclargest = Integer.MIN_VALUE;

        for(int i = 0; i<array.length; i++){
            if(array[i] > largest){
                seclargest = largest;
                largest = array[i];
            } else if (array[i] > seclargest && seclargest != largest) {
                seclargest = array[i];
            }
        }
        System.out.println("SecLargest element in the array is: "+  seclargest);


    }
}
