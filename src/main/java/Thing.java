import java.util.Scanner;

public class Thing {
    String nameThing;
    float price=-1;
    void askAboutThing (){
        System.out.println("Введите название товара");
        Scanner scanner = new Scanner(System.in);
        nameThing = scanner.next();
        System.out.println("Введите стоимость товара в формате \"рубли,копейки\"");
        while (true){
            if (!scanner.hasNextFloat()) {
                System.out.println("Введите корректную стоимость товара в формате\"рубли,копейки\"");
                scanner.next();
            }
            else{
                price = scanner.nextFloat();
                if(price<=0){
                    System.out.println("Введите корректную стоимость товара в формате\"рубли,копейки\"");
                }
                else{
                    break;
                }
            }
        }
    }
}
