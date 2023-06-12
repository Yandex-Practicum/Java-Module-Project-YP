
public class Output {

    public static void output() {
        System.out.println(" Список добавленных товаров: " + Calculator.totalName);
        System.out.println(" Общая стоимость товаров: " + Calculator.totalPrice + " рублей");
        System.out.println(" Каждый должен заплатить по: " + Calculator.pricePerPersonFormat  + " рублей");
    }
}
