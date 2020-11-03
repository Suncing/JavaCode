package Java初级.文件.IO流代码;

import org.junit.Test;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class E_BufferedWrite {
    private static String path ="D:\\Zoom\\github\\JavaCode\\improve\\src\\main\\java\\Java初级\\文件\\生成文件\\大蛇丸.txt";

    @Test
    public void m1() throws Exception{
        BufferedWriter bw = new BufferedWriter(new FileWriter(path));
        bw.write("大蛇丸，日本漫画《火影忍者》及其衍生作品中的主要角色，原火之国木叶隐村的“三忍”之一，与自来也、纲手同为第三代目火影猿飞日斩的弟子。具有极其强大的实力和不死之身。\n" +
                "擅长研究忍术并渴望得到写轮眼。本身野心极大，由于目睹了太多人的死亡、知道生命是脆弱的而误入歧途，他认为人体中蕴含着一生都无法使用的力量，因此他想获得长生不老从而学习所有忍术，掌握世间的真理。\n" +
                "其野心被多次粉碎，在佐助与鼬一战中被鼬的十拳剑封印。后在第四次忍界大战中，从御手洗红豆和药师兜的身上看见了药师兜的失败，彻底醒悟。之后被佐助复活，与四位火影和鹰小队前往战场支援忍者联军。\n" +
                "忍界大战结束后，被允许在不伤害他人性命的前提下继续实验，如今制造了人造人巳杯、巳月， 并留在音忍村中生活。");
        bw.close();

    }
}
