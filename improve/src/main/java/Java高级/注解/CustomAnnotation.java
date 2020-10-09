package Java高级.注解;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;

public class CustomAnnotation {

    @MyAnnotation2(name = "Jay",age=41,id=1)
    public void test(){
    }

    @MyAnnotation3("j")
    public void test2(){
    }
}

@Target({TYPE,METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation2{
    String name() default "";
    int age();
    int id() default -1;

    String[] schools() default {"西部开源","清华大学"};
}

//当注解里面只有一个值，将其命名为value就能默认给其赋值
@Target({TYPE,METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation3{
    String value();
}