package Java初级.文件.IO流;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FileOpration {
    private static String sourcePath ="D:\\Zoom\\github\\JavaCode\\improve\\src\\Java初级\\文件\\测试文件\\";
    private static String targetPath ="D:\\Zoom\\github\\JavaCode\\improve\\src\\Java初级\\文件\\生成文件\\";

    public static void main(String[] args) {
        Set<String> specialFileNames = new HashSet<>();//特殊文件集合

        File file = new File(sourcePath);//创建一个file实例
        File[] files = file.listFiles();//返回一个抽象路径名数组，表示其中的文件。
        for(File dataFile:files){
            String dataFileName = dataFile.getName();//获得文件名称
            if(dataFileName.endsWith(".bat")){
                specialFileNames.add(dataFileName);//将特殊文件放入集合
            }
        }

        specialFileNames.parallelStream().forEach(specialFileName->{
            String targetSpecialFileNamesPath = targetPath + specialFileName.substring(0,specialFileName.lastIndexOf("."))+".json";//生成特殊文件路径名：D:\Zoom\github\JavaCode\improve\src\Java初级\文件\生成文件大木桶辉夜.json
            System.out.println(targetSpecialFileNamesPath);

            try {
                BufferedInputStream br = new BufferedInputStream(new FileInputStream((sourcePath+specialFileName)));//为特殊文件创建字符输入流
                FileOutputStream fos = new FileOutputStream(new File(targetSpecialFileNamesPath));
                byte[] bytes = new byte[1024];
                int n;
                while ((n = br.read(bytes)) != -1) {
                    fos.write(bytes, 0, n);// 写入到输出流
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
//        List<Integer> list = new ArrayList<>();
//        for(int i=1;i<100;i++)
//            list.add(i);
//        list.parallelStream().forEach(a->{
//            System.out.println(a);
//        });
    }
}
