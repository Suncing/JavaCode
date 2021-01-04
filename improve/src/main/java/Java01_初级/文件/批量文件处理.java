package Java01_初级.文件;

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
        String path = "C:\\Users\\zhangpan\\Desktop\\蓝狐\\包急\\";
        File file = new File(path);
        File[] files = file.listFiles();
        for(File file1:files){
            if(file1.isFile()){
                file1.renameTo(new File(path,file1.getName()+".png"));
            }
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
