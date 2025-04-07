import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Auto> autos = new ArrayList<>();
        int i = 0;
        while (autos.size()<3){
            ++i;
            System.out.printf("Введите модель %d-го автомобиля\n",i);
            String modelAuto = scanner.next();
            if (modelAuto.isEmpty()){
                System.out.println("Название модели не может быть пустым");
                --i;
                continue;
            }
            while (autos.size()<3) {
                System.out.printf("Введите скорость %d-го автомобиля\n", i);
                int speedAuto = 0;
                if (scanner.hasNextInt() && scanner.hasNext()) {
                    speedAuto = scanner.nextInt();
                } else {
                    System.out.println("Ошибка! Введите целое число.");
                    scanner.next();
                }
                if (speedAuto <= 250 && speedAuto > 0) {
                    Auto auto = new Auto(modelAuto, speedAuto);
                    autos.add(auto);
                    break;
                } else {
                    System.out.println("Ошибка! Максимальная скорость 250км/час");
                    continue;
                }
            }
        }
        Race race = new Race(autos);
        System.out.printf("Самая быстрая машина: %s, она проехала %dкм.\n", race.winnerModel, race.winnerWay);
    }
}
class Auto{
    String modelAuto;
    int speedAuto;
    Auto(String modelAuto, int speedAuto){
        this.modelAuto=modelAuto;
        this.speedAuto=speedAuto;
    }
}
class Race {
    String winnerModel="1";
    int winnerWay=1;
    Race(ArrayList<Auto> autoWay) {
        for (Auto element : autoWay) {
            if (this.winnerWay < element.speedAuto * 24){
                this.winnerModel = element.modelAuto;
                this.winnerWay = element.speedAuto * 24;
            }
        }
    }
}

