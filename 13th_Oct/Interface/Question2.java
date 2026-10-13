/*
Problem 2: Count character types in a password Task: Given a password string, count how many uppercase letters, lowercase letters, digits, and special characters it contains. Key concept: Built-in static utility methods of Character.
*/


public class Question2 {
    public static void main(String[] args){
        String passward = "ajayPARBHANE@#$999";

        int upper = 0;
        int lower = 0;
        int digits = 0;
        int special = 0;

        for(int i = 0; i < passward.length(); i++){
            char ch = passward.charAt(i);
            if(Character.isUpperCase(ch)){
                upper++;
            } else if (Character.isLowerCase(ch)) {
                lower++;
            } else if (Character.isDigit(ch)) {
                digits++;
            } else {
                special++;
            }
        }
        System.out.println("Number of UpperCase characters are: "+ upper);
        System.out.println("Number of LowerCase characters are: "+ lower);
        System.out.println("Number of digits are: "+ digits);
        System.out.println("Number of Special characters are: "+ special);
    }
}
