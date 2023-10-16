package alexey.gritsenko.application.report.impl;

import alexey.gritsenko.application.report.TableStringUtils;




public class TableStringUtilsImpl implements TableStringUtils {
    @Override
    public String[] createTableString(final String productNameValue,
                                      final int productNameColumnWidth,
                                      final String productCostValue,
                                      final int productCostColumnWidth) {
        //Разделяем каждое значение по длине не более ширины колонки; 2 - это отступы по одному символу справа и слева
        String[] nameValueSplit = splitString(productNameValue, productNameColumnWidth - 2);
        String[] costValueSplit = splitString(productCostValue, productCostColumnWidth - 2);
        //выбираем максимальное из двух колонок количество занимаемых строк
        int countLine = Math.max(nameValueSplit.length, costValueSplit.length);
        String[] resultArray = new String[countLine + 1];

        //формируем строку
        for (int i = 0; i < countLine; i++) {
            StringBuilder sb = new StringBuilder();
            if (nameValueSplit.length > i) {
                sb.append("* ")
                        .append(nameValueSplit[i])
                        .append(" ".repeat(productNameColumnWidth-nameValueSplit[i].length()-2))
                        .append(" * ");
            } else {
                sb.append("*").append(" ".repeat(productNameColumnWidth - 1)).append(" * ");
            }
            if (costValueSplit.length > i) {
                sb.append(costValueSplit[i])
                        .append(" ".repeat(productCostColumnWidth-costValueSplit[i].length()-2))
                        .append(" *");
            } else {
                sb.append(" ".repeat(productCostColumnWidth - 1)).append("*");
            }
            resultArray[i] = sb.toString();
        }
        resultArray[countLine] = "*".repeat(1 + productNameColumnWidth + 1 + productCostColumnWidth + 1);
        return resultArray;
    }
    public String[] concatenate(String[] a, String[] b) {
        int aLen = a.length;
        int bLen = b.length;
        String[] c = new String[ aLen + bLen];
        System.arraycopy(a, 0, c, 0, aLen);
        System.arraycopy(b, 0, c, aLen, bLen);
        return c;
    }

    @Override
    public String costToString(String cost) {
       String[] digits = cost.split(",");
       char digit1 = digits[0].charAt(digits[0].length()-1);//выбираем первую цифру в целой части числа которая имеет значение
       char digit2 = digits[1].charAt(digits[1].length()-1);//то же самое для копеек
        String rub = switch (digit1) {
            case '1' -> "рубль";
            case '2', '3', '4' -> "рубля";
            default -> "рублей";
        };
        String cents = switch (digit2){
            case '1' -> "копейка";
            case '2', '3', '4' -> "копейки";
            default -> "копеек";
        };
        return digits[0]+" "+rub+" "+digits[1]+" "+cents;
    }

    private String[] splitString(String value, int width) {
        return value.split("(?<=\\G.{" + width + "})");
    }

}