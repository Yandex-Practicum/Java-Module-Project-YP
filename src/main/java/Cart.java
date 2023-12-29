public class Cart {
    static String purchaseList = "";
    
    public void addPurchase(String name, double cost, String str) {
        if (purchaseList == "") {
            purchaseList = "Добавленные товары: \n\n" + name + ":     " + String.format("%.2f",cost) + str + "\n";
            System.out.println("Товар " + name + " стоимостью " + String.format("%.2f",cost) + str + " успешно сохранен");
        } else {
            purchaseList = purchaseList + name + ":     " + String.format("%.2f",cost) +  str + "\n";
            System.out.println("Товар " + name + " стоимостью " + String.format("%.2f",cost) + str + " успешно сохранен");
        }



    }

    public void printPurchaseList() {
        System.out.println(purchaseList);
    }
}
