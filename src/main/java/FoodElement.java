public class FoodElement {
<<<<<<< HEAD

    /*
    Калькулятор должен запоминать названия всех добавленных товаров, чтобы выводить все товары, которые были в него добавлены.
     */

    int counter;
    String foodName;
    String foodPrice;

    FoodElement(int counter, String foodName, String foodPrice) {
        this.counter = counter;
        this.foodName = foodName;
        this.foodPrice = foodPrice;
    }

    public String toString(){
        return "\n#"+counter+" — Название блюда: "+foodName+" — Цена в счёте: "+foodPrice+" р.";
    }
=======
    String foodName;
    float foodPrice;

    FoodElement(String foodName, float foodPrice) {
        this.foodName = foodName;
        this.foodPrice = foodPrice;
    }
>>>>>>> e149195 (ЧАСТЬ 2 // ПОКА НЕ РАБОТАЕТ КОРРЕКТНО // Добавил в Main.java перебор ввода с клавиатуры, чтобы собирать корректные названия и цены товаров.)
}
