package Java初级.文件.IO流;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.InputStreamReader;

public class G_InpuStreamReader {
    private static String path ="D:\\Zoom\\github\\JavaCode\\improve\\src\\main\\java\\Java初级\\文件\\测试文件\\宇智波鼬.txt";

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
