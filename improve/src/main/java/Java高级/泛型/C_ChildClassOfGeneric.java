package Java高级.泛型;

class Parent<E>{
    private E value;

    public E getValue() {
        return value;
    }

    public void setValue(E value) {
        this.value = value;
    }
}

//声明时候不加泛型返回的就是Object类型
class Child01 extends  Parent{
    @Override
    public Object getValue() {
        return super.getValue();
    }
}

class Child02<T> extends Parent{
    @Override
    public Object getValue() {
        return super.getValue();
    }
}

//创建子类对象先要创建父类对象，子类会把类型传递给父类。所以两者类别必须一样。
class Child03<T> extends Parent<T>{
    @Override
    public T getValue() {
        return super.getValue();
    }

    @Override
    public void setValue(T value) {
        super.setValue(value);
    }
}

public class C_ChildClassOfGeneric {
    public static void main(String[] args) {
        Child03 c = new Child03();
        c.setValue(1);
        System.out.println(c.getValue());
    }
}
