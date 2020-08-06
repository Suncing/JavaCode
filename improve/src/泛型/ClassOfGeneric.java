package 泛型;
//<T>泛型标识，也就是类型标识
//T是由外部定义的
class Generic<T>{
    private T key;

    public Generic(T key) {
        this.key = key;
    }

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "Generic{" +
                "key=" + key +
                '}';
    }
}
public class ClassOfGeneric {
    public static void main(String[] args) {
        //1.基本用法
        Generic<String> stringGeneric = new Generic<>("ABC");
        String key = stringGeneric.getKey();
        System.out.println(key);

        Generic<Integer> intGeneric = new Generic<>(123);
        Integer key2 = intGeneric.getKey();
        System.out.println(key2);

        //2.不指定类型按照object类型指定
        Generic generic = new Generic(122);
        Object key1 = generic.getKey();
        System.out.println(key1);

        //3.泛型不支持基本数据类型，因为object无法持有基本数据类型
        //Generic<int> generic1 = new Generic<int>(100);

        //4.同一泛型类，根据不同的数据类型创建的对象，本质上是同一类型。就是Generic类型
        System.out.println(intGeneric.getClass());
        System.out.println(stringGeneric.getClass());
        System.out.println(intGeneric.getClass()==stringGeneric.getClass());
    }
}
