import java.util.ArrayList;

public class AutosArr {
    int racerQuantity = 3;
    ArrayList<Auto> autos = new ArrayList<>(racerQuantity);

    public void start(int racerQuantity) {
        System.out.println("Добро пожаловать на гонку 24 часа Ле-Мана!");
        System.out.println("В гонке участвуют " + racerQuantity + " гонщиков, давайте введем их данные!");
        autos = racersInput(racerQuantity);
        Auto leader = new Auto();
        leader = findLeader();
        System.out.println("Лидер этой гонки проедет "+ leader.speed*24+" км и это:");
        leader.print();

    }

    public Auto findLeader() {
        Auto lider = new Auto();
        lider = autos.getFirst();
        for (Auto currentAuto : this.autos) {
            // здесь лишняя итерация, если использовать цикл  forEach
            if (lider.speed < currentAuto.speed) {
                lider = currentAuto;
            }
        }
        return lider;
    }
    public static ArrayList<Auto>  racersInput(int racerQuantity){
        ArrayList<Auto> autos = new ArrayList<>(racerQuantity);

        for (int i = 0; i<racerQuantity;i++) {
            System.out.println("Введите данные "+(i+1)+"-го автомобиля");
            Auto temp = new Auto();
            temp.input();
            autos.add(temp);
        }
        return autos;
    }
}
