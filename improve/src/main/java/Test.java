import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 将二进制流转换成图片文件
 * @author 晚风工作室 www.soservers.com
 *
 */

public class Test {
    public static void main(String[] args) {
        List<String[]> strings = new ArrayList<>();
        String[] s = {"1","2"};
        String[] s1 = {"1","2"};
        strings.add(s);
        strings.add(s1);
        String jsonString = JSON.toJSONString(strings);
        System.out.println(jsonString);
    }
}

