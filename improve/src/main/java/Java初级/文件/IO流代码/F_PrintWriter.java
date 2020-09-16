package Java初级.文件.IO流代码;

import org.junit.Test;

import java.io.PrintWriter;

public class F_PrintWriter {
    private static String path ="D:\\Zoom\\github\\JavaCode\\improve\\src\\main\\java\\Java初级\\文件\\测试文件\\zoom.txt";

    @Test
    public void m1() throws Exception{
        PrintWriter pw = new PrintWriter(path);

        pw.print('A');
        pw.print(true);
        pw.print(3.14);
        pw.print(97);

        pw.close();
    }
}
