package Java高级.反射;


import java.lang.reflect.Method;

public class GetMemberMethod {
    public static void main(String[] args) throws Exception {
        Class cls6 = Person.class;

        //1.获取无参成员方法
        Method eat_method = cls6.getMethod("eat");
        Person p =new Person();
        eat_method.invoke(p);//执行方法

        //获取有参成员方法
        Method eat_method2 = cls6.getMethod("eat", String.class);
        eat_method2.invoke(p,"西红柿");

        System.out.println("--------------------------------");

        //2.获取所有public修饰的方法
        Method[] methods = cls6.getMethods();
        for(Method method:methods){
            System.out.println(method);
            String name = method.getName();//获取方法名称
            System.out.println(name);
            //method.setAccessible(true);
        }

        System.out.println("--------------------------------");

        //3.获取类名
        String className = cls6.getName();
        System.out.println(className);

        //4.获取所有public修饰的方法
        Method[] methods2 = cls6.getDeclaredMethods();
    }
}
