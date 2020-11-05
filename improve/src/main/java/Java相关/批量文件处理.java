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
        File[] files =file.listFiles();
        System.out.println(files.length);
        int i=1;

        File file1 = new File("D\\");

        for(File dateFile :files){
            String name = dateFile.getName();
            dateFile.renameTo(new File("漩涡鸣人影分身No." +i,"D:\\"));//不会更改文件内容
            System.out.println(name);
            i++;
        }
    }

    @Test
    public void test3(){
        File file = new File("D:\\");
        file.listFiles();
        for (File file1 : file.listFiles()){
            System.out.println(file1.getName());
        }
    }
}
