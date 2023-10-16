package alexey.gritsenko.application.report.impl;

import alexey.gritsenko.application.report.TableStringUtils;



public class TableStringUtilsImpl implements TableStringUtils {
    @Override
    public String[] createTableString(final String productNameValue,
                                      final int productNameColumnLength,
                                      final String productCostValue,
                                      final int productCostColumnLength) {
        //Разделяем каждое значение по длине не более ширины колонки; 2 - это отступы по одному символу справа и слева
        String[] nameValueSplit = splitString(productNameValue, productNameColumnLength - 2);
        String[] costValueSplit = splitString(productCostValue, productCostColumnLength - 2);
        //выбираем максимальное из двух колонок количество занимаемых строк
        int countLine = Math.max(nameValueSplit.length, costValueSplit.length);
        String[] resultArray = new String[countLine + 1];

        //формируем строку
        for (int i = 0; i < countLine; i++) {
            StringBuilder sb = new StringBuilder();
            if (nameValueSplit.length > i) {
                sb.append("* ")
                        .append(nameValueSplit[i])
                        .append(" ".repeat(productNameColumnLength-nameValueSplit[i].length()-2))
                        .append(" * ");
            } else {
                sb.append("*").append(" ".repeat(productNameColumnLength - 1)).append(" * ");
            }
            if (costValueSplit.length > i) {
                sb.append(costValueSplit[i])
                        .append(" ".repeat(productCostColumnLength-costValueSplit[i].length()-2))
                        .append(" *");
            } else {
                sb.append(" ".repeat(productCostColumnLength - 2)).append("*");
            }
            resultArray[i] = sb.toString();
        }
        resultArray[countLine] = "*".repeat(1 + productNameColumnLength + 1 + productCostColumnLength + 1);
        return resultArray;
    }


    private String[] splitString(String value, int width) {
        return value.split("(?<=\\G.{" + width + "})");
    }

}