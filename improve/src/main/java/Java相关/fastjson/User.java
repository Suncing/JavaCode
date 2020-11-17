package Java相关.fastjson;
import java.util.Date;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

@Data
public class User {

    private Integer   id;

    private String name;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;


}
