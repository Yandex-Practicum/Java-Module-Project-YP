import core.Communicator;
import exceptions.PersonsAboveZeroException;
import exceptions.PersonsOnlyException;
import exceptions.PersonsZeroException;
import models.Good;
import services.GoodsReadIterator;
import utils.Consts;

import java.util.ArrayList;

public class Calculator {
    private final Communicator communicator;
    private final GoodsReadIterator iterator;
    private final ArrayList<Good> goods;
    private final int personsQuantity;
    private Calculator(Communicator communicator, int quantity){
        this.communicator = communicator;
        this.iterator = new GoodsReadIterator(this.communicator);
        this.personsQuantity = quantity;
        goods = new ArrayList<>();
    }

    public static Calculator createInstance(int quantity, Communicator communicator) {
        if(quantity == 1) {
            throw new PersonsOnlyException(Consts.ONLYPERSON_MESSAGE);
        } else if (quantity == 0) {
            throw new PersonsZeroException(Consts.ZEROPERSONS_MESSAGE);
        } else if (quantity < 0) {
            throw new PersonsAboveZeroException(Consts.LOWPERSONS_MESSAGE);
        }
        return new Calculator(communicator, quantity);
    }

    public void readGoods() {
        do {
            var good = iterator.next();
            goods.add(good);
            communicator.showNotification(Consts.ADD_SUCCESS_PROMT);
        } while(iterator.hasNext());
    }

    public ArrayList<Good> getGoods() {
        return goods;
    }

    public double totalPrice() {
        return getGoods().stream().mapToDouble(Good::getPrice).sum();
    }

    public void printGoods() {
        communicator.showNotification(Consts.ENTER_COMPLETE_PROMT);
        for(var good: getGoods()) {
            communicator.showNotification(good.toString());
        }
        var sharedPrice = totalPrice() / personsQuantity;
        communicator.showNotification(String.format("Общий счет %.2f", totalPrice()));
        communicator.showNotification(String.format("На каждого из %d человек по %.2f", personsQuantity, sharedPrice));
    }
}
