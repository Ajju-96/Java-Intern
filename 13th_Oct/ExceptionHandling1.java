public class ExceptionHandling1 {
    public static void main(String[] args){
        try{
            int[] numbers = {10, 20, 30};
            System.out.println(numbers[5]);
            int res = 10/0;
            System.out.println(res);
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Invalid Array index");
        }finally{
            System.out.println("Cannot divide by 0");
        }
    }
}
