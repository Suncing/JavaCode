package Java初级.文件.IO流代码;

import Java初级.文件.Ninja;
import org.junit.Test;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 1）要求序列化的类必须实现其接口
 * 2）序列化中持有别人引用也要实现
 * 3）序列化版本ID要和反序列化一样
 * 4）使用transient（瞬间的）修饰属性，这个属性就不能被序列化
 * 5）静态属性不能序列化
 * 6）序列化多个对象可以借助集合实现
 */
public class C_Serialize {
    private static String path ="D:\\Zoom\\github\\JavaCode\\improve\\src\\main\\java\\Java初级\\文件\\生成文件\\序列化.bin";

    @Test
    public void m1() throws Exception{
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));
        Ninja naruto = new Ninja("Naruto",17);
        Ninja kakaxi = new Ninja("Kakaxi", 34);
        List<Ninja> ninjias = new ArrayList<>();
        ninjias.add(naruto);ninjias.add(kakaxi);

        oos.writeObject(ninjias);
        oos.close();
    }
}
