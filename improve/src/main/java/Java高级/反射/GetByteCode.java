package Java高级.反射;

public class GetByteCode {
    public static void main(String[] args) throws Exception{
        //1.Class.forName("全类名")，多用于配置文件
        Class cls1 = Class.forName("Java高级.反射.Person");
        System.out.println(cls1);

        //2.类名.class，多用于参数传递
        Class cls2 = Person.class;
        System.out.println(cls2);

        //3.对象.getClass()，多用于对象获取字节码
        Class cls3 = new Person().getClass();
        System.out.println(cls3);


        System.out.println(cls1==cls2);
        System.out.println(cls1==cls3);
        /*
        都是true，同一个字节码文件在一次程序运行过程中，只被加载一次
        不论通过哪种方式获取的Class对象都是同一个
         */
    }
}
