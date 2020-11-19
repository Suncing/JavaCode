package Java初级.面向对象;

import Pojo.Child;

public class Super理解{
    public static void main(String[] args) {
        Child child = new Child();
        child.childMethod();//会默认调用父类构造方法
        child.fatherMethod();
    }
}
