package Java初级.容器.Collection.Set.hashSet;

import java.util.HashSet;
import java.util.Objects;

/**
 * 不能保证元素的排列顺序，顺序可能与添加顺序不同，顺序也可能发生变化；
 * HashSet不是同步的
 * 集合元素值可以是null
 * set集合不允许包含相同的元素，否则则添加操作失败，add()方法返回false
 * 记得要重写hashcode和equals方法
 */


public class HashSetUse {
    public static void main(String[] args) {

        Student s1 = new Student("小龙女", 23);
        Student s2 = new Student("任盈盈", 24);
        Student s3 = new Student("小龙女", 23);
        Student s4 = new Student("东方不败", 25);
        Student s5 = new Student("伊琳", 29);
        Student s6 = new Student("周芷若", 30);
        HashSet<Student> hashSet = new HashSet<>();
        hashSet.add(s1);
        hashSet.add(s2);
        hashSet.add(s3);
        hashSet.add(s4);
        hashSet.add(s5);
        hashSet.add(s6);
        for (Student student : hashSet) {
            System.out.println(student.getName() + "==" + student.getAge());
        }
    }
}

class Student {
    private String name;
    private int age;

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
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

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age &&
                Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}

