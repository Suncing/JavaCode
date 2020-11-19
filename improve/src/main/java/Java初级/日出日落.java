package Java初级;

import java.util.Calendar;
import java.util.Date;
import com.luckycatlabs.sunrisesunset.SunriseSunsetCalculator;
import com.luckycatlabs.sunrisesunset.dto.Location;

public class 日出日落 {

    public 日出日落() {}

    public static String sunrise(Date date, double lon, double lat) {
        Location location = new Location(lat, lon);
        SunriseSunsetCalculator calculator = new SunriseSunsetCalculator(location, "Asia/Shanghai");
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        String officialSunrise = calculator.getOfficialSunriseForDate(cal);
        return officialSunrise;
    }

    public static String sunset(Date date, double lon, double lat) {
        Location location = new Location(lat, lon);
        SunriseSunsetCalculator calculator = new SunriseSunsetCalculator(location, "Asia/Shanghai");
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        String officialSunset = calculator.getOfficialSunsetForDate(cal);
        return officialSunset;
    }


}