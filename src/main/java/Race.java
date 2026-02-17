import java.util.ArrayList;

public class Race {

    ArrayList<String> winners = new ArrayList<>();
    int maxDistance = 0; // чтобы записывать дистанцию лидера и сравнивать

    public void calculateDistance (Car car){
       int distance = car.speed * 24; //считаем дистанцию
       if (distance > maxDistance) {
           maxDistance = distance; //
           winners.clear(); // если появляется новый лидер, старого удаляем
           winners.add(car.name); // добавляем в список текущего лидера
       } else if (distance == maxDistance){
           winners.add(car.name); // если кто-то справился также как и лидер, добавляем в список
       }
    }
    public void printWinner(){
        System.out.println("Самая быстрая машина: "); // метод, который выдает победителя

        for (String winner : winners){
            System.out.println(winner);
        }
    }

   }


