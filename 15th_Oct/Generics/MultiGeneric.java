
class Test1<T, K>{
    T web;
    K sit;

    Test1(T web, K sit){
        this.web = web;
        this.sit = sit;
    }

    public void print(){
        System.out.println(web);
        System.out.println(sit);
    }
}

public class MultiGeneric {
    public static void main(String[] args){
        Test1<String, Integer> obj11 = new Test1<String, Integer>("Friends", 96);

        obj11.print();
    }
}
