import java.util.ArrayList;
import java.util.Scanner;

public class Calculator {
 ArrayList<String> name = new ArrayList<>();
 ArrayList<Double> price = new ArrayList<>();
 int countter = 0;
 double sum;
 double getSum() {return sum;}


public void newTovar() {
  Scanner scanner = new Scanner(System.in);
  while (true) {
   System.out.println("Введите товар № "+(countter+1)+" или \"Завершить\", чтобы завершить ввод:");
   String nameInput = scanner.nextLine();
   if (nameInput.equalsIgnoreCase("Завершить")) {
    break;
   }
   System.out.println("Сколько стоит " + nameInput + "? (формат ввода: \"XXX,xx\"):");
   double priceInput;
   while (true) {
    if (scanner.hasNextDouble()) {
     priceInput = scanner.nextDouble();
     scanner.nextLine();
      if (priceInput < 1){
     System.out.println("Введите число больше 0");
     }
    else {break;}}
    else {
     System.out.println("Некорректный ввод, попробуйте еще раз");
     scanner.nextLine();
     }
   }
   name.add(nameInput);
   price.add(priceInput);
   countter++;
   sum += priceInput;
   System.out.println("Товар №"+countter+ "\"" + nameInput + "\" успешно добавлен!");
  }
 }
 void print() {
  System.out.println("Добавленные товары: \n");
  RubFormat rub = new RubFormat();
  for (int i = 0; i < countter; i++) {
   System.out.println(String.format("%2d ",(i + 1)) + String.format(" |%-27s|",name.get(i)) + String.format("%7.2f", price.get(i))
           + rub.format(price.get(i))+ "\n"+ "\n");
  }
  System.out.println("ИТОГО:" + String.format("%7.2f", sum) + rub.format(sum));
 }


}
