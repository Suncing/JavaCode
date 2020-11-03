package Java初级.文件.IO流代码;

import org.junit.Test;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class G_OutputStreamWriter {
    private static String path ="D:\\Zoom\\github\\JavaCode\\improve\\src\\main\\java\\Java初级\\文件\\测试文件\\自来也.txt";

    @Test
    public void m1() throws Exception{
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(path),"utf-8");
        osw.write("自来也，日本漫画《火影忍者》及其衍生作品中的男性角色。火之国木叶隐村的“三忍”之一，三代目火影猿飞日斩的弟子，四代目火影波风水门、长门、弥彦、小南、七代目火影漩涡鸣人的师父，被鸣人称为一生中最敬重的人。他指导鸣人修行，在鸣人成长的道路上起到重要作用。后到雨忍村刺探情报，结果不幸死于“晓”首领佩恩之手。");
        osw.close();
    }
}
