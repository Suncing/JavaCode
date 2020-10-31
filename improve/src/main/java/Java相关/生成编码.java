package Java相关;

import org.junit.Test;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class 生成编码 {
    private final static DecimalFormat df = new DecimalFormat("000");
    List<Integer> integerList = new ArrayList<>();

    @Test
    public void getCaseId(){
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        integerList.add(4);
        if (Collections.max(integerList) == 0){
            System.out.println(df.format(1));
        }else{
            System.out.println(df.format(Integer.parseInt(String.valueOf(Collections.max(integerList) + 1))));
        }
    }
}


