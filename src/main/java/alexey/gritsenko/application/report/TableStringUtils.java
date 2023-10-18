package alexey.gritsenko.application.report;

public interface TableStringUtils {
    //если длина одного из значений
    String[] createTableString(String productNameValue,
                               int productNameColumnWidth,
                               String productCostValue,
                               int productCostColumnWidth);
    String[] concatenate(String[] a, String[] b);
    String costToString(String cost);
}
