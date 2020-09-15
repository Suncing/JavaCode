package Java初级.文件.IO流;

import org.junit.Test;

import java.io.FileInputStream;

public class A_FileInputStream {
    private static String path ="D:\\Zoom\\github\\JavaCode\\improve\\src\\main\\java\\Java初级\\文件\\测试文件\\春野樱.txt";

    /**
     * 一次读一个字节
     * @throws Exception
     */
    @Test
    public void m1() throws Exception{
        FileInputStream fis = new FileInputStream(path);
        int data=0;
        while((data=fis.read())!=-1){
            System.out.print((char)data);//读取的是ASCLL码
        }
        fis.close();
    }

    /**
     * 一次读多个字节
     * @throws Exception
     */
    @Test
    public void m2() throws Exception{
        FileInputStream fis = new FileInputStream(path);
        byte[] buf = new byte[1024];
        int count = 0;
        while((count=fis.read(buf))!=-1){//fis.read(buf)返回的是一个int数据，代表得到几个字符根据byte数组
            System.out.print(new String(buf));
        }

        fis.close();
    }
}
