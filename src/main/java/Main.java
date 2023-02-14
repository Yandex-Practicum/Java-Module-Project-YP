// dev branch for Y.Practicum
public class Main {

    public static void main(String[] args) {
        // ваш код начнется здесь
        // вы не должны ограничиваться только классом Main и можете создавать свои классы по необходимости
        Calculator check = new Calculator();
        int getCount = Count.count();

        check.newTovar();
        check.print();

        double checkPerOne = check.getSum()/ getCount;
        RubFormat rub = new RubFormat();
        System.out.println("Вас было "+ getCount +", значит с каждого по " + String.format("%.2f", checkPerOne) + rub.format(checkPerOne));

    }
    }

