package Java初级.文件;

import java.io.Serializable;

public class Ninja implements Serializable {
//    private static final long serialVersionUID = 100L;
    private String name;
    private int age;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Ninja(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
