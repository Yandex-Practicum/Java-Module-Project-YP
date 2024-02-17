public class Calculator {
    static double AllProductPrice = 0.00;
    static int guestNumber;

    static String guestBill;
    public static void setAllProductPrice(double productPrice) {
        AllProductPrice+=productPrice;
    }

    public static String getGuestBill(int enterGuestNumber) {
        guestNumber = enterGuestNumber;
        guestBill = String.format("%.2f", AllProductPrice/guestNumber);;
        return guestBill;
    }

}
