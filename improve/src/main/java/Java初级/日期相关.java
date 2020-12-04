package Java初级;

import org.junit.Test;
import utils.DateUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class 日期相关 {
    /**
     * 日期格式化
     */
    @Test
    public void test() throws ParseException {
        Date nowTime=new Date();
        System.out.println("处理前："+nowTime);
        SimpleDateFormat time=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("format是Date转String->处理后："+time.format(nowTime));
        System.out.println("parse是String转Date->处理后："+time.parse(time.format(nowTime)));

        System.out.println("==================================================================");
        //处理成数据库需要的日期格式
        SimpleDateFormat sd = new SimpleDateFormat("yyy-MM-dd");
        java.util.Date date = new java.util.Date();
        System.out.println("现在的日期是：     "+date);
        System.out.println("设置格式后转换为String类型：       "+sd.format(date));
        System.out.println("设置格式后转换为Date类型：     "+ java.sql.Date.valueOf(sd.format(date)));
        System.out.println("设置格式后转换为Date类型：     "+ java.sql.Date.valueOf(sd.format(date)).getClass().toString());
        System.out.println("====================================================================");

        String endDate = DateUtil.getCurrentDateStr(DateUtil.DATE_FORMAT_24);
        System.out.println(endDate);
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
        System.out.println(cal);
    }

    /**
     * Long转Date
     */
    @Test
    public void test3(){
        Calendar ca = Calendar.getInstance();
        Long  l = ca.getTimeInMillis();
        System.out.println(ca);
        System.out.println(l);

        Date date = new Date(l);
        System.out.println(date);
    }
}
