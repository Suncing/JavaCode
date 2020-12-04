import java.util.Calendar;
import java.util.Date;

public class Test {
    @org.junit.Test
    public void test(){
//      for(int i=10;i<54;i++){
//          System.out.print("split["+i+"]"+"+"+"\",\""+"+");
//      }
        String name ="asdasd.asd.EXE";
        int idx = name.indexOf(".");
        int dex2 = name.lastIndexOf(".");
        System.out.println(idx);
        System.out.println(dex2);
        String suf =name.substring(name.lastIndexOf(".")).toLowerCase();
        System.out.println(suf);
    }
}
