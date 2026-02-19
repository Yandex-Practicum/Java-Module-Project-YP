
public class Auto {
     String name; // наши переменные
     int speed;

    public Auto(String name, int speed) { // конструктор, нужен ли он?..
        this.name = name;
        this.speed = speed;
    }

    public String getName(){
       return  name;
    }

    public int getSpeed(){
        return  speed;

    }
}
