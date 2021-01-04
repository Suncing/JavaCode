package Java02_高级.泛型;

import java.util.ArrayList;
import java.util.List;

class Animal {
    private String name="Animal";
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}

class Cat extends Animal {
    private String name="Cat";
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}


class Dog extends Animal {
    private String name="Dog";
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}

public class A_FristCaseOfGeneric {
    public static void main(String[] args) {
        List<Animal> list=new ArrayList();
        list.add(new Animal());
        list.add(new Dog());
        list.add(new Cat());
        //下面直接报错 list.add(new After());

        //不用泛型之前可以给容器中任意加元素
//        List list=new ArrayList();
//        list.add(new 泛型.A例子概述.Animal());
//        list.add(new 泛型.A例子概述.Dog());
//        list.add(new 泛型.A例子概述.Cat());
//        list.add(new Before());
    }
}
