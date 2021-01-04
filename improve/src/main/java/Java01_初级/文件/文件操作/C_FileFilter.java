package Java01_初级.文件.文件操作;

import org.junit.Test;

import java.io.File;
import java.io.FileFilter;

public class C_FileFilter {
    private static String path ="src\\main\\java\\Java初级\\文件\\生成文件";

    @Test
    public void m1() throws Exception {
        File file = new File(path);
        File[] files = file.listFiles();
        for (File f : files) {
            System.out.println(f);
        }
        System.out.println("-----------------------------------------------------------------------");

        File[] files2 = file.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                if(pathname.getName().endsWith("jpg")){
                    return true;
                }
                return false;
            }
        });
        for(File f2:files2){
            System.out.println(f2.getName());
        }
    }
}
