package Hash.hashcode和equals;

public class Test {
    public static void main(String[] args) {
        Person p1 = new Person("AAA",21);
        Person p2 = new Person("AAA",21);
        System.out.println(p1.equals(p2));
        System.out.println(p1.hashCode());
        System.out.println(p2.hashCode());
        /*
        重写完equals方法内容相等但是hashcode不等，与定理违背
        定理：如果equals比较对象内容相同，那么hashcode一定相同
        所以此时必须重写hashcode方法，所以equals重写hashcode也必须重写
         */
    }
}
