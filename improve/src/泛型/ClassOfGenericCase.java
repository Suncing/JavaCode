package 泛型;

import java.util.ArrayList;
import java.util.Random;

class ProductGetter<T>{
    //奖品
    private T product;
    Random random = new Random();

    //奖品集合
    ArrayList<T> list = new ArrayList<>();


    //添加奖品
    public void addProduct(T t){
        list.add(t);
    }

    //抽奖
    public T getProduct(){//随机数不会超过list.size()
        product = list.get(random.nextInt(list.size()));
        return product;
    }
}

public class ClassOfGenericCase {
    public static void main(String[] args) {
        ProductGetter<String> stringProductGetter = new ProductGetter<>();
        String[] strProducts = {"苹果手机","苹果电脑","苹果手环","苹果"};
        for(int i = 0;i< strProducts.length;i++){
            stringProductGetter.addProduct(strProducts[i]);
        }

        String product = stringProductGetter.getProduct();
        System.out.println("您抽中了:"+product);
    }
}
