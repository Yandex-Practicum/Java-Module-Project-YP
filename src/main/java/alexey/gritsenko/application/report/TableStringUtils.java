package alexey.gritsenko.application.report;

public interface TableStringUtils {
    //если длина одного из значений
    String[] createTableString(String productNameValue,
                               int productNameColumnLength,
                               String productCostValue,
                               int productCostColumnLength);
}
