package Java相关;

class Inner{
    public Inner(String a){
        this(a,"BBB");
        System.out.println(a);
    }
    public Inner(String a,String b){
        this(a,b,"ccc");
        System.out.println(a+" "+b);
    }

    public Inner(String a,String b,String c){
        System.out.println(a+" "+b+" "+c);
    }
}
public class ThisComprehend {
    public static void main(String[] args) {
        Inner i = new Inner("AAA");

    }

}
