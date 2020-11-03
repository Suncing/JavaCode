package Java相关;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class 批量文件处理 {
    private static final String path = "src/main/resource/";

    /**
     * 批量生成文件
     * @throws IOException
     */
    @Test
    public void test() throws IOException {
        for(int i=0;i<20;i++) {
            File file = new File(path + i + ".txt");
            if (!file.exists()) {
                file.createNewFile();
            }
        }
    }
    /**
     * 批量修改文件名
     */
    @Test
    public void test2() throws IOException {
        File file = new File(path);
        if(file.isDirectory()){

        }
    }
}
