public class CountCostForEveryPerson {
    void countCostForEveryPerson(double share, double people) {
        share = share / people;
        int remainder = (int) Math.floor(share);
        while (remainder > 10) {
            remainder = remainder % 10;
        }
        String ruble;
        switch (remainder) {
            case 1:
                ruble = " рубль";
                break;
            case 2:
            case 3:
            case 4:
                ruble = " рубля";
                break;
            default:
                ruble = " рублей";
                break;
        }

        System.out.println("Сумма с каждого человека составляет:\n" + String.format("%.2f", share) + ruble);
    }
}
