/* класс описывает объект "Список товаров", который хранит все товары, введенные пользователем,
 стоимость товаров и общую сумму */


import java.util.Scanner;
public class ProductList {

    // поля
    private String name; // наименование товара
    private double price; // стоимость товара
    private String list = "Добавленные товары:\n"; // переменная для хранения списка товаров
    private double totalAmount = 0; // переменная для хранения общей стоимости всех товаров



    // методы
    public void setProductName() {
        Scanner scanName = new Scanner(System.in);
        while(true) {
            scanName.useDelimiter("\n");
            String product = scanName.next();
            if (product.isEmpty()) {
                System.out.println("Поле не может быть пустым. Пожалуйста, введите наименование товара");
            }
            else {
                name = (product.substring(0,1).toUpperCase()+product.substring(1)).trim(); // формат имени товара - с заглавной буквы
                break;
            }
        }
    }
    public String getProductName() {
        return name;
    }

    public void setProductPrice() {
        Scanner scanPrice = new Scanner(System.in);
        while (true) {
            try {
                double productPrice = scanPrice.nextDouble();
                if (productPrice >= 0) {
                    price = productPrice;
                    break;
                } else {
                    System.out.println("Ошибка. Стоимость не может быть отрицательной. Введите стоимость повторно");

                }
            } catch (Exception e) {
                System.out.println("Ошибка ввода. Пожалуйста введите стоимость товара повторно, отделяя копейки запятой (Пример: 123,45)");
                scanPrice.next();
            }
        }
    }

    public double getProductPrice() {
        return price;
    }

    public void updateList() {
        list = list + "- " + name + " : " + String.format("%.2f", price) + " руб.\n"; //
        totalAmount = totalAmount + price;
        System.out.println("Спасибо, Вы ввели товар: " + name + " стоимостью " + String.format("%.2f", price) + " руб.\n");
    }

    public String getList() {
        return list;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

}