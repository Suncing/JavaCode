package 反射;

import java.lang.reflect.Field;

public class GetVariable {
    public static void main(String[] args) throws Exception {
        Class cls4 = Person.class;

        //1.Field[] getFields()获取所有public修饰的成员变量
        Field[] fields = cls4.getFields();
        for(Field field:fields){
            System.out.println(fields);
        }
        System.out.println("-----------------------------");

        //2.Field getField("名称")
        Person p = new Person();

        //p.a="a";不设置a的值，获得为null
        Field a = cls4.getField("a");//获得到person中的public String a变量

        Object value = a.get(p);//获取a的值
        System.out.println(value);

        a.set(p,"Jarvis");//设置a的值
        System.out.println(p);

        System.out.println("===============================");

        //3.Field[] getDeclaredFields():获取所有的成员变量 不考虑修饰符
        Field[] declaredFields = cls4.getDeclaredFields();
        for(Field declaredFiled:declaredFields){
            System.out.println(declaredFiled);
        }

        System.out.println("===============================");

        //可以获取非public修饰符的变量
        Field d = cls4.getDeclaredField("d");
        d.setAccessible(true);//忽视访问权限修饰符的安全检测
        Object value2 = d.get(p);
        System.out.println(value2);
    }
}
