import java.io.*;
class exception{
    static void readFile() throws IOException{
        FileReader file = new FileReader("data.txt");
        System.out.println("File Opened");
    }

    public static void main(String[] args){
        try{
            readFile();
        }catch(IOException e){
            System.out.println("Could not find the file");
        }

    }
}





public class ExcpHandling_throws {
    public static void main(String[] args){

    }
}
