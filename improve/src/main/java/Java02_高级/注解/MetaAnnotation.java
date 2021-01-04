package Java02_高级.注解;

import java.lang.annotation.*;

@MyAnnotation
public class MetaAnnotation {

    @MyAnnotation
    public void test(){

    }
}


//@Documented表示是否将我们的注解生成到JAVAdoc中
@Documented
//@Inherited表示子类是否可以继承父类的注解
@Inherited

/**
 * 重点两个
 */
//@Target表示注解可以用到哪些地方
@Target(value = {ElementType.METHOD,ElementType.TYPE})

//@Retention表示注解什么时候有效
@Retention(value = RetentionPolicy.RUNTIME)
@interface MyAnnotation{

}
