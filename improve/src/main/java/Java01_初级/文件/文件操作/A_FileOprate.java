package Java01_初级.文件.文件操作;

import org.junit.Test;

import java.io.File;
import java.util.Date;

public class A_FileOprate {
    private static String path1 ="src\\main\\java\\Java初级\\文件\\生成文件\\宇智波泉奈.txt";
    private static String path2 ="src\\main\\java\\Java初级\\文件\\生成文件\\宇智波之止水.txt";
    private static String path3 ="src\\main\\java\\Java初级\\文件\\生成文件\\宇智波之斑.txt";

    @Test
    public void m1(){
        System.out.println("路径分隔符："+ File.separator);
        System.out.println("名称分隔符："+File.separator);

    }

    /**
     * 创建文件
     * @throws Exception
     */
    @Test
    public void m2() throws Exception{
        File file = new  File(path1);
        //如果文件不存在就创建
        if(!file.exists()){
           boolean b = file.createNewFile();
            System.out.println(b);
        }
    }

    /**
     * 删除文件
     */
    @Test
    public void m3() throws Exception{
        File file = new  File(path2);
        //如果文件不存在就创建
        if(!file.exists()){
            boolean b = file.createNewFile();
            System.out.println(b);
        }
        file.delete();//直接删除
        file.deleteOnExit();//jvm退出自动删除
    }

    /**
     * 获取文件信息
     */
    @Test
    public void m4() throws Exception{
        File file = new  File(path3);
        //如果文件不存在就创建
        if(!file.exists()){
            boolean b = file.createNewFile();
            System.out.println(b);
        }
        System.out.println("获取文件绝对路径："+file.getAbsolutePath());
        System.out.println("获取文件你写的路径："+file.getPath());
        System.out.println("获取文件名称："+file.getName());
        System.out.println("获取文件父路径："+file.getParent());
        System.out.println("获取文件长度："+file.length());
        System.out.println("获取文件创建时间"+new Date(file.lastModified()).toLocaleString());

        //判断
        System.out.println("是否可写："+file.canWrite());
        System.out.println("是否文件："+file.isFile());
        System.out.println("是否隐藏："+file.isHidden());
    }
}
