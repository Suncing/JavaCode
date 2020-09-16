package Java初级.文件.IO流代码;

import org.junit.Test;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class A_FileCopy {
    private static String path1 ="D:\\Zoom\\github\\JavaCode\\improve\\src\\main\\java\\Java初级\\文件\\测试文件\\naruto.jpg";
    private static String path2 ="D:\\Zoom\\github\\JavaCode\\improve\\src\\main\\java\\Java初级\\文件\\生成文件\\narutoo.jpg";

    @Test
    public void m1() throws Exception{
        FileInputStream fis = new FileInputStream(path1);
        FileOutputStream fos = new FileOutputStream(path2);
        byte[] buf = new byte[1024];
        int count = 0;
        while((count=fis.read(buf))!=-1){
            fos.write(buf,0,count);
        }
        fis.close();fos.close();
    }
}
