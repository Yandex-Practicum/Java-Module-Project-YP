package service;

import java.util.List;

import model.Product;

public interface InvoiceCalculatorService {
    int chooseNumberOfPeopleNeedToSplitBill();

    void calculateTheAmountForEachPerson(int counterPeople, List<Product> productList);
}



