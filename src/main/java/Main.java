public class Main {

    public static void main(String[] args) {
        /* 1. После запуска программа должна спрашивать у пользователя,
        на скольких человек необходимо разделить счёт.*/
        System.out.println("Привет, на скольких людей мы хотим разделить счёт?");
        SplitTheBill bill = new SplitTheBill();
        bill.quantityQuestionaire();
        System.out.println("Число пользователей "+bill.personsQuantity);

        // ваш код начнется здесь
        // вы не должны ограничиваться только классом Main и можете создавать свои классы по необходимости

    }
}
