import java.util.Scanner;

public class Calc {
    float sum=0;
    String nameOfThings="";

    void calcSum(){
        Thing th = new Thing();
        th.askAboutThing();
        nameOfThings += th.nameThing+"\n";
        sum+=th.price;
        System.out.println("Товар успешно добавлен!");
    }
    void askAboutThings(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Хочешь добавить товар? Нажмите завершить, чтобы выйти");
        String continueAdd = scanner.next();
        while (!continueAdd.equalsIgnoreCase("завершить")){
            calcSum();
            System.out.println("Хочешь добавить ещё товаров? Нажмите завершить, чтобы выйти");
            continueAdd = scanner.next();
        }
    }
}
