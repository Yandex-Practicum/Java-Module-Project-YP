// dev branch for Y.Practicum
public class Main {

    public static void main(String[] args) {
        // ваш код начнется здесь
        // вы не должны ограничиваться только классом Main и можете создавать свои классы по необходимости

        Count guestCount =  new Count();
        Calculator check = new Calculator();
        check.newTovar();
        check.print();

        double checkPerOne = check.getSum()/guestCount.count();
        RubFormat rub = new RubFormat();
        System.out.println("Вас было "+guestCount+", значит с каждого по " + String.format("%.2f", checkPerOne) + rub.format(checkPerOne));

    }
    }


