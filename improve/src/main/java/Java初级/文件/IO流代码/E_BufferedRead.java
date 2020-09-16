package Java初级.文件.IO流代码;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;

public class E_BufferedRead {
    private static String path ="D:\\Zoom\\github\\JavaCode\\improve\\src\\main\\java\\Java初级\\文件\\测试文件\\宇智波鼬.txt";

    /**
     * 自己定义缓冲区
     * @throws Exception
     */
    @Test
    public void m1() throws Exception{
        BufferedReader br = new BufferedReader(new FileReader(path));
        char[] buf = new char[24];
        int count = 0;
        while((count=br.read(buf))!=-1){
            System.out.println((new String(buf,0,count)));
        }
        br.close();
    }

    /**
     * 读取一行
     * @throws Exception
     */
    @Test
    public void m2() throws Exception{
        BufferedReader br = new BufferedReader(new FileReader(path));
        System.out.println(br.readLine());
        br.close();
    }
}
