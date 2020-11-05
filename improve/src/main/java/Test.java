import java.io.File;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.sql.Date;


public class Test {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sd = new SimpleDateFormat("yyy-MM-dd");
        java.util.Date date = new java.util.Date();
        System.out.println(date);

        System.out.println("String:"+sd.format(date));//String
        System.out.println(Date.valueOf(sd.format(date)).getClass().toString());


    }
}
