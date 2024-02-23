public class Calculator {
    double AllProductPrice = 0.00;
    int guestNumber;

    String guestBill;
    public void setAllProductPrice(double productPrice) {
        AllProductPrice+=productPrice;
    }


    public String getGuestBill(int enterGuestNumber) {
        guestNumber = enterGuestNumber;
        guestBill = String.format("%.2f", AllProductPrice/guestNumber);
        return guestBill;
    }

}
