package 反射;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

public class ReflectTest {
    //不改动代码前提下，可以创建任意类的对象，可以执行任意方法
    public static void main(String[] args) throws Exception{
        //1.加载配置文件
        //1.1创建properties对象
        Properties pro = new Properties();
        //1.2加载配置文件转换为一个集合
        //1.2.1获取class目录下的配置文件
        ClassLoader classLoader = ReflectTest.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream("pro.properties");
        pro.load(is);

        //2.获取配置文件中定义的数据
        String className = pro.getProperty("className");
        String methodName = pro.getProperty("methodName");

        //3.加载该类进内存
        Class cls = Class.forName(className);
        //4.创建对象
        Object obj = cls.newInstance();
        //5.获取方法对象
        Method method = cls.getMethod(methodName);
        //6.执行方法
        method.invoke(obj);
    }
}
