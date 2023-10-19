
import java.util.ArrayList;

public class DataOutput {
    // Вывод итогов
    public void outputOfResults (int numberOfPersons, ArrayList<LineOfBill> listOfProducts) {
        float sumBill = 0;
        System.out.println("Добавленные товары:\n");    // Заголовок
        for (LineOfBill item : listOfProducts) {
            float prise = item.getPrise();
            sumBill = sumBill + prise;
            System.out.println(String.format("%s ..... %.2f", item.getName(), prise));
        }
        System.out.println(String.format("---------------------" + "Итого по счету:   %.2f\n", sumBill));         // Подчеркивание и вывод итоговой суммы по счету
        double fromEveryPerson = sumBill / numberOfPersons;
        System.out.println(String.format("\nГоспода, с Вас по:   %.2f " + rubles(fromEveryPerson) + "%n", fromEveryPerson));    // Вывод доли счета
    }

    // Правильное окончание слова "рубль"
    private String rubles (double fromEveryPerson) {
        int lastDigit = ((int) fromEveryPerson) % 10;   // Получаем последнюю цифру целой части
        String s;
        if (lastDigit == 0) {
            s = "рублей";
        } else if (lastDigit == 1) {
            s = "рубль";
        } else if (lastDigit < 5) {
            s = "рубля";
        } else {
            s = "рублей";
        }
        return s;
    }
}
