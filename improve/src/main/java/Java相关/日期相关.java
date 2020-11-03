package Java相关;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class 日期相关 {
    /**
     * 日期格式化
     */
    @Test
    public void test(){
        Date nowTime=new Date();
        System.out.println("处理前："+nowTime);

        SimpleDateFormat time=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        System.out.println("处理后："+time.format(nowTime));
    }

    /**
     * Calendar类的使用
     */
    @Test
    public void test2(){
        int y,m,d,h,mi,s;
        Calendar cal=Calendar.getInstance();
        y=cal.get(Calendar.YEAR);
        m=cal.get(Calendar.MONTH);
        d=cal.get(Calendar.DATE);
        h=cal.get(Calendar.HOUR_OF_DAY);
        mi=cal.get(Calendar.MINUTE);
        s=cal.get(Calendar.SECOND);
        System.out.println("现在时刻是"+y+"年"+m+"月"+d+"日"+h+"时"+mi+"分"+s+"秒");
    }
}
