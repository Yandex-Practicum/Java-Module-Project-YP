import java.util.Scanner; // импорт сканера

public class programActions {

    public static void addDish(int peoples) {

        class Bill {
            String dishName;
            double dishPrice;
        }


        boolean stopInput = false;
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);
        Bill currentBill = new Bill();
        currentBill.dishName = "";
        currentBill.dishPrice = 0;
        String currentName = "";

        while (stopInput == false) {
            System.out.println("Если есть желание ввести еще одну позицию счета - вводите, если хотите закончить - введите слово \"Завершить\" для выхода: ");
            currentName = scanner.nextLine();

            if (currentName.equals("Завершить")) {
                stopInput = true;
                currentBill.dishName += currentName + "\n";
                break;
            } else {
                currentBill.dishName += currentName + "\n";
                System.out.println("Введите стоимость блюда: ");
                currentBill.dishPrice += scanner1.nextDouble();
             }
        }
        showBill(currentBill.dishName, currentBill.dishPrice, peoples);
    }


    public static void showBill(String s, double sum, int quantity) {

      Scanner scanner = new Scanner(s);
      String billPosition = scanner.nextLine();
      System.out.println("\n \n \nПРИГОВОР \n");
      while(billPosition.equals("Завершить") == false)
    {
        System.out.println(billPosition);
        billPosition = scanner.nextLine();

    }
    System.out.println("Счет итого: " + sum);
    System.out.println("На каждого участника: " + sum / quantity);
}




}
