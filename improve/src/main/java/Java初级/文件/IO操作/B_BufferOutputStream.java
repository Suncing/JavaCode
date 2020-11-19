package Java初级.文件.IO操作;

import org.junit.Test;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

public class B_BufferOutputStream {
    private static String path ="src\\main\\java\\Java初级\\文件\\生成文件\\李洛克.txt";

    @Test
    public void m1() throws Exception{
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(path));
        for (int i=0;i<2;i++){
            bos.write(("李洛克是日本漫画《火影忍者》及其衍生作品中的男性角色，也是《李洛克的青春全力忍传》中的男主角。" +
                    "李洛克是火之国木叶忍者村的忍者，自称“木叶美丽的苍蓝野兽”。\r\n").getBytes());
            bos.flush();
        }
        bos.close();//内部会自动调用flush
    }
}
