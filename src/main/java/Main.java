import java.util.*;

public class Main {
    public static final Scanner scanner = new Scanner(System.in);



    public static void main(String[] args) {

        //Запросили число гостей
        System.out.println("Сколько у нас гостей?");
        int peopleNumber = checkInputGuests();


        Product prod = new Product("", 0);
        Calculator calc = new Calculator("", 0);

        //Бесконечный ввод товаров до завершения
        String askToContinue;

        while (true){
            calc.addProduct();
            System.out.println("Хотите продолжить ввод товаров?\nДля продолжения введите любой символ\nДля завершения введите \"Завершить\" в любом регистре\n");
            askToContinue = scanner.next();
            if (askToContinue.equalsIgnoreCase("Завершить"))
                break;
        }

        //Подсчёт и вывод результатов
        System.out.println("Добавленные товары:\n" + calc.productNames);

        double oneGuestSum = calc.sumMoney / peopleNumber;
        int OGS = (int) Math.floor(oneGuestSum);
        String letter = checkCorrectLetter(OGS);
        System.out.println(String.format("Каждый должен заплатить: %.2f рубл%s", oneGuestSum, letter));


    }

    //Поиск правильного окончания слова рубль
    public static String checkCorrectLetter(int OGS){
        int temp = OGS % 100;
        if (temp % 10 == 1 && temp != 11)
            return "ь";
        else if ((temp % 10 == 2 || temp % 10 == 3 || temp % 10 == 4) && (temp != 12 && temp != 13 && temp!= 14))
            return "я";
        else
            return "ей";
    }


    //Проверка ввода корректного числа гостей
    public static int checkInputGuests(){
        int userInputInt;
        while (true) {

            String userInput = scanner.next();
            if (isInt(userInput)) {
                userInputInt = Integer.parseInt(userInput);
                if (userInputInt> 1)
                    break;
                else
                    System.out.println("Введите корректное число гостей больше 1!");
            } else
                System.out.println("Введите корректное число гостей!");

        }
        return userInputInt;
    }

    //Функция проверки на ввод целого числа
    public static boolean isInt(String x) throws NumberFormatException
    {
        try {
            Integer.parseInt(x);
            return true;
        } catch(Exception e) {
            return false;
        }
    }






}

