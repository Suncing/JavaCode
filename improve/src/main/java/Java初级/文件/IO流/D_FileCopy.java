package Java初级.文件.IO流;

import org.junit.Test;

import java.io.FileReader;
import java.io.FileWriter;

/**
 * 字符流不能复制二进制文件
 */
public class D_FileCopy {
    private static String path1 ="D:\\Zoom\\github\\JavaCode\\improve\\src\\main\\java\\Java初级\\文件\\生成文件\\宇智波鼬.txt";
    private static String path2 ="D:\\Zoom\\github\\JavaCode\\improve\\src\\main\\java\\Java初级\\文件\\测试文件\\宇智波鼬.txt";

    @Test
    public void m1() throws Exception{
        FileReader fr = new FileReader(path1);
        FileWriter fw = new FileWriter(path2);

        int date=0;
        while((date=fr.read())!=-1){
            fw.write(date);
        }
        fr.close();fw.close();
    }
}
