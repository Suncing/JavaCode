package Java01_初级.文件.IO操作;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * InputStreamReader类是从字节流到字符流的桥接器：它使用指定的字符集读取字节并将它们解码为字符。
 */
public class G_InpuStreamReader {
    private static String path ="src\\main\\java\\Java初级\\文件\\测试文件\\宇智波鼬.txt";

    @Test
    public void m1() throws Exception{
        InputStreamReader isr = new InputStreamReader(new FileInputStream(path),"utf-8");
        int data=0;
        while((data=isr.read())!=-1){
            System.out.print((char)data);
        }
        isr.close();
    }
}
