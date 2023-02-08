import java.util.ArrayList;
import java.util.Scanner;

public class Calculator {
 ArrayList<String> name = new ArrayList<>();
 ArrayList<Double> price = new ArrayList<>();
 int count = 1;
 double sum;
 double getSum() {return sum;}


public void newTovar() {
  Scanner scanner = new Scanner(System.in);
  while (true) {
   System.out.println("Введите товар № "+(count)+" или \"Завершить\", чтобы завершить ввод:");
   String nameInput = scanner.nextLine();
   if (nameInput.equalsIgnoreCase("Завершить")) {
    break;
   }
   System.out.println("Сколько стоит " + nameInput + "? (формат ввода: \"XXX,xx\"):");
   double priceInput;
   while (true) {
    if (scanner.hasNextDouble()) {
     priceInput = scanner.nextDouble();
     break;
    } else {
     System.out.println("Некорректный ввод, попробуйте еще раз");
    }
   }
   name.add(nameInput);
   price.add(priceInput);
   count++;
   sum += priceInput;
   System.out.println("Товар №"+count+ "\"" + nameInput + "\" успешно добавлен!");
  }

 }
 void print() {
  System.out.println("Добавленные товары: \n"+"\n"+"\n");
  RubFormat rub = new RubFormat();
  for (int i = 0; i < count; i++) {
   System.out.println(String.format("%2d ",(i + 1)) + String.format(" |%-27s|",name.get(i)) + String.format("%7.2f", price.get(i))
           + rub.format(price.get(i))+ "\n"+ "\n");
  }
  System.out.println("ИТОГО:" + String.format("%7.2f", sum) + rub.format(sum));
 }


}
