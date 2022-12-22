import java.util.Scanner;

public class Calculate {
    String fullNamePosition = " ";
    float fullPricePosition = 0;


    public String addingPosition () {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nВведите название позиции: ");
            String namePosition = scanner.nextLine();

            if ("Завершить".equalsIgnoreCase(namePosition)) {
                return String.format("\nСписок товаров добавленных в корзину: %s", fullNamePosition);
            } else {
                addingPrice();
                fullNamePosition = fullNamePosition + "\n" + namePosition;

                System.out.println("\nТовар успешно добавлен в корзину! Добавьте еще одну позицию. " +
                        "\nЕсли это все, что вы хотели добавить в счет, то ниже напишите \"Завершить\"");
            }
        }
    }
    public float addingPrice() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите цену позиции в формате - рубли.копейки, например 10.45 или 11.40");

        while (true) {
            if (scanner.hasNextFloat()) {
                float pricePosition = scanner.nextFloat();
                if (pricePosition > 0) {
                    fullPricePosition = pricePosition + fullPricePosition;
                    break;
                }
                else {
                    System.out.println("Не корректный ввод! Напишите цену позиции в формате - рубли.копейки, например 10.45.");
                    scanner.nextLine();
                }
            }
            else {
                System.out.println("Не корректный ввод! Напишите цену позиции в формате - рубли.копейки, например 10.45.");
                scanner.nextLine();
            }
        }
        return fullPricePosition;
    }
}