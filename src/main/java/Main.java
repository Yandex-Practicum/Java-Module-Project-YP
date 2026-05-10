public class Main {
    public static void main(String[] args) {
        // Сначала работаем с данными от пользователя
        Car[] cars = Car.ProcessData();
        Race.ProcessLeader(cars);
    }
}