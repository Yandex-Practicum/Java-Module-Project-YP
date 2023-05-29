public class ReadLine {
    public int quantityPeople;

    public void oneLine() {
        while (!Main.scanner.hasNextInt()) {
            System.out.println("Введиде корректное число");
            Main.scanner.next();
        }
        quantityPeople = Main.scanner.nextInt();
        twoLine();
    }

    public void twoLine() {
        if (quantityPeople > 1) {
            System.out.println("Количество посетителей = " + quantityPeople +"\n");
            return;
        } else {
            System.out.println("Введите количество посетителей больше 1");
            oneLine();
        }
    }
}
