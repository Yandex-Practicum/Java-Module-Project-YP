import java.util.Scanner;

public class Auto {
    String name;
    double speed;
    private double MAX_SPEED = 250.;
    public Auto(String name, double speed) {
        this.name = name;
        this.speed = speed;
    }

    public Auto(){
        this.name = "name";
        this.speed = 0;
    }
    public void input(){
        nameInput();
        speedInput();
    }
    private void nameInput(){
        System.out.println("Введите название автомобиля:");
        Scanner scanner = new Scanner(System.in);
        this.name = scanner.nextLine();
    }
    private void speedInput(){
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Введите скорость автомобиля " + this.name + " в км/ч:" );

            if (!scanner.hasNextDouble()) {
                System.out.println("Вы ввели не число!!! повторите ввод!!!\n\n");
                String temp= scanner.next();

            }
            else {

                this.speed = scanner.nextDouble();
                if ((this.speed > 0.) && (this.speed < MAX_SPEED)) {
                    break;
                }
                else {
                    System.out.println("Некорректное значение скорости, повторите ввод!!!\n\n");
                }
            }
        }
    }

    public void print(){
        System.out.println("Автомобиль " +this.name+ " со скоростью " + this.speed+ " км/ч;");
    }

}
