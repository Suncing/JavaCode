class Father{
    public Father(){//构造方法没有参数没有返回值
        System.out.println("父类构造方法");
    }
    public void normalMethodFather(){
        System.out.println("父类普通方法");
    }
}

class Child extends Father{
    public Child(){
        super();//子类的构造方法中默认就会调用父类的构造方法
    }
    public void normalMethodChild(){
        System.out.println("子类普通方法");
    }
    public void normalMethodFather(){
        super.normalMethodFather();
        System.out.println("子类重写父类普通方法");
    }
}
public class SuperComprehend{
    public static void main(String[] args) {
        Child normalClass = new Child();
        normalClass.normalMethodChild();//会默认调用父类构造方法
        normalClass.normalMethodFather();
    }
}
