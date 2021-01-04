package Java01_初级.文件.IO操作;

import org.junit.Test;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class D_FileCoyp2 {
    private static String path1 ="src\\main\\java\\\\Java初级\\文件\\测试文件\\naruto.jpg";
    private static String path2 ="src\\main\\java\\Java初级\\文件\\生成文件\\narutoo.jpg";
    @Test
    public void m1() throws Exception{
        FileInputStream fis = new FileInputStream(path1);
        FileOutputStream fos = new FileOutputStream(path2);
        byte[] buf = new byte[1024];
        int count = 0;
        while((count=fis.read(buf))!=-1){
            fos.write(buf,0,count);
        }
        fis.close();
        fos.close();
    }
    /**
     * 为啥使用缓存区
     * FileInputStream/FileOutputStream 每次调用 read()/write() 都会触发一个 IO 操作
     * BufferedInputStream/BufferedOutputSteam 调用 read()/write() 并不会每次都触发一个 IO 操作
     * 只是写到内部的buffer里面，而只有内部的 buffer 满了或者调用 flush() 才会触发 IO 操作。、
     * IO 操作越少，性能越好。
     */
}
