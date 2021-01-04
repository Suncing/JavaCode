package Java01_初级.文件.文件操作;

import java.io.File;

public class D_RecursivelyTraverseFolder {
    private static String path ="src\\main\\java\\Java初级\\文件\\生成文件";

    public static void main(String[] args) {
        listDir(new File(path));
    }

    /**
     * 递归遍历
     * @param dir
     */
    private static void listDir(File dir) {
        File[] files=dir.listFiles();
        System.out.println(dir.getAbsolutePath());

        if(files!=null&&files.length>0){
            for (File file:files){
                if(file.isDirectory()){
                    listDir(file);
                }else{
                    System.out.println(file.getAbsolutePath());
                }
            }
        }
    }


    /**
     * 递归删除
     */
    public static void deleteDir(File dir){
        File[] files = dir.listFiles();
        if(files!=null&&files.length>0){
            for (File file:files){
                if(file.isDirectory()){
                    deleteDir(file);
                }else{
                    System.out.println(file.getAbsolutePath()+"删除"+file.delete());
                }
            }
        }
        System.out.println(dir.getAbsolutePath()+"删除"+dir.delete());
    }


}
