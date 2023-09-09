import java.util.HashMap;

public class Main {
    public static int friendsCount;

    static UserInputs userInputs = new UserInputs();
    static UserInputs.StringInput stringInput = userInputs.new StringInput();
    static UserInputs.FloatInput floatInput = userInputs.new FloatInput();
    static UserInputs.IntInput intInput = userInputs.new IntInput();
    public static Product product = new Product();
    public static Formatter formatter = new Formatter();

    public static void setFriends() {
        while (friendsCount <= 1) {
            System.out.print("Введите число участников вечеринки: ");

            friendsCount = intInput.in();

            if (friendsCount > 1) break;

            System.out.println("Друзей должно быть больше чем " + friendsCount);
        }
    }

    public static void main(String[] args) {
        setFriends();

        String outTrigger = "завершить";

        System.out.println("Введите название товаров и их стоимость.");

        product.productsList = new HashMap<>();

        String wordCurrencyCost;

        while (true) {
            System.out.print("Введите название товара: ");
            String productName = stringInput.in();

            System.out.print("Введите стоимость товара: ");
            float productCost = floatInput.in();

            product.productsList.put(productName, productCost);

            System.out.println("Товар успешно добавлен.");

            float productsAmount = 0;
            for (HashMap.Entry<String, Float> product : product.productsList.entrySet()) {
                productsAmount += product.getValue();

                wordCurrencyCost = formatter.wordCaseCurrency(product.getValue());
                System.out.println("Добавленные товары: " + product.getKey() + ", стоимостью " + wordCurrencyCost);
            }

            product.productsAmount = productsAmount;
            wordCurrencyCost = formatter.wordCaseCurrency(productsAmount);

            System.out.println("Общая сумма товаров: " + wordCurrencyCost + "\n");
            System.out.println("Добавить еще товар? Введите любой символ для продолжения, или `Завершить` для вывода итога и выхода.");

            String enteredText = stringInput.in().toLowerCase();

            if (enteredText.equals(outTrigger)) break;
        }

        String amountPerFriend = formatter.wordCaseCurrency((float)product.productsAmount / (float)friendsCount);

        System.out.println("\nКаждый друг должен заплатить по " + amountPerFriend);
        System.out.println("\nЗавершено");
    }
}
