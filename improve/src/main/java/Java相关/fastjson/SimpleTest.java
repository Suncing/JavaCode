package Java相关.fastjson;
import java.util.Date;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;


public class SimpleTest {

    @Test
    public void serialize() {
        User user = new User();
        user.setId(11);
        user.setName("西安");
        user.setCreateTime(new Date());
        String jsonString = JSON.toJSONString(user);
        System.out.println(jsonString);
    }

    @Test
    public void deserialize() {
        String jsonString = "{\"createTime\":\"2018-08-17 14:38:38\",\"id\":11,\"name\":\"西安\"}";
        User user = JSON.parseObject(jsonString, User.class);
        System.out.println(user.getName());
        System.out.println(user.getCreateTime());
        System.out.println(user.toString());
    }

    @Test
    public void stringToJson() {
        String jsonString = "{\"createTime\":\"2018-08-17 14:38:38\",\"id\":11,\"name\":\"西安\"}";
        JSONObject obj=JSON.parseObject(jsonString);
        System.out.println(obj);
        System.out.println(obj.getClass().toString());
    }
}
