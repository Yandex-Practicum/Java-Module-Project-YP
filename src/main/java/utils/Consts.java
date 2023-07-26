package utils;

public class Consts {
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String ONLYPERSON_MESSAGE = "Покупетель только 1, нет смысла в калькуляторе";
    public static final String LOWPERSONS_MESSAGE = "Количество покупателей не может быть меньше нуля";
    public static final String LOWPRICE_MESSAGE = "Количество покупателей не может быть меньше нуля";
    public static final String ZEROPERSONS_MESSAGE = "Количество покупателей не может быть равно нулю";
    public static final String FINAL_PROMT = "Хотите добавить еще один товар? Для завершения введите завершить";
    public static final String FINAL_TEMPLATE = "ЗАВЕРШИТЬ";
    public static final String ENTER_GOODNAME_PROMT = "Введите название товара";
    public static final String ENTER_PRICE_PROMT = "Введите цену товара";
    public static final String INCORRECT_PROMT = "Введено некорректное значение";
    public static final String INTEGER_INCORRECT_PROMT = String.format("%s, ожидалось целое число", INCORRECT_PROMT);
    public static final String DOUBLE_INCORRECT_PROMT = String.format("%s, ожидалось вещественнное число", INCORRECT_PROMT);
    public static final int MAX_RETRY_PROMTS = 3;
    public static final String ENTER_PERSONS_PROMT = "Введите количество покупателей";
    public static final String ADD_SUCCESS_PROMT = "Товар успешно добавлен";
    public static final String ENTER_COMPLETE_PROMT = "Добавленные товары:\n";
}
