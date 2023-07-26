package services;

import core.Communicator;
import exceptions.PriceInputException;
import models.Good;
import utils.Consts;

import java.util.InputMismatchException;
import java.util.Iterator;

public class GoodsReadIterator implements Iterator<Good> {

    private final Communicator communicator;

    public GoodsReadIterator(Communicator communicator) {
        this.communicator = communicator;
    }

    private Good readNextGood() {
        var priceInputCount = 0;
        var goodName = communicator.readString(Consts.ENTER_GOODNAME_PROMT);
        double price = -1.0;
        while((price <= 0) && priceInputCount < Consts.MAX_RETRY_PROMTS) {
            try {
                price = communicator.readDouble(Consts.ENTER_PRICE_PROMT);
                priceInputCount ++;
                if(price < 0){
                    throw new InputMismatchException(Consts.LOWPRICE_MESSAGE);
                }
            } catch (InputMismatchException e) {
                communicator.showNotification(
                        String.format(Consts.RED + "Ошибка ввода: %s. Повторите ввод" + Consts.RESET, e.getMessage()));
            }
            if(priceInputCount == Consts.MAX_RETRY_PROMTS) {
                throw new PriceInputException();
            }
        }
        return new Good(goodName, price);
    }

    @Override
    public boolean hasNext() {
        return communicator.readBoolean(Consts.FINAL_PROMT,
                n -> !n.equalsIgnoreCase(Consts.FINAL_TEMPLATE));
    }

    @Override
    public Good next()  {
        var good = readNextGood();
        if(good == null) {
            throw new PriceInputException();
        }
        return good;
    }
}
