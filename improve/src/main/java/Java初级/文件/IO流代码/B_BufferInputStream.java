package Java初级.文件.IO流代码;

import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
/**
 * 增强的FileInputStream，自己定义了8k的buf
 * @throws Exception
 */

public class B_BufferInputStream {
    private static String path ="D:\\Zoom\\github\\JavaCode\\improve\\src\\main\\java\\Java初级\\文件\\测试文件\\春野樱.txt";

    @Test
    public void m1() throws Exception{
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(path));
        int data;
        while((data=bis.read())!=-1){
            System.out.print((char)data);
        }
        bis.close();
    }
}
