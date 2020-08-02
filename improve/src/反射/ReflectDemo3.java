package 反射;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class ReflectDemo3 {
    public static void main(String[] args) throws Exception {
        Class cls5 = Person.class;

        //获取构造方法
        Constructor constructor = cls5.getConstructor(String.class, int.class);
        //创建对象
        Object person = constructor.newInstance("张三", 23);
        System.out.println(person);
        //空参创建对象
        Object o = cls5.newInstance();
        System.out.println(o);
    }
}
