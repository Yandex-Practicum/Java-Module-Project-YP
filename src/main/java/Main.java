import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);
            int person;

            System.out.println("Доброго времени суток...");

        while (true) {
            System.out.println("На скольких распределяем счет? :");
            person=scanner.nextInt();
            if (person<2) {
                if (person==1) {System.out.println("На одного делить бессмысленно...");}
                else {System.out.println("Это не серьезно....");}
            } else {
            Bill bill = new Bill();
            bill.start(person);
            break;

        }
    }
}

static class Tovar {
    public String name;
    public float cost;
}

static class Bill{
    ArrayList<Tovar> listTovar = new ArrayList<>();
    void start(int persons){
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Добавляем товар ? любой символ если да, если нет то 'Завершить'");
            String command = scanner.nextLine();
            if (command.equalsIgnoreCase("завершить")) {
                System.out.println("Ведем расчет...");
                calcCost(persons);
                break;} else {
                                System.out.println("Наименование товара :");
                                String tNam = scanner.nextLine();
                                System.out.println("Стоимость :");
                                float tCost=scanner.nextFloat();
                                scanner.nextLine();
                                addTovar(tNam,tCost);}
        }
    }

    void addTovar(String nam, float cos){
        Tovar tovar=new Tovar();
        tovar.name=nam;
        tovar.cost=cos;
        listTovar.add(tovar);
    }

    void calcCost(int p) {
        System.out.println("Вывожу список приобретенного:");
        float totalCost=0.00f;
        for (int i=0; i<listTovar.size(); i++) {
            Tovar tempTovar = listTovar.get(i);
            totalCost=totalCost+tempTovar.cost;
            System.out.println("Позиция "+i+ " наименование "+tempTovar.name+" стоимость "+tempTovar.cost);
        }
        System.out.println("Итого приобретено на сумму : "+totalCost+Formatter((int)totalCost));
        String messTemp="Сумма на каждого %.2f";
        float costPers = totalCost/p;
        System.out.println(String.format(messTemp,costPers)+" "+Formatter((int)costPers));
    }

    String Formatter (int i) {
        int tI = i - (i / 10) * 10;
        switch (tI) {
            case 1:
                return " рубль";
            case 2:
            case 3:
            case 4:
                return " рубля";
            default:
                return " рублей";
        }
    }
    }
}
