package Java01_初级.文件.IO操作;

import org.junit.Test;

import java.io.FileInputStream;

/**
 * FileInputStream读取的是字节
 * FileRead读取的是字符
 */
public class A_FileInputStream {
    private static String path ="src\\main\\java\\Java初级\\文件\\测试文件\\春野樱.txt";

    /**
     * 一次读一个字节
     * @throws Exception
     */
    @Test
    public void m1() throws Exception{
        FileInputStream fis = new FileInputStream(path);
        int data=0;
        while((data=fis.read())!=-1){
            //读取的是ASCLL码
            System.out.print((char)data);
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
        //fis.read(buf)返回的是一个int数据，代表得到几个字符根据byte数组
        while((count=fis.read(buf))!=-1){
            System.out.print(new String(buf));
        }
        fis.close();
    }
}
