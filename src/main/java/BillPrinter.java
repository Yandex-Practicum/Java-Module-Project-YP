public class BillPrinter {
    private final BillCalculator instance = new BillCalculator();
    private final String rublesTot = takeCur((int) instance.totalCost, "rub");
    private final String copsTot = takeCur((int) (instance.totalCost * 100 % 100), "cop");
    private final String rublesPer = takeCur((int) instance.personalCost, "rub");
    private final String copsPer = takeCur((int) (instance.personalCost * 100 % 100), "cops");

    private String takeCur(int price, String currency) {
        String local = String.valueOf(price);
        if (local.matches("\\d*1")) {
            return local + " " + (currency.equals("rub") ? "рубль." : "копейка.");
        } else if (!local.matches("\\d*1\\d") && local.matches("\\d*[234]")) {
            return local + " " + (currency.equals("rub") ? "рубля." : "копейки.");
        } else return local + " " + (currency.equals("rub") ? "рублей." : "копеек.");

    }

    public void output() {
        System.out.println("\nДобавленные товары:");
        for (Purchase purchase : instance.bill) {
            String rubs = takeCur((int) purchase.price, "rub");
            String cops = takeCur((int) (purchase.price * 100 % 100), "cop");
            System.out.println(purchase.name + " - " + rubs + " " + cops);
        }
        System.out.println("Общая сумма счёта: " + rublesTot + " " + copsTot);
        System.out.println("Каждый человек должен заплатить: " + rublesPer + " " + copsPer);
    }
}
