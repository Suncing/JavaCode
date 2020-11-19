package Java初级.文件.IO操作;

import Pojo.Ninja;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class C_Deserialization {
    private static String path ="src\\main\\java\\Java初级\\文件\\生成文件\\序列化.bin";

    @Test
    public void m1() throws Exception{
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
        ArrayList<Ninja> ninjas = (ArrayList<Ninja>) ois.readObject();
        ois.close();
        System.out.println(ninjas.toString());
    }
}
