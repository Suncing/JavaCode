package Java初级.文件.文件操作;

import org.junit.Test;

import java.io.File;
import java.util.Date;

public class B_FolderOprate {
    private static String path ="src\\main\\java\\Java初级\\文件\\生成文件夹\\生成文件夹的文件夹";
    private static String path2 ="src\\main\\java\\Java初级";

    @Test
    public void m1() throws Exception{
        File dir = new File(path);
        System.out.println(dir.toString());
        if(!dir.exists()){
//            dir.mkdir();//创建单级目录
        dir.mkdirs();
        }

        //删除
        dir.delete();//删除目录，必须是空目录
        dir.deleteOnExit();//jvm删除

        //获取文件夹信息
        System.out.println("获取文件绝对路径："+dir.getAbsolutePath());
        System.out.println("获取文件你写的路径："+dir.getPath());
        System.out.println("获取文件名称："+dir.getName());
        System.out.println("获取文件父路径："+dir.getParent());
        System.out.println("获取文件创建时间"+new Date(dir.lastModified()).toLocaleString());

        //判断
        System.out.println("是否文件夹："+dir.isFile());
        System.out.println("是否隐藏："+dir.isHidden());

        //遍历文件夹
        File dir2 = new File(path2);
        String[] files = dir2.list();
//        File[] files2 = dir2.listFiles();
        for(String string:files){
            System.out.println(string);
        }

    }
}
