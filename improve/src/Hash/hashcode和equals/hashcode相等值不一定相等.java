package Hash.hashcode和equals;

public class hashcode相等值不一定相等 {
    public static void main(String[] args) {
        Integer aInt = 97;
        String a= "a";
        String c = "a";
        System.out.println(aInt.hashCode());
        System.out.println(a.hashCode());
        System.out.println(c.hashCode());
    }
}
