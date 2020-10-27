package Java初级;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class test {
    @Test
    public void test(){
        List list = new ArrayList();
        list.add("dadas");
        list.add("eqrq");
        list.add("aaa");
        int p =list.indexOf("aaa");
        System.out.println(p);
    }
}
