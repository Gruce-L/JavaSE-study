package demo3;

public class main {
    public static void main(String[] args) {
        //创建抽奖器对象
        ProduceGetter<String> stringProduceGetter = new ProduceGetter<>();
        String[] strProducts = {"苹果手机", "华为手机", "咖啡机"};

        //给抽奖器中填充奖品
        for (int i = 0; i <strProducts.length ; i++) {
            stringProduceGetter.addProduct(strProducts[i]);
        }

        //抽奖
        String product1 = stringProduceGetter.getProduct();
        System.out.println("您抽中了：" + product1);

        System.out.println("------------------------------");

        ProduceGetter<Integer> integerProduceGetter = new ProduceGetter<>();
        int[] intProducts = {10000, 5000, 3000, 1000, 500};
        for (int i = 0; i < intProducts.length; i++) {
            integerProduceGetter.addProduct(intProducts[i]);
        }

        Integer product2 = integerProduceGetter.getProduct();
        System.out.println("您抽中了：" + product2);

    }
}
