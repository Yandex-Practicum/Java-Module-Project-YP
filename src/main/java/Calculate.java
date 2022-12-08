import java.util.Scanner;

public class Calculate { // в классе реализовано добавление позиций и их цену, защита от невалидного ввода, и завершение программы
    String fullNamePosition;
    float fullPricePosition;
    static float billPerPerson;

    public static String jobCalculate(String fullNamePosition, float fullPricePosition, String conversationCase, int numberPeople) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nВведите название позиции: ");
            String namePosition = scanner.nextLine();
            fullNamePosition = fullNamePosition + "\n" + namePosition;

            if ("Завершить".equalsIgnoreCase(namePosition)) {
                String outputCalculate = String.format("\nСписок товаров добавленных в корзину: %s \n\nОбщая сумма товаров: %.2f руб" + conversationCase, fullNamePosition, fullPricePosition);
                billPerPerson = fullPricePosition / numberPeople;
                return outputCalculate;
            } else {
                System.out.println("Введите цену позиции в формате - рубли.копейки, например 10.45 или 11.40");
                while (true) {
                    if (scanner.hasNextFloat()) {
                        float pricePosition = scanner.nextFloat();
                        fullPricePosition = pricePosition + fullPricePosition;

                        System.out.println("\nТовар успешно добавлен в корзину! \nХотите добавить еще одну позицию? " +
                                "\nЕсли это все, что вы хотели добавить в счет, то напишите \"Завершить\"");
                        scanner.nextLine();
                    } else {
                        System.out.println("Не корректный ввод! Напишите цену позиции в формате - рубли.копейки, например 10.45.");
                        break;
                    }
                }
            }
        }
    }
}