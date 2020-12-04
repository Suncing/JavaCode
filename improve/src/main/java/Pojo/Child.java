package Pojo;


public class Child extends Father {
    public Child(){
        super();//子类的构造方法中默认就会调用父类的构造方法
    }

    public void childMethod(){
        System.out.println("子类普通方法");
    }

    @Override
    public void fatherMethod(){
        super.fatherMethod();
        System.out.println("子类重写父类普通方法");
    }
}
