package Java初级.文件.IO操作;

import org.junit.Test;

import java.io.FileReader;

public class D_FileRead {
    private static String path ="src\\main\\java\\Java初级\\文件\\生成文件\\木叶丸.txt";

    /**
     * 没有缓冲区
     * @throws Exception
     */
    @Test
    public void m1() throws Exception{
        FileReader fr = new FileReader(path);
        int data=0;
        while((data=fr.read())!=-1){
            System.out.println((char)data);
        }
        fr.close();
    }

    /**
     * 带有缓冲区
     * @throws Exception
     */
    @Test
    public void m2() throws Exception{
        FileReader fr = new FileReader(path);
        char[] buf = new char[24];
        int count=0;
        while((count=fr.read(buf))!=-1){
            System.out.println((new String(buf,0,count)));
        }
        fr.close();
    }

}
