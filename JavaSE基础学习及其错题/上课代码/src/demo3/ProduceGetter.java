package demo3;

import java.util.ArrayList;
import java.util.Random;

/**
 * 抽奖器
 * @param <T>
 */

public class ProduceGetter<T> {
    Random random = new Random();

    //奖品
    private T product;

    //奖品集合
    ArrayList<T> list = new ArrayList<>();

    //添加奖品
    public void addProduct(T t){
        list.add(t);
    }


    //抽奖
    public T getProduct(){
        product = list.get(random.nextInt(list.size()));
        return product;
    }
}
