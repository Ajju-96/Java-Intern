class Test<T>{
    T obj;
    Test(T obj){
        this.obj = obj;
    }

    public T getObj(){
        return obj;
    }
}

class GenericsInJava{
    public static void main(String[] args){
        // instance of Integer type
        Test<Integer> obj1 = new Test<Integer>(8);
        System.out.println(obj1.getObj());

        // instance of string type
        Test<String> obj2 = new Test<String>("Friend");
        System.out.println(obj2.getObj());
    }
}