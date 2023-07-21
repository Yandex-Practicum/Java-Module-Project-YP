import java.util.stream.Collectors;

class Reporter {

    private static final String DELIMITER = "-";

    private static void printDelimiter() {
        System.out.println(DELIMITER.repeat(30));
    }

    public static void getFullReport(Calculator calculator) {
        System.out.println("[[[\t\tОтчет\t\t]]]");
        printDelimiter();

        System.out.println("Добавленные товары:");
        System.out.println(
                calculator.getItems().stream().map(Item::toString)
                        .collect(Collectors.joining("\n"))
        );
        printDelimiter();

        double amountPerPerson = calculator.getPerPersonAmount();

        System.out.printf(
                "\nКаждый из вас должен заплатить по %.2f %s\n",
                amountPerPerson,
                currencyPostfix(amountPerPerson)
        );
    }

    private static String currencyPostfix(double amount) {
        int number = (int)amount;
        int numberLastDigit = number % 10;

        if ((number > 5 && number < 20) || (numberLastDigit == 0 || numberLastDigit > 4)) {
            return "рублей";
        } else if (numberLastDigit == 1) {
            return "рубль";
        } else {
            return "рубля";
        }
    }
}