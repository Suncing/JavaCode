package Java01_初级.文件.IO操作;

import org.junit.Test;

import java.io.FileOutputStream;

public class A_FileOutputStream {
    private static String path ="src\\main\\java\\Java初级\\文件\\生成文件\\木叶丸.txt";

    /**
     * 单个写入
     * @throws Exception
     */
    @Test
    public void m1() throws Exception{
        FileOutputStream fos = new FileOutputStream(path,true);
        fos.write(97 );
        fos.write('b');
        fos.close();
    }

    /**
     * 多个写入
     */
    @Test
    public void m2() throws Exception{
        FileOutputStream fos = new FileOutputStream(path);
        String string = "猿飞木叶丸，日本漫画《火影忍者》及其衍生作品中的男性角色。第三代火影猿飞日斩的长孙，" +
                "第十班指导上忍猿飞阿斯玛的侄子。" +
                "从小便立志当上火影，后结识了漩涡鸣人，他对鸣人十分崇拜而认其做大哥并向其学习，" +
                "对于木叶丸来说鸣人有着不可取代的影响力，鸣人不仅是他的师傅、伙伴、崇拜的对象，同时也是他的对手。" +
                "值得一提的是，木叶丸的名字是三代火影猿飞日斩所取的名字，这个名字也意味着木叶丸寄托了三代火影的希望。\n" +
                "第四次忍界大战结束后十几年，木叶丸已是优秀的上忍，并带领着鸣人长子漩涡博人在内的“木叶丸班”。";
        fos.write(string.getBytes());
        fos.close();
    }
}
