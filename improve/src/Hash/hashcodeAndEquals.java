package Hash;

import java.util.Objects;

class Person {
    private String name;
    private Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }


    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) &&
                Objects.equals(age, person.age);
    }

    public int hashCode() {
        return Objects.hash(name, age);
    }
}

public class hashcodeAndEquals {
    public static void main(String[] args) {
        /**1.
         * hashcode相等值不一定相等
         */
        Integer i = 97;
        String s2= "a", s3 = "a";
        System.out.println(i.hashCode());
        System.out.println(s2.hashCode()==s3.hashCode() && s2.hashCode()==i.hashCode());

        System.out.println("----------------------------------------------------------");

        /**2.
         *重写完equals方法内容相等但是hashcode不等，与定理违背
         *定理：如果equals比较对象内容相同，那么hashcode一定相同
         *所以此时必须重写hashcode方法，所以equals重写hashcode也必须重写
         */
        Person p1 = new Person("AAA",21);
        Person p2 = new Person("AAA",21);
        System.out.println(p1.equals(p2));
        System.out.println(p1.hashCode());
        System.out.println(p2.hashCode());

    }
}
