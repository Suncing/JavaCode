package Java高级.泛型;

class Apple implements D_Generator<String> {
    @Override
    public String getKey() {
        return "周杰伦";
    }
}

class Pair<T,E> implements D_Generator<T> {
    private T key;
    private E value;

    public Pair(T key, E value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public T getKey() {
        return key;
    }

    public E getValue() {
        return value;
    }
}

public class D_GenericInterface {
    public static void main(String[] args) {
        Apple apple = new Apple();
        String s =apple.getKey();
        System.out.println(s);

        Pair<String,Integer> pair = new Pair<>("count",100);
        String key = pair.getKey();
        Integer value = pair.getValue();
        System.out.println(key+"---"+value);
    }
}
