
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DataInput dataInput = new DataInput();
        // Запрос кол-ва участников
        int numberOfPersons = dataInput.numberOfPeople(scanner);
        // Ввод товара
        ArrayList<Product> listOfProducts = dataInput.productEntry(scanner);
        scanner.close();        // Закрыть сканер
        // Вывод счета, итога и причетающейся каждому суммы
        new DataOutput().outputOfResults(numberOfPersons, listOfProducts);
    }
}